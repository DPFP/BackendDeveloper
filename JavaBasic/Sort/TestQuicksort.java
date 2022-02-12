package JavaBasic.Sort;

public class TestQuicksort {
    public static void main(String[] args) {
        // NOTE: Make sure to enable assert before running this code.
        // If you're using IntelliJ, you might be able to use this:
        // https://intellij-support.jetbrains.com/hc/en-us/community/posts/207014815-How-to-enable-assert
        int[] a1 = { 1, 2, 3 };
        int[] a2 = { 3, 2, 1 };
        int[] a3 = {};
        int[] a4 = { 3, 1, -1, 0, 2, 5 };
        int[] a5 = { 2, 2, 1, 1, 0, 0, 4, 4, 2, 2, 2 };
        int[] a6 = { 0 };
        int[] a7 = { 3, -2, -1, 0, 2, 4, 1 };
        int[] a8 = { 1, 2, 3, 4, 5, 6, 7 };
        int[] a9 = { 2, 2, 2, 2, 2, 2, 2 };

        int[] a1Sorted = { 1, 2, 3 };
        int[] a2Sorted = { 1, 2, 3 };
        int[] a3Sorted = {};
        int[] a4Sorted = { -1, 0, 1, 2, 3, 5 };
        int[] a5Sorted = { 0, 0, 1, 1, 2, 2, 2, 2, 2, 4, 4 };
        int[] a6Sorted = { 0 };
        int[] a7Sorted = { -2, -1, 0, 1, 2, 3, 4 };
        int[] a8Sorted = { 1, 2, 3, 4, 5, 6, 7 };
        int[] a9Sorted = { 2, 2, 2, 2, 2, 2, 2 };

        quicksort(a1);
        quicksort(a2);
        quicksort(a3);
        quicksort(a4);
        quicksort(a5);
        quicksort(a6);
        quicksort(a7);
        quicksort(a8);
        quicksort(a9);

        assert arrayEquals(a1, a1Sorted);
        assert arrayEquals(a2, a2Sorted);
        assert arrayEquals(a3, a3Sorted);
        assert arrayEquals(a4, a4Sorted);
        assert arrayEquals(a5, a5Sorted);
        assert arrayEquals(a6, a6Sorted);
        assert arrayEquals(a7, a7Sorted);
        assert arrayEquals(a8, a8Sorted);
        assert arrayEquals(a9, a9Sorted);
        System.out.println("If you didn't get an assertion error, this program has run successfully.");
    }

    static void quicksort(int[] arr) {
        qs(arr, 0, arr.length - 1);
    }

    static void qs(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);

        qs(arr, l, p - 1);
        qs(arr, p + 1, r);
    }

    static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;
        return i + 1;
    }

    // Helper function for checking if the two given arrays
    // are equal or not.
    static boolean arrayEquals(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }
}
