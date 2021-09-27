package com.company.nowcode;

import org.junit.Test;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-07 21:47
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 传入二叉树，和一个数值，找出所有的路径，该路径要满足所有节点之和等于该数值
 */
public class FindPath {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(11);
        root.left.right.left = new TreeNode(2);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);

        System.out.println(pathSum(root, 22));
    }


    static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); //用于存储结果
    static ArrayList<Integer> temp = new ArrayList<Integer>(); //用于存储路径

    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, 0);
        return res;
    }

    public static void dfs(TreeNode root, int sum, int cnt) {
        // 如果节点为空结束当前递归
        if (root == null) return;
        //将当前节点加入tmp数组
        temp.add(root.val);
        //把当前节点加入到路径和中
        cnt += root.val;
        //当递归到没有子树的时候就需要判断
        if (root.left == null && root.right == null) {
            //如果当前节点的路径和等于sum，那么就在res中插入tmp
            if (cnt == sum) {
                res.add(new ArrayList<>(temp));
            }
        } else {
            //递归左子树
            dfs(root.left, sum, cnt);
            //递归右子树
            dfs(root.right, sum, cnt);
        }
        temp.remove(temp.size() - 1);
        //这里 cnt 并没有减去最后一次添加进来的值！因为其实并没有加进来……。
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    @Test
    public void test1() {
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list1.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(2);
        list2.add(2);
        list1.addAll(list2);
        System.out.println(list1);
        System.out.println(new ArrayList<>(new HashSet<>(list1)));
    }





}
