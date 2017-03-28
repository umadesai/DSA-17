import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtil {

    public static List<Integer>[] arrayToLists(Integer[][] A) {
        List[] l = new List[A.length];
        for (int i = 0; i < l.length; i++) {
            l[i] = Arrays.asList(A[i]);
        }
        return l;
    }


    public static List<Character>[] arrayToLists(Character[][] A) {
        List[] l = new List[A.length];
        for (int i = 0; i < l.length; i++) {
            l[i] = Arrays.asList(A[i]);
        }
        return l;
    }

    public static List<List<Character>> convertToLists(List<char[]> A) {
        List<List<Character>> l = new ArrayList<>();
        for (char[] c : A) {
            List<Character> k = new ArrayList<>();
            for (char v : c)
                k.add(v);
            l.add(k);
        }
        return l;
    }

}
