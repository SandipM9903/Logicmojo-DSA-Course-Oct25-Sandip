package Practise.Recursion;

import java.util.ArrayList;
import java.util.List;

//This is to Print All Subsets Not the leetcode problem

/*
* | Step | i | Action            | res BEFORE | res AFTER | Next Call             |
| ---- | - | ----------------- | ---------- | --------- | --------------------- |
| 1    | 0 | add arr[0] = 1    | []         | [1]       | predict(1)            |
| 2    | 1 | add arr[1] = 2    | [1]        | [1,2]     | predict(2)            |
| 3    | 2 | add arr[2] = 3    | [1,2]      | [1,2,3]   | predict(3)            |
| 4    | 3 | base case → print | [1,2,3]    | [1,2,3]   | return to Step3       |
| 5    | 2 | remove last (3)   | [1,2,3]    | [1,2]     | predict(3)            |
| 6    | 3 | base case → print | [1,2]      | [1,2]     | return to Step2       |
| 7    | 1 | remove last (2)   | [1,2]      | [1]       | predict(2)            |
| 8    | 2 | add arr[2] = 3    | [1]        | [1,3]     | predict(3)            |
| 9    | 3 | base case → print | [1,3]      | [1,3]     | return to Step8       |
| 10   | 2 | remove last (3)   | [1,3]      | [1]       | predict(3)            |
| 11   | 3 | base case → print | [1]        | [1]       | return to Step1       |
| 12   | 0 | remove last (1)   | [1]        | []        | predict(1)            |
| 13   | 1 | add arr[1] = 2    | []         | [2]       | predict(2)            |
| 14   | 2 | add arr[2] = 3    | [2]        | [2,3]     | predict(3)            |
| 15   | 3 | base case → print | [2,3]      | [2,3]     | return to Step14      |
| 16   | 2 | remove last (3)   | [2,3]      | [2]       | predict(3)            |
| 17   | 3 | base case → print | [2]        | [2]       | return to Step13      |
| 18   | 1 | remove last (2)   | [2]        | []        | predict(2)            |
| 19   | 2 | add arr[2] = 3    | []         | [3]       | predict(3)            |
| 20   | 3 | base case → print | [3]        | [3]       | return to Step19      |
| 21   | 2 | remove last (3)   | [3]        | []        | predict(3)            |
| 22   | 3 | base case → print | []         | []        | return → program ends |
* */
public class PrintSubsets {
    public static void predictSubsets(int[] arr, List<Integer> res, int i){
        if(i == arr.length){
            System.out.println(res);
            return;
        }
        //Include the subset
        res.add(arr[i]);
        predictSubsets(arr, res, i+1);

        //Exclude the subset
        res.remove(res.size() - 1);
        predictSubsets(arr, res, i+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> res = new ArrayList<>();
        predictSubsets(nums, res, 0);
    }
}