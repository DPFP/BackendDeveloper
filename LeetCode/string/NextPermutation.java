package LeetCode.string;

public class NextPermutation {

    // The replacement must be in place and use only constant extra memory.
    // BF Solution
    public void nextPermutationBF(int[] nums) {
        // print original
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();

        if (nums.length > 1) {
            int temp = 0;
            int aiIndex = -1;
            int ajIndex = -1;

            // Step 1 -- find A(i) > A(i-1)
            for (int i = nums.length - 1; i >= 1; i--) {
                if (nums[i - 1] < nums[i]) {
                    aiIndex = i - 1;
                    break;
                }
            }

            // Step 2 if found the aiIndex --
            if (aiIndex > -1) {
                int diff = Integer.MAX_VALUE;
                for (int i = aiIndex; i < nums.length; i++) {
                    temp = nums[i] - nums[aiIndex];
                    if (temp > 0 && temp <= diff) {
                        // seek the next number ajIndex with smallest diff
                        diff = temp;
                        ajIndex = i;
                    }
                }

                // Step 3 -- Swap ai & aj
                temp = nums[aiIndex];
                nums[aiIndex] = nums[ajIndex];
                nums[ajIndex] = temp;

                // Step 4 -- Reverse evertying after aiIndex;
                // Note: Have to do this (nums.length - aiIndex) / 2
                // otherwise it reverse back to the original order r
                for (int i = aiIndex + 1; i < (nums.length - aiIndex) / 2 + aiIndex + 1; i++) {
                    temp = nums[i];
                    nums[i] = nums[nums.length - i + aiIndex];
                    nums[nums.length - i + aiIndex] = temp;
                }

            } else {
                // it already sorted
                for (int i = 0; i < nums.length / 2; i++) {
                    temp = nums[i];
                    nums[i] = nums[nums.length - i - 1];
                    nums[nums.length - i - 1] = temp;
                }
            }
        }

        // print result
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("-----------");
    }

    // 2nd try ref to
    // https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
    public void nextPermutation(int[] nums) {
        // #1 if it can be shifted --> shift *next* greater permutation of numbers

        // #2 if ti can't be shifted --> sort in ascending order
    }

    // online solution
    public void nextPermutationSol(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        int i = A.length - 2;
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--; // Find 1st id i that breaks descending order
        }
        if (i >= 0) { // If not entirely descending
            int j = A.length - 1; // Start from the end
            while (A[j] <= A[i])
                j--; // Find rightmost first larger id j
            swap(A, i, j); // Switch i and j
        }
        reverse(A, i + 1, A.length - 1); // Reverse the descending sequence
    }

    // Tried again on 2/12/2022
    // added more comment with help to understand the problem.
    public void nextPermutation3(int[] nums) {
        // find the next biggest element and then swap
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2; // because index + 1, dont want overflow
        // step 1: find the first descedning value;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: if not entire descending;
        if (i >= 0) {
            // start from right side/end
            int j = nums.length - 1;
            // find the one element that is greater to nums[i]
            while (nums[j] <= nums[i]) {
                j--; // keep moving left
            }
            swap(nums, i, j); // swap those two element
        }

        // Step 3: reverse the remaining array after i
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    private void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }

    public static void main(String[] args) {
        // 3, 1, 2 --> 3,2,1 ?
        // 1,2,3,4 --> 1,3,2,4
        int[] n1 = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
        int[] n2 = { 3, 1, 2 };
        int[] n3 = { 1, 2, 3, 4 };
        int[] n4 = { 1, 2, 3 };
        int[] n5 = { 1, 1, 5 };
        int[] n6 = { 1 };
        int[] n7 = { 3, 2, 1 };
        int[] n8 = { 1, 3, 2 }; // 2, 1, 3
        int[] n9 = { 2, 3, 1, 3, 3 }; // [2,3,3,1,3]

        NextPermutation sol = new NextPermutation();

        sol.nextPermutationBF(n1);
        sol.nextPermutation(n2);
        sol.nextPermutation(n3);
        sol.nextPermutation(n4);
        sol.nextPermutation(n5);
        sol.nextPermutation(n6);
        sol.nextPermutation(n7);
        sol.nextPermutation(n8);
        sol.nextPermutation(n9);
    }
}
