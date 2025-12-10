package Practise.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateSubsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> allSubset = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        getAllSubset(nums, res, 0, allSubset);
        return allSubset;
    }

    static void getAllSubset(int[] nums, List<Integer> res, int i, List<List<Integer>> allSubset){
        if(i == nums.length){
            allSubset.add(new ArrayList<>(res));
            return;
        }
        //Include
        res.add(nums[i]);
        getAllSubset(nums, res, i+1, allSubset);

        //Exclude
        res.remove(res.size()-1);
        //Now Here We need to check for duplicate that if the next element is coming duplicate then we will skip the exclude part
        int next = i+1;
        while(next < nums.length && nums[next] == nums[i]){
            next++;
        }
        getAllSubset(nums, res, next, allSubset);
    }
}
