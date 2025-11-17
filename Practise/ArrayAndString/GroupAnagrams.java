package Practise.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // System.out.print(s);
            char[] ch = s.toCharArray();
            // System.out.println();
            // System.out.print("ch : " + Arrays.toString(ch));
            Arrays.sort(ch);
            // System.out.println();
            // System.out.print("ch2 : " + Arrays.toString(ch));
            String key = new String(ch);
            // System.out.println();
            System.out.println("ch3 : " + key);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
            // bellow is the explaination for the above line.
            // if (!map.containsKey(key)) {
            //     map.put(key, new ArrayList<>());
            // }

            // map.get(key).add(s);

        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] input = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> grouped = groupAnagrams(input);
        System.out.println(grouped);
    }
}
