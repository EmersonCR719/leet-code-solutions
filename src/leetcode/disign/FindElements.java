package leetcode.disign;

import leetcode.trees.TreeNode;
import java.util.HashSet;
import java.util.Set;

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
public class FindElements {

    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        recoverTree(root, 0);
    }

    public void recoverTree(TreeNode node, int value) {
        if (node == null) return;
        node.val = value;
        values.add(value);
        recoverTree(node.left, 2 * value + 1);
        recoverTree(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
