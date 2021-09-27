package com.company.nowcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author SmileAlfred
 * @create 2021-03-30 14:38
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/185a87cd29eb42049132aed873273e83?tpId=117&tqId=37715&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high%2Fquestion-ranking&tab=answerKey
 * NC5二叉树根节点到叶子节点的所有路径和
 * 题目描述
 * 给定一个仅包含数字  0-9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 例如根节点到叶子节点的一条路径是1 → 2 → 3 ,那么这条路径就用 123 来代替。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 * 例如：
 * 这颗二叉树一共有两条路径，
 * 根节点到叶子节点的路径 1 → 2 用数字  12 代替
 * 根节点到叶子节点的路径 1 → 3  用数字  13 代替
 * 所以答案为\ 12+13=25 12+13=25
 * 示例1
 * 输入  {1,0}
 * 返回值  10
 * 示例2
 * 输入  {1,#,9}
 * 返回值  19
 */
public class NC5TreePathSum {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(5);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(3);

        int sum = sumNumbers1(root);
        System.out.println(sum);

    }

    /**
     * 自己的解决办法：可行，但时间复杂夫太高：一方面是因为使用 String 进行操作；另一方面是因为有递归
     */
    String sum1 = "";
    ArrayList<String> list1 = new ArrayList<>();
    public int sumNumbers1(TreeNode root) {
        // write code here
        if (null == root) return 0;
        if (null == root.left && null == root.right) {
            list1.add(sum1 + root.val);
            return Integer.parseInt(list1.get(list1.size() - 1));
        }
        sum1 += root.val;
        if (root.left != null) sumNumbers1(root.left);
        if (root.right != null) sumNumbers1(root.right);
        sum1 = sum1.substring(0, sum1.length() - 1);

        int res = 0;
        Iterator<String> iterator = list1.iterator();
        System.out.println(list1);
        while (iterator.hasNext()) {
            res += Integer.parseInt(iterator.next());
        }
        return res;
    }

    /**
     * 错误代码！看小伙伴的解题思路，通过 res+= 的方式计算；改进如下
     * 错误原因，递归没有整明白，哪里有这么 += ？这里重复 += 导致结果大于实际值
     */
    int sum = 0;
    int res = 0;
    public int sumNumbersError(TreeNode root) {
        // write code here
        if (null == root) return 0;
        if (null == root.left && null == root.right) {
            return sum * 10 + root.val;
        }
        sum = sum * 10 + root.val;
        if (root.left != null) res += sumNumbersError(root.left);
        if (root.right != null) res += sumNumbersError(root.right);
        sum /= 10;

        return res;
    }

    /**
     * 高手写法：https://blog.nowcoder.net/n/3fd50e8f5eab48b5bb757fc764f06ceb?f=comment
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return sumNumbers(root, root.val);
    }

    /**
     * 高手的递归！注意传入的参数！这样就解决了重复 += 的BUG
     * @param root
     * @param sum
     * @return
     */
    private int sumNumbers(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            int result = 0;
            if (root.left != null) {
                result += sumNumbers(root.left, sum * 10 + root.left.val);
            }
            if (root.right != null) {
                result += sumNumbers(root.right, sum * 10 + root.right.val);
            }
            return result;
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        ArrayList<Integer> list = new ArrayList();
    }
}
