public class Sept1st {

    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) { // i is the index of the array
            int count = 0;
            int j = i;
            while (nums[j] >= 0) { // nums[j] is the index of the array
                count++;
                int temp = nums[j]; // save the value of nums[j]
                nums[j] = -1; // mark visited element as -1
                j = temp; // move to the next element of the array
            }
            max = Math.max(max, count); // update the max value
        }
        return max;
    }

    public int trySol(int[] nums) {
        int size = nums.length;
        for (int i = 0; i <= size; i++) { // k
            int current = nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] t1 = { 5, 4, 0, 3, 1, 6, 2 };
        Sept1st sol = new Sept1st();

        System.out.println(sol.arrayNesting(t1));
    }
}
