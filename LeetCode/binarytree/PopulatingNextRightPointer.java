public class PopulatingNextRightPointer {

    // Amazaing simple recursive solution
    // https://leetcode.com/problems/populating-next-right-pointers-in-each-node/discuss/37472/A-simple-accepted-solution/265892
    public Node connect(Node root) {
        dfs(root, null);
        return root;
    }

    private void dfs(Node curr, Node next) {
        if (curr == null)
            return;
        curr.next = next;
        dfs(curr.left, curr.right);
        // cant get my mind wrap around the following line of code
        dfs(curr.right, curr.next == null ? null : curr.next.left);
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3, 4, 5, 6, 7 };

        int level = 0;
        int nextBatch = 0;

        // calculate the totl level
        int sum = 0;
        while (input.length - sum != 0) {
            sum = (int) (sum + Math.pow(2, level));
            level++;
        }
        System.out.println("batch:" + nextBatch + " level:" + level);

        // print value for each level
        int pre = 0;
        for (int i = 0; i < level; i++) {
            // 0 , 1-2, 3-4-5-6
            int end = pre + (int) Math.pow(2, i);

            if (pre > 0) {
                for (int j = pre; j < end; j++) {
                    System.out.print(input[j]);
                    if (j == end - 1) {
                        System.out.print("null");
                    }
                }
            } else {
                System.out.print(input[pre]);
                System.out.print("null");
            }

            pre = end;
            System.out.println("----");
        }

        // ???
        for (int i = 0; i < input.length; i++) {
            nextBatch = (int) Math.pow(2, level);
            level++;
            // System.out.println("batch:" + nextBatch + " level:" + level);
        }
    }
}
