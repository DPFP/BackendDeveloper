**Problems**:

| No.  | Problem                                                      | Difficulty | Date                   | Time Spent | Key   Point             | Diffcult Point             | Similar Problem | Note                                                      |
| ---- | ------------------------------------------------------------ | ---------- | ---------------------- | ---------- | ----------------------- | -------------------------- | --------------- | --------------------------------------------------------- |
| 105  | [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/) | Medium     | 2021-2-2<br />2021-5-4 |            |                         |                            |                 |                                                           |
| 94   | *Binary Tree Inorder Traversal*                              | Medium     | 2021-2-3               | 15 minutes | understand the tree     | recurssion                 |                 | it pretty easy after understand the tree concept          |
| 51   | N Queens                                                     | Hard       | 2021-2-9               |            | back-tracking (aka.DFS) |                            |                 |                                                           |
| 46   | Permutation                                                  | Medium     | 2021-2-18              |            |                         |                            |                 |                                                           |
| 226  | Invert Binary Tree                                           | Easy       | 2021-2-21              |            | pre-order               |                            |                 |                                                           |
| 116  | [Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/) | Medium     | 2021-2-21              |            |                         |                            |                 |                                                           |
| 114  | [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Medium     | 2021-2-21              |            |                         |                            |                 | need revisit                                              |
| 654  | [Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/) | Medium     | 2021-2-23              |            |                         |                            |                 |                                                           |
| 652  | [Find Duplicate subtree](https://leetcode.com/problems/find-duplicate-subtrees/) | Medium     | 2021-3-1               |            |                         |                            |                 | [Note](https://mp.weixin.qq.com/s/LJbpo49qppIeRs-FbgjsSQ) |
| 111  | [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/) | Easy       | 2021-3-13              |            | BFS                     | make sure understand Queue |                 |                                                           |
| 752  | [Open the Lock](https://leetcode.com/problems/open-the-lock/) | Medium     | 2021-3-14              |            | BFS                     |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |
|      |                                                              |            |                        |            |                         |                            |                 |                                                           |

**Notes**: 

Tree Traverse [Tutorial](https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)



**#105 Tips**:

The basic idea is here:
Say we have 2 arrays, PRE and IN.
Preorder traversing implies that PRE[0] is the root node.
Then we can find this PRE[0] in IN, say it's IN[5].
Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
Recursively doing this on subarrays, we can build a tree out of it :)

Solution:

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    return helper(0, 0, inorder.length - 1, preorder, inorder);
}

public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
    }
    // establish new tree with the Root 
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0; // Index of current root in inorder
  	// find the index
    for (int i = inStart; i <= inEnd; i++) {
        if (inorder[i] == root.val) {
            inIndex = i;
        }
    }
  	// 
    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
  	// 
    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
  
    return root;
}
```



**#51 - N Queens** Tips

