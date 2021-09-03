import java.util.*;

public class Sept2nd {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return constructTrees(1, n);
    }

    // function for constructing trees
    static ArrayList<TreeNode> constructTrees(int start, int end) {
        ArrayList<TreeNode> list = new ArrayList<>();
        /*
         * if start > end then subtree will be empty so returning NULL in the list
         */
        if (start > end) {
            list.add(null);
            return list;
        }

        /*
         * iterating through all values from start to end for constructing\ left and
         * right subtree recursively
         */
        for (int i = start; i <= end; i++) {
            /* constructing left subtree */
            ArrayList<TreeNode> leftSubtree = constructTrees(start, i - 1);

            /* constructing right subtree */
            ArrayList<TreeNode> rightSubtree = constructTrees(i + 1, end);

            /*
             * now looping through all left and right subtrees and connecting them to ith
             * root below
             */
            for (int j = 0; j < leftSubtree.size(); j++) {
                TreeNode left = leftSubtree.get(j);
                for (int k = 0; k < rightSubtree.size(); k++) {
                    TreeNode right = rightSubtree.get(k);
                    TreeNode node = new TreeNode(i); // making value i as root
                    node.left = left; // connect left subtree
                    node.right = right; // connect right subtree
                    list.add(node); // add this tree to list
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Sept2nd sol = new Sept2nd();
        List<TreeNode> result = sol.generateTrees(3);
        for (TreeNode node : result) {
            node.preorderTraverse(node);
            System.out.println("-------------");
        }
    }
}
