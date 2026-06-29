/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 //Time Complexity - O(n), Space Complexity - O(n)

class Solution {
    int rootIndex = 0;
    HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        for(int i =0; i< inorder.length ; i++){
            inOrderIndex.put(inorder[i], i);
        }
        return buildTreeDfs(preorder, 0, inorder.length-1);
    }


    public TreeNode buildTreeDfs(int[] preorder, int left, int right) {
        if(left>right) return null;
        int rootVal = preorder[rootIndex++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderIndex.get(rootVal);
        root.left = buildTreeDfs(preorder, left, mid-1);
        root.right = buildTreeDfs(preorder, mid+1, right);
        return root;
    }
}
