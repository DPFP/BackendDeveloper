import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    // First try -- using map
    public int fib(int n) {
        // is the Integer as value big enough ?
        Map<Integer, Integer> map = new HashMap<>();
        return getFib(n, map);
    }

    private int getFib(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return getFib(n - 1, map) + getFib(n - 2, map);
    }

    // Other oneline solution

    // #1 Iterative O(n) / O(1) (probably is the best)
    // FYI, also a dynamic programming solution. --> 状态压缩 只需要知道 前面两个状态就好了 所以,
    // Space是O(1)
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }

        int a = 0;
        int b = 1;

        // mind twisted
        while (N-- > 1) {
            int sum = a + b;
            a = b;
            b = sum;
        }

        return b;
    }

    // almost the same appraoch as before, but this time, it using a for loop
    public int fibonacci(int N) {
        if (N <= 1) {
            return N;
        }
        int a = 0, b = 1;
        for (int i = 2; i <= N; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // #2 recursive
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    // #3 DP -- Top down approach (C: Pre-order traverse ? ) aka. Memorization
    int[] cache = new int[31]; // N + 1 ==> because the condition 0 <= n <= 30

    public int fib4(int N) {
        if (N <= 1) {
            return N;
        } else if (cache[N] != 0) {
            // parent
            return cache[N];
        } else {
            // child nodes
            return cache[N] = fib(N - 1) + fib(N - 2);
        }
    }

    // #4 DP -- Bottom up Approach (C: post-order ? ) aka. tabulation
    // 动态规划叫做「自底向上」。???
    public int fib5(int N) {
        if (N <= 1) {
            return N;
        }

        int[] cache = new int[N + 1];
        cache[1] = 1; // cache[0] ??? --> all primitive initialized with 0.

        // calculate everything from the base to N
        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[N];
    }

    public static void main(String[] args) {
        // all primitive initialized with 0.
        int[] cache = new int[31];

        cache[0] = 0;

        for (int i : cache) {
            System.out.println(i);
        }
    }

}