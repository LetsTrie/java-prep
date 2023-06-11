import java.util.Arrays;

public class Factorial {

    public static void factorialIterative () {
        int N = 10;

        long[] factorial = new long[N + 1];
        factorial[0] = factorial[1] = 1;
        for(int i = 2; i <= N; i++) factorial[i] = factorial[i - 1] * i;

        System.out.println(Arrays.toString(factorial));
    }

    public static long factorialRecursive (int N) {
        if(N <= 1) return N;
        return factorialRecursive(N - 1) * N;
    }

    public static void main (String[] args) {
        factorialIterative();
        System.out.println(factorialRecursive(10));
    }
}
