import java.util.HashMap;
import java.util.Map;

public class Sept24thNthTribonacciNumber {

    public int tribonacci1st(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 1);
        map.put(2, 1);

        return tribonacciRecur(n, map);
    }

    public int tribonacciRecur(int n, Map<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            return tribonacciRecur(n, map);
        }
    }

    public int tribonacci(int n) {
        int[] holder = new int[38];
        holder[0] = 0;
        holder[1] = holder[2] = 1;

        for (int i = 3; i < 38; i++) {
            holder[i] = holder[i - 1] + holder[i - 2] + holder[i - 3];
            // System.out.println(i + " : " + holder[i]);
        }

        return holder[n];
    }

    public static void main(String[] args) {
        Sept24thNthTribonacciNumber sol = new Sept24thNthTribonacciNumber();
        System.out.println(sol.tribonacci(4));
    }
}
