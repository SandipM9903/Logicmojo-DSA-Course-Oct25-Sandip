package Practise.ArrayAndString;

import java.util.*;

public class TopKFrequentElement {
    public int[] topKFrequent(int[] nums, int k) {
        // First finding the frequency
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1); // Update frequency: get current count (or 0 if not present) and
                                                      // add 1. {{freq.getOrDefault(4, 6) if I give 6 then also like if
                                                      // 4 was not there at present then it will give the value 6}}
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        // Now we need to convert the hashmap to list
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        System.out.println(list);

        // Sort the list
        list.sort((a, b) -> {
            return b.getValue() - a.getValue();
        });
        System.out.println("Sorted list :::: " + list);

        // Now we will store the max
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequentElement solu = new TopKFrequentElement();
        int[] nums = { 1, 1, 1, 2, 2, 2, 2, 2, 3, 3 };
        solu.topKFrequent(nums, 3);
    }
}
