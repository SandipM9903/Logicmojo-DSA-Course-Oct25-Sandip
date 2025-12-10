package Practise.ArrayAndString;

import java.util.HashMap;
import java.util.Map;

public class TopFreqKelement{

    public int[] topKFreq(int[] nums, int k){
        //Finding the each elements freq
        Map<Integer, Integer> freq = new HashMap<>();
        for(int n : nums){
            freq.put(n, freq.getOrDefault(n,0)+1);
        }

        return null;
    }

    public static void main(String[] args) {
        
    }
}