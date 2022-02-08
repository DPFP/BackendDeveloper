import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PassingYearbooks {

    // TODO This one is hard to me
    // python solution
    // https://github.com/semk/leetcode/blob/master/python/hard/sign_counts.py
    // first try
    int[] findSignatureCounts(int[] arr) {
        // Write your code here
        // arr[i] --> student index who gonna receive the book; i is the Student@i ,
        // pass it to student arr[i-1]. It's possible that arr[i-1] = i for any given i
        // Once a student has received their own yearbook back, they will hold on to it
        // and no longer participate in the passing process.
        // It's guaranteed that, for any possible valid input, each student will
        // eventually receive their own yearbook back and will never end up holding more
        // than one yearbook at a time.
        int[] res = new int[arr.length];
        // it at least got one for each year book;
        Arrays.fill(res, 1);

        for (int i = 0; i < arr.length; i++) {
            int student = arr[i];
            res[student - 1]++;
        }

        return res;
    }

    // translated from Python solutions
    // https://leetcode.com/discuss/interview-question/614096/Facebook-or-Recruiting-Portal-or-Passing-Yearbooks/850037
    static int[] findSignatureCounts2(int[] arr) {
        // Write your code here
        int len = arr.length;

        Set<Integer> visited = new HashSet<>();
        int[] signatures = new int[len]; // auto filled with 0;

        int[] root_indexes = new int[len];
        Arrays.fill(root_indexes, -1);

        for (int i = 0; i < len; i++) {
            int student = arr[i]; // current student;
            if (visited.contains(student)) {
                continue; // already visited
            }
            visited.add(student);

            // consider current student as root of a cycle;
            signatures[i] = 1;
            int next_i = student - 1; // pass to next student arr[i-1]
            while (next_i != i) {
                signatures[i] += 1;
                root_indexes[next_i] = i;
                visited.add(arr[next_i]);
                next_i = arr[next_i] - 1;
            }
        }

        // return the signature counts of the root nodes, and the referenced root node
        // counts of traversed nodes
        for (int i = 0; i < len; i++) {
            if (root_indexes[i] != -1) {
                signatures[i] = signatures[root_indexes[i]];
            }
        }

        return signatures;
    }

    // another online solution
    // https://leetcode.com/discuss/interview-question/614096/Facebook-or-Recruiting-Portal-or-Passing-Yearbooks/938115
    int[] findSignatureCounts3(int[] arr) {
        // Write your code here
        int[] res = new int[arr.length];
        Set<Integer> visited = new HashSet<>();

        for (int k : arr) {
            if (!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while (!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = arr[k - 1];
                }
                for (int i : round) {
                    res[i - 1] = round.size();
                }
            }
        }

        return res;
    }

    // https://leetcode.com/discuss/interview-question/614096/Facebook-or-Recruiting-Portal-or-Passing-Yearbooks/528475
    private static int[] solve(int[] nums) {
        int[] res = new int[nums.length];

        // Key: nextStudent, value: student
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i + 1);
        }
        Set<Integer> visited = new HashSet<>();
        for (int k : map.keySet()) {
            if (!visited.contains(k)) {
                Set<Integer> round = new HashSet<>();
                while (!visited.contains(k)) {
                    round.add(k);
                    visited.add(k);
                    k = map.get(k);
                }
                for (int i : round) {
                    res[i - 1] = round.size();
                }
            }
        }
        return res;
    }

    // you have to follow each yearbook from start until it's gets handed back to
    // the year book owner. every time you pass the book you keep of the counts.
    // this one probabaly easist to understand.
    // https://leetcode.com/discuss/interview-question/614096/Facebook-or-Recruiting-Portal-or-Passing-Yearbooks/773774
    static int[] findSignatureCounts4(int[] arr) {
        // Write your code here
        int[] output = new int[arr.length];

        for (int student = 1; student <= arr.length; student++) {
            int bookOwner = student;
            int currentHolder = student;

            do {
                output[student - 1] += 1;
                currentHolder = arr[currentHolder - 1];
            } while (currentHolder != bookOwner);

        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        // Arrays.stream(arr).forEach(n -> System.out.println(n));

        int[] t1 = { 2, 1 };
        Arrays.stream(findSignatureCounts2(t1)).forEach(n -> System.out.println(n));
    }
}
