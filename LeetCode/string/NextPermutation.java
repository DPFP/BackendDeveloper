public class NextPermutation {

    // The replacement must be in place and use only constant extra memory.
    public void nextPermutation(int[] nums) {
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
            // System.out.println(aiIndex);

            if (aiIndex > -1) {
                // Step 2
                int diff = Integer.MAX_VALUE;
                for (int i = aiIndex; i < nums.length; i++) {
                    temp = nums[i] - nums[aiIndex];
                    if (temp > 0 && temp <= diff) {
                        diff = temp;
                        ajIndex = i;
                    }
                }
                // System.out.println(ajIndex);

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

        sol.nextPermutation(n1);
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
