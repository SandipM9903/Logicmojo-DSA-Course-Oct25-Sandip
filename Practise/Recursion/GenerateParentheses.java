package Practise.Recursion;

import java.util.*;

//We can't use List<String> here because when we are calling "ans.add(stack.toString());" it is adding with comma separated which is like (,(,)

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backTrack(0, 0, n, stack, ans);
        return ans;
    }

    public void backTrack(int openN, int closeN, int n, StringBuilder stack, List<String> ans){
        //Base Condition
        if(openN == n && closeN == n){
            ans.add(stack.toString());
        }

        //Adding open brackets
        if(openN < n){
            stack.append('(');
            backTrack(openN+1, closeN, n, stack, ans);
            stack.deleteCharAt(stack.length()-1);
        }

        //Adding close brackets
        if(openN > closeN){
            stack.append(')');
            backTrack(openN, closeN+1, n, stack, ans);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
