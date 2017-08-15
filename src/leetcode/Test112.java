package leetcode;

/**
 * Created by Administrator on 2017/8/15.
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Test112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null ) {
            return false;
        }
        if (root.val == sum && root.right == null && root.left == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);

    }
}
