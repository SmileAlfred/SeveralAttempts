package com.company.nowcode;

import org.junit.Test;

import javax.swing.*;
import javax.xml.transform.Source;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

/**
 * @author SmileAlfred
 * @create 2021-03-14 15:16
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=188&tqId=38075&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 * NC72镜像二叉树
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 比如：    源二叉树  [5, 6, 7, 8, 9, 10, 11]
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树    [11,10,9,8,7,6,5]
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class NCA72MirrrorTree {

    @Test
    public void test() {
        TreeNode pRoot = new TreeNode(8);
        pRoot.left = new TreeNode(6);
        pRoot.left.left = new TreeNode(5);
        pRoot.left.right = new TreeNode(7);

        pRoot.right = new TreeNode(10);
        pRoot.right.left = new TreeNode(9);
        pRoot.right.right = new TreeNode(11);

        ArrayList<Integer> res = new ArrayList();
        pRoot.List(res);
        System.out.println("镜像前：" + res);//[5, 6, 7, 8, 9, 10, 11]

        TreeNode mirror = Mirror(pRoot);

        ArrayList<Integer> resMirror = new ArrayList();
        mirror.List(resMirror);
        System.out.println("镜像后：" + res);//[11, 10, 9, 8, 7, 6, 5]


    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (null == pRoot.left && null == pRoot.right) {
            return pRoot;
        }

        TreeNode lRoot = pRoot.left, rRoot = pRoot.right;
        Mirror(lRoot, rRoot);

        return pRoot;
    }

    //无结果，值得传递机制告诉我，最后换了个寂寞……
    private void Mirror(TreeNode lRoot, TreeNode rRoot) {
        if (null != lRoot && null != rRoot) {
            TreeNode tempNode = lRoot;
            rRoot = lRoot;
            lRoot = tempNode;
        } else if (null == lRoot && null != rRoot) {
            lRoot = rRoot;
        } else if (null != lRoot && null == rRoot) {
            rRoot = lRoot;
        } else return;

        Mirror(lRoot.left, lRoot.right);
        Mirror(rRoot.left, rRoot.right);
    }


    public TreeNode Mirror2(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return pRoot;

        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        Mirror2(pRoot.left);
        Mirror2(pRoot.right);
        return pRoot;
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

        public void List(ArrayList<Integer> res) {

            if (null != this.left) this.left.List(res);
            res.add(this.val);
            if (null != this.right) this.right.List(res);
        }
    }
}

