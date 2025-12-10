package Practise.ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        solve(nums, 0, temp);
        return result;
    }

    private void solve(int[] nums, int index, List<Integer> temp){
        if(index >= nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        //Include
        temp.add(nums[index]);
        solve(nums, index + 1, temp);

        //After all the include operation done then exclude will come into place
        temp.remove(temp.size()-1);
        solve(nums, index + 1, temp);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subset solu = new Subset();
        System.out.println(solu.subsets(nums));
    }
}
