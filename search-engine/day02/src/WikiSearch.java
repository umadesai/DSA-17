import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.Comparator;

import redis.clients.jedis.Jedis;

public class WikiSearch{

    // map from URLs that contain the term(s) to relevance score
    private Map<String, Integer> map;

    public WikiSearch(Map<String, Integer> map) {
        this.map = map;
    }

    public Integer getRelevance(String url) {
        Integer relevance = map.get(url);
        if (relevance == null) {
            return 0;
        } else {
            return relevance;
        }
    }

    // Prints the contents in order of term frequency.
    private void print() {
        List<Entry<String, Integer>> entries = sort();
        for (Entry<String, Integer> entry: entries) {
            System.out.println(entry);
        }
    }

    // Computes the union of two search results.
    public WikiSearch or(WikiSearch that) {
        // TODO
//        Map<String, Integer> thatMap = that.map;
        for(String url: that.map.keySet()){
            map.put(url, this.getRelevance(url) + that.getRelevance(url));
        }
//        System.out.println(this.map.entrySet());
        return this;
    }

    // Computes the intersection of two search results.
    public WikiSearch and(WikiSearch that) {
        // TODO
//        Map<String, Integer> thatMap = that.map;
        Map<String, Integer> intersection = new HashMap<>();
        for(String url: that.map.keySet()){
            if(map.containsKey(url)){
                intersection.put(url, this.getRelevance(url) + that.getRelevance(url));
            }
        }
        return new WikiSearch(intersection);
    }

    // Computes the difference of two search results.
    public WikiSearch minus(WikiSearch that) {
        // TODO
//        Map<String, Integer> thatMap = that.map;
        for(String url: that.map.keySet()){
            if(map.containsKey(url)){
                map.remove(url);
            }
        }
        return this;
    }

    // Computes the relevance of a search with multiple terms.
    protected int totalRelevance(Integer rel1, Integer rel2) {
        // TODO
        return (rel1 + rel2);
    }

    // Sort the results by relevance.
    public List<Entry<String, Integer>> sort() {
        // TODO
        List<Entry<String, Integer>> sortList = new ArrayList<>(map.entrySet());
//        Collections.sort must take in a list
        Collections.sort(sortList, new Comparator<Entry>()
        {
            public int compare(Entry a, Entry b) {
                return ((Comparable)a.getValue()).compareTo(b.getValue());
            }
        }
        );
        return sortList;
    }

    // Performs a search and makes a WikiSearch object.
    public static WikiSearch search(String term, Index index) {
        // TODO: Use the index to get a map from URL to count

        // Fix this
        Map<String, Integer> map = index.getCounts(term);

        // Store the map locally in the WikiSearch
        return new WikiSearch(map);
    }

    // TODO: Choose an extension and add your methods here

    public static void main(String[] args) throws IOException {

        // make a Index
        Jedis jedis = JedisMaker.make();
        Index index = new Index(jedis); // You might need to change this, depending on how your constructor works.

        // search for the first term
        String term1 = "java";
        System.out.println("Query: " + term1);
        WikiSearch search1 = search(term1, index);
        search1.print();

        // search for the second term
        String term2 = "programming";
        System.out.println("Query: " + term2);
        WikiSearch search2 = search(term2, index);
        search2.print();

        // compute the intersection of the searches
        System.out.println("Query: " + term1 + " AND " + term2);
        WikiSearch intersection = search1.and(search2);
        intersection.print();
    }
}