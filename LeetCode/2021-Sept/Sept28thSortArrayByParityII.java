public class Sept28thSortArrayByParityII {
    public int[] sortArrayByParityII(int[] nums) {
        // Two queue odd/even
        Queue<Integer> odd = new LinkedList<>();
        Queue<Integer> even = new LinkedList<>();
        int[] res = new int[nums.length];

        for (int num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = even.poll();
            } else {
                res[i] = odd.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
