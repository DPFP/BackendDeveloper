import java.util.Arrays;

public class MinimizingPermutations {

    // Add any helper functions you may need here
    private void reverse(int[] arr, int from, int to) {
        while (from < to) {
            int tmp = arr[from];
            arr[from] = arr[to];
            arr[to] = tmp;

            from++;
            to--;
        }
    }

    int minOperations(int[] arr) {
        // Write your code here
        // either start with asc , or desc then reverse the whole array.
        int res = 0;
        // FB site doesn't support this IntStream.
        // int[] target = IntStream.rangeClosed(1, arr.length).toArray();
        int[] target = Arrays.copyOf(arr, arr.length);
        Arrays.sort(target);

        Set<String> seen = new HashSet<>(); // keep visited
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);
        seen.add(Arrays.toString(arr));

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (Arrays.equals(target, curr)) {
                    return res;
                }

                for (int j = 0; j < curr.length; j++) {
                    // why j+ 1 ? instead of just j ???
                    for (int k = j + 1; k < curr.length; k++) {
                        int[] next = curr.clone();
                        reverse(next, j, k);
                        if (!seen.contains(Arrays.toString(next))) {
                            queue.offer(next);
                            seen.add(Arrays.toString(next));
                        }
                    }
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        // Arrays.copyOf(original, newLength)
    }
}
