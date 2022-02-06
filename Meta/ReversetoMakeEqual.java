import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ReversetoMakeEqual {

    // First try didn't work !!!
    private static boolean areTheyEqual(int[] array_a, int[] array_b) {
        // Write your code here
        if (array_a.length != array_b.length) {
            return false;
        }
        int len = array_a.length;

        int start = -1; // when encounter first unequal element
        int end = -1; // when enounter equal element;

        for (int i = 0; i < len; i++) {
            if ((start == -1) && array_a[i] != array_b[i]) {
                start = i; // 1
            }
            // TODO this not gonna work #FML
            if ((start != -1) && array_a[i] == array_b[i]) {
                end = i;
                // check (start - end) and then reset start = -1;
                if (!reverseable(Arrays.copyOfRange(array_a, start, end), Arrays.copyOfRange(array_b, start, end))) {
                    return false;
                } else {
                    start = -1;
                }
            }
        }
        return true;
    }

    private static boolean reverseable(int[] a, int[] b) {
        // check if they are reversed;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[a.length - i]) {
                return false;
            }
        }
        return true;
    }

    // 2nd try - LC 1460
    // didnt work because [1,2,2,3] vs [1,1,2,3]
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int n : target) {
            set.add(n);
        }
        for (int n : arr) {
            if (!set.contains(n)) {
                return false;
            }
        }
        return true;
    }

    // 3rd try -- worked
    // over-thinking
    boolean areTheyEqual2(int[] array_a, int[] array_b) {
        // Write your code here
        if (array_a.length != array_b.length) {
            return false;
        }

        Arrays.sort(array_a); // O(nLogn)
        Arrays.sort(array_b); // O(nLogn)

        int len = array_a.length;
        for (int i = 0; i < len; i++) { // O(N)
            if (array_a[i] != array_b[i]) {
                return false;
            }
        }
        return true;
    }

    // O(N) solution
    // use hashMap
    public boolean canBeEqual3(int[] target, int[] arr) {
        Map<Integer, Integer> cm = new HashMap<>();
        int m = target.length;
        int n = arr.length;
        if (m != n) {
            return false;
        }

        for (int i = 0; i < m; i++) {
            cm.put(target[i], cm.getOrDefault(target[i], 0) + 1);
            cm.put(arr[i], cm.getOrDefault(arr[i], 0) + 1);
        }

        for (int i : cm.keySet()) {
            if (cm.get(i) != 0) {
                return false;
            }
        }

        return true;
    }

    // LOL --> this is amazing.
    public boolean canBeEqual4(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(target, arr);
    }

    public static void main(String[] args) {
        int[] t1 = { 1, 2, 3, 4, 5 };

        int[] a = { 1, 2, 3, 4 };
        int[] b = { 1, 4, 3, 2 };

        System.out.println(areTheyEqual(a, b));

        Arrays.stream(t1).forEach(s -> System.out.println(s));
        System.out.println("Test copyOfRange");
        // index(1,2,3) [begin,end) print - [2,3,4]
        Arrays.stream(Arrays.copyOfRange(t1, 1, 4)).forEach(s -> System.out.println(s));
    }

}
