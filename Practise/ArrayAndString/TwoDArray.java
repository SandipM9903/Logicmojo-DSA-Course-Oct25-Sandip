package Practise.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArray {
    public static void main(String[] args) {

        //How to convert 2D int array to List<Integer>
        int[][] nums = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        System.out.println(Arrays.deepToString(nums));

        //How to convert to List
        List<List<Integer>> res = new ArrayList<>();
        for(int[] i : nums){
            List<Integer> temp = new ArrayList<>();
            for(int j : i){
                temp.add(j);
            }
            res.add(temp);
        }

        //How To convert 2D char array to List<String>
        char[][] alpha = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'}
        };

        List<String> result = new ArrayList<>();
        for(char[] i : alpha){
            result.add(new String(i));
        }
        System.out.println(result);
    }
}
