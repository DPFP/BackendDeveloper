import java.util.Arrays;

public class ElementSwapping {

    // felt like a buble sort ? buble up the smallest element from the list?
    // A list x is lexicographically smaller than a different equal-length list y if
    // and only if, for the earliest index at which the two lists differ, x's
    // element at that index is smaller than y's element at that index.
    // e.g. [2,3,4,5] > [1,2,3,4] > [0,1,2,3] < [4,5,6,7]
    // [5,3,1] - [3,5,1] should work, only needed one swap; "At most k swaps"
    // [1,5,3] even smaller (find smallest)

    // need find the peak ? if desc: find smallest within k+1 , --> next will be k-1
    // +1 ...
    // Tips: Find minimum element at distance k and move it to position i, we used
    // (k-i) swaps, if k is still > 0, repeat this process from i+1.

    // 1st, find the smallest index within k steps
    // 2nd, swap
    // 3rd, repeat
    int[] findMinArray(int[] arr, int k) {
        // Write your code here
        int len = arr.length;

        // make sure don't miss " && k > 0 " here
        for (int i = 0; i < len && k > 0; i++) {
            // k + 1 ? ( i<= start + k is the same as i < start + k + 1 )
            int smallestIndex = findSmallestIndexWithinK(arr, i, k);

            // if current it is the smallest value; (e.g. first element is smallest)
            // C: this is the part that I was thinkng find the "peak"
            if (i == smallestIndex) {
                continue;
            }

            swap(arr, i, smallestIndex);

            k = k - smallestIndex - i;
        }

        return arr;
    }

    private int findSmallestIndexWithinK(int[] arr, int start, int k) {
        int min = Integer.MAX_VALUE;
        int index = 0;

        // noticed here i<= start +k (so no need to k+1)
        for (int i = start; i <= start + k; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    private void swap(int[] arr, int start, int end) {
        while (end > start) {
            int temp = arr[end];
            arr[end] = arr[end - 1]; // before
            arr[end - 1] = temp;
            end--;
        }
    }

    public static void main(String[] args) {
        ElementSwapping sol = new ElementSwapping();
        int[] t1 = { 8, 9, 11, 2, 1 };
        int[] t2 = { 11, 1, 2, 8, 9 };
        int[] t3 = { 1, 2, 8, 7, 6 };

        // Arrays.stream(sol.findMinArray(t2, 3)).forEach(n -> System.out.println(n));

        // this will error out on index out of bounds
        Arrays.stream(sol.findMinArray(t3, 3)).forEach(n -> System.out.println(n));
    }
}
