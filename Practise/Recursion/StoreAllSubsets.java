package Practise.Recursion;

import java.util.ArrayList;
import java.util.List;
//Time Complexity : O(n * 2^n)
public class StoreAllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        getAllSubsets(nums, res, 0, result);
        return result;
    }

    public static void getAllSubsets(int[] nums, List<Integer> res, int i, List<List<Integer>> store){
        if(i == nums.length){
            //store all subsets
            store.add(new ArrayList<>(res));
            return;
        }

        //Include
        res.add(nums[i]);
        getAllSubsets(nums, res, i+1, store);

        //Exclude
        res.remove(res.size() - 1);
        getAllSubsets(nums, res, i+1, store);
    }
}
