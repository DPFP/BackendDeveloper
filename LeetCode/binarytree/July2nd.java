import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class July2nd {
    // Given a sorted integer array arr, two integers k and x, return the k closest
    // integers to x in the array. The result should also be sorted in ascending
    // order. [inclusion]
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // know: arr sorted, min, max
        // need to know: x position compare to arr
        // scenario: left, middle, right
        List<Integer> numList = new ArrayList<Integer>(arr.length);
        numList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        if (k >= arr.length) {
            return numList;
        }

        if (x < arr[0]) {
            System.out.println("MIN -- left");
            numList.clear();
            for (int i = 0; i < k; i++) {
                numList.add(arr[i]);
            }
        } else if (x > arr[arr.length - 1]) {
            System.out.println("MAX -- right ");
            numList.clear();
            for (int i = arr.length - k; i < arr.length; i++) {
                numList.add(arr[i]);
            }
        } else {
            System.out.println("in the middle");
            // int index = list.indexOf(x); // TODO x could not be in the list
            int index = 0;
            int diff = Integer.MAX_VALUE;

            // finding the index of x
            for (int i = 0; i < arr.length; i++) {
                int abs = Math.abs(x - arr[i]);
                if (diff > abs) {
                    diff = abs;
                    index = i;
                }
            }
            System.out.println("index:" + index);

            int left = index - 1; // 1
            int right = index + 1;

            int curr = 1;

            numList.clear();
            numList.add(arr[index]);

            // TODO this not gonna work !!!! (Have to compare one by one with target X )
            // need compare left and right with x !!!
            while (curr < k) {
                if (curr % 2 == 1 && left >= 0) {
                    numList.add(arr[left]);
                    left--; // 0
                } else if (right <= arr.length) {
                    numList.add(arr[right]);
                    right++;
                }
                curr++;
            }
        }
        Collections.sort(numList);

        return numList;
    }

    public static void main(String[] args) {
        int[] test1 = { 1, 2, 3, 4, 5 };
        int[] test3 = { 1, 20, 21, 40, 155 };
        int[] test4 = { 1, 2, 3, 4, 5, 6 };
        int[] test5 = { 1, 1, 1, 10, 10, 10 };
        int[] test6 = { 0, 1, 1, 1, 2, 3, 6, 7, 8, 9 };

        July2nd sol = new July2nd();

        // System.out.println(sol.findClosestElements(test1, 4, 3));

        // System.out.println();
        // System.out.println(sol.findClosestElements(test1, 4, -1));

        // System.out.println();
        // System.out.println(sol.findClosestElements(test1, 4, 6));

        // System.out.println();
        // System.out.println(sol.findClosestElements(test3, 4, 20));

        // System.out.println();
        // System.out.println(sol.findClosestElements(test3, 4, 44));

        // System.out.println();
        // System.out.println(sol.findClosestElements(test5, 1, 9)); // 10

        System.out.println();
        System.out.println(sol.findClosestElements(test6, 9, 4)); // 10
    }

}
