package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */


public class Test113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        Foo(0, root, list1, sum, list);
        return list;
    }

    /**
     * @param k  层数
     * @param treeNode
     * @param list
     * @param sum
     */
    private void Foo(int k, TreeNode treeNode, List<Integer> list1, int sum, List<List<Integer>> list) {
        if (treeNode == null) {
            return;
        }
        list1.add(k, treeNode.val);
        if (treeNode.val == sum && treeNode.right == null && treeNode.left == null) {
            list.add(new ArrayList<Integer>(list1.subList(0,k+1)));
            return;
        }
        Foo(k + 1, treeNode.left, list1, sum - treeNode.val, list);
        Foo(k + 1, treeNode.right, list1, sum - treeNode.val, list);
    }
}
