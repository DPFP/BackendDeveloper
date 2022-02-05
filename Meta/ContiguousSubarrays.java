public class ContiguousSubarrays {
    // https://leetcode.com/discuss/interview-question/579606/count-contiguous-subarrays
    // https://leetcode.com/discuss/interview-question/742523/facebook-prep-question-contiguous-subarrays-on-solution

    public static void main(String[] args) {
        int[] t1 = { 3, 4, 1, 6, 2 };

        // Arrays.asList(countSubarrays(t1)).stream().forEach(System.out::println);
        int[] res = countSubarrays(t1);
        for (int n : res) {
            System.err.println(n);
        }
    }

    private static int[] countSubarrays(int[] arr) {
        // Write your code here

        int len = arr.length;
        int[] resArr = new int[len];
        int index;

        for (int i = 0; i < len; i++) {
            // count it self
            int counter = 1;

            // count it left, what if it equal [3,4,4] ??
            index = i - 1;
            while (index >= 0 && arr[index] < arr[i]) {
                // check if it valid [left <--> i]
                counter++;
                index--;
            }

            // count ir right
            index = i + 1;
            while (index < len && arr[index] < arr[i]) {
                counter++;
                index++;
            }

            resArr[i] = counter;
        }

        return resArr;
    }
}
