import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 2, 9, 3, 6, 8, 4, 5, 7, 1 };

        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 8));
    }

    static boolean binarySearch(int[] arr, int target) {
        Arrays.sort(arr);

        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (arr[mid] < target) {
                // lo = mid;
                lo = mid + 1; // have to +1, else, it will end a infinite loops if target not in range
            } else if (arr[mid] > target) {
                hi = mid;
            } else {
                System.out.println(mid);
                return true;
            }
        }

        return false;
    }
}
