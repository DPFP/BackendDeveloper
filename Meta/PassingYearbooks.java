import java.util.Arrays;

public class PassingYearbooks {

    // TODO This one is hard
    // https://leetcode.com/discuss/interview-question/614096/facebook-interview-preparation-question-passing-yearbooks
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

    public static void main(String[] args) {
        int[] arr = new int[10];
        Arrays.fill(arr, 1);
        Arrays.stream(arr).forEach(n -> System.out.println(n));
    }
}
