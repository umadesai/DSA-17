import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.*;

import java.util.Set;

public class Index {

	// Index: map of words to URL and their counts
	private Map<String, Set<TermCounter>> index = new HashMap<>();
	Jedis jedis;

	public Index(Jedis jedis) {
		this.jedis = jedis;
	}
	public Index() {
	}

	/**
	 * Adds a URL to the set associated with ‘term‘.
	 */
    public void add(String term, TermCounter tc) {
		Set<TermCounter> set = get(term);
// if we’re seeing a term for the first time, make a new Set
		if (set == null) {
			set = new HashSet<TermCounter>();
			index.put(term, set);
		}
		set.add(tc);
		}


	public Set<TermCounter> get(String term) {
		return index.get(term);
	}

	private String urlSetKey(String term) {
		return "URLSet:" + term;
	}

	private String termCounterKey(String url) {
		return "TermCounter:" + url;
	}

	/**
	 * Looks up a search term and returns a set of URLs.
	 */
	public Set<String> getURLs(String term) {
		Set<String> set = jedis.smembers(urlSetKey(term));
		return set;
	}

	/**
	 * Returns the number of times the given term appears at the given URL.
	 */
	public Integer getCount(String url, String term) {
		String redisKey = termCounterKey(url);
		String count = jedis.hget(redisKey, term);
		return new Integer(count);
	}

	/**
	 * Pushes the contents of the TermCounter to Redis.
	 */
	public List<Object> pushTermCounterToRedis(TermCounter tc) {
		Transaction t = jedis.multi();
		String url = tc.getLabel();
		String hashname = termCounterKey(url);
// if this page has already been indexed; delete the old hash
		t.del(hashname);
// for each term, add an entry in the termcounter and a new
// member of the index
		for (String term: tc.keySet()) {
			Integer count = tc.get(term);
			t.hset(hashname, term, count.toString());
			t.sadd(urlSetKey(term), url);
		}
		List<Object> res = t.exec();
		return res;
	}

	public Map<String, Integer> getCounts(String term) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Set<String> urls = getURLs(term);
		for (String url: urls) {
			Integer count = getCount(url, term);
			map.put(url, count);
		}
		return map;
	}

	public void indexPage(String url, Elements paragraphs) {
		// make a TermCounter and count the terms in the paragraphs
		TermCounter counter = new TermCounter(url.toString());
		counter.processElements(paragraphs);
		for (String key:counter.keySet()){
			add(key,counter);
		}
		// push the contents of the TermCounter to Redis
		pushTermCounterToRedis(counter);
	}

	public void printIndex() {
		// loop through the search terms
		for (String term: keySet()) {
			System.out.println(term);

			// for each term, print the pages where it appears
			Set<TermCounter> tcs = get(term);
			for (TermCounter tc: tcs) {
				Integer count = tc.get(term);
				System.out.println("    " + tc.getLabel() + " " + count);
			}
		}
	}

	public Set<String> keySet() {
		return index.keySet();
	}

	public static void main(String[] args) throws IOException {

		WikiFetcher wf = new WikiFetcher();
		Jedis jedis = new JedisMaker().make();
		Index indexer = new Index(jedis);

		String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
		Elements paragraphs = wf.fetchWikipedia(url);
		indexer.indexPage(url, paragraphs);

		Map<String, Integer> map = indexer.getCounts("data");
		System.out.println(map.get(url));
//		System.out.print(map.keySet());
//		If we look up url in the result, map, we should get 339, which is the number
//		of times the word “the” appears on https://en.wikipedia.org/wiki/Java_
//		(programming_language)the Java Wikipedia page (that is, the version we
//				saved).

		indexer.printIndex();
	}

}
