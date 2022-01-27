public class ValidMountainArray {
    // 941. Valid Mountain Array
    // https://leetcode.com/problems/valid-mountain-array/

    // Tried this approach, didn't work
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int pre = arr[0];
        boolean peaked = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return false;
            }

            if (!peaked && arr[i] < arr[i - 1]) {
                return false;
            }

            if (arr[i] < arr[i - 1]) {
                peaked = true;
            }
        }

        return peaked;
    }

    // worked appraoch
    public boolean validMountainArray2(int[] arr) {
        if (arr.length <= 2 || arr[0] >= arr[1]) {
            return false;
        }

        boolean down = false;

        for (int i = 2; i < arr.length; i++) {
            // At this point, it is keep going down; (I don't care about going up, we only
            // seek the pivot point and make sure it all downwards )
            if (arr[i] < arr[i - 1]) {
                down = true;
            } else if (arr[i] == arr[i - 1] || down) {
                return false;
            }
        }

        return down;
    }

    // lee215 大神的解
    public boolean validMountainArray3(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int len = arr.length;
        int i = 0;
        int j = len - 1;

        // going up from left (meet at top)
        while (i + 1 < len && arr[i] < arr[i + 1]) {
            i++;
        }

        // going up from right (meet at top)
        while (j > 0 && arr[j - 1] > arr[j]) {
            j--;
        }

        // meet at top --> i == j
        return i > 0 && i == j && j < len - 1;

    }
}
