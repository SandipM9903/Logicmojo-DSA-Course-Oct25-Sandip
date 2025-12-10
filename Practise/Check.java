import java.lang.reflect.Array;
import java.util.*;

public class Check {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        // // we cann't put like this map.put("ate", {"eat", "tea"}); : we will put like
        // map.put("ate", List.of("tea", "eat"));
        // //OR we can use
        // map.put("abt", Arrays.asList("bat", "tab"));

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr) + " ");
            String key = new String(arr);
            System.out.println("Key : " + key);
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(s);
            System.out.println("Map " + map);
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        Check solu = new Check();
        String[] arr = { "abc", "def", "eat", "tea" };
        solu.groupAnagrams(arr);
    }
}