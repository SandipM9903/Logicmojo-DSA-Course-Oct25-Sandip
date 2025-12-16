package Practise.ArrayAndString;

public class Factorial {
    public int factorial(int n){
        int result = 1;
        if(n <= 1) return 1;
        result = n * factorial(n-1);
        return result;
    }

    public static void main(String[] args) {
        Factorial solu = new Factorial();
        System.out.println(solu.factorial(2));
    }
}
