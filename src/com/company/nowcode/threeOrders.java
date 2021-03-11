package com.company.nowcode;

import javax.xml.transform.Source;
import java.util.*;

/**
 * @author SmileAlfred
 * @create 2021-03-05 19:03
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description
 */
public class threeOrders {
    public static void main(String[] args) {

        //int[] nums = new int[19];
        //for (int i = 0; i < nums.length; i++) {
        //    nums[i] = i;
        //}
        //System.out.println(Arrays.toString(nums));
        //int[] left = Arrays.copyOf(nums, nums.length/2);
        //System.out.print(Arrays.toString(left));
        //int[] right = Arrays.copyOfRange(nums,nums.length/2,nums.length);
        //System.out.println(Arrays.toString(right));

        //int[] arr = {2, 3, 6, 7, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 12, 12, 12, 15, 16, 17, 17, 18, 18, 19, 20, 21, 26, 27, 27, 28, 29, 30, 30, 31, 32, 33, 33, 34, 36, 36, 37, 37, 38, 38, 40, 40, 41, 41, 41, 41, 42, 43, 43, 44, 45, 47, 49, 50, 51, 52, 52, 53, 54, 54, 54, 55, 55, 56, 56, 58, 58, 59, 59, 61, 62, 62, 64, 65, 65, 66, 67, 69, 69, 70, 71, 73, 75, 77, 78, 78, 78, 85, 85, 86, 88, 88, 88, 89, 90, 91, 91, 94, 94, 94, 96, 97, 97, 99, 101, 102, 103, 106, 107, 109, 111, 113, 114, 115, 116, 118, 119, 119, 120, 121, 121, 123, 124, 124, 124, 126, 127, 127, 128, 128, 129, 130, 130, 131, 131, 131, 132, 132, 133, 133, 134, 134, 135, 136, 137, 138, 139, 139, 140, 141, 142, 143, 143, 143, 144, 144, 145, 145, 147, 149, 150, 151, 152, 152, 153, 154, 155, 155, 158, 158, 159, 162, 162, 163, 164, 165, 166, 167, 167, 167, 168, 168, 170, 171, 173, 173, 174, 177, 178, 178, 179, 179, 179, 180, 185, 187, 187, 187, 188, 188, 188, 189, 189, 191, 193, 193, 193, 195, 195, 196, 201, 202, 202, 203, 204, 204, 207, 207, 209, 209, 210, 210, 212, 212, 212, 213, 213, 214, 217, 219, 221, 224, 224, 226, 226, 227, 227, 228, 228, 231, 231, 234, 235, 236, 236, 237, 237, 238, 239, 240, 244, 245, 246, 246, 250, 250, 251, 252, 253, 256, 257, 258, 258, 261, 262, 263, 265, 266, 266, 268, 270, 270, 271, 273, 274, 274, 275, 277, 278, 278, 278, 282, 284, 284, 285, 285, 292, 294, 295, 296, 296, 298, 299, 301, 303, 305, 306, 309, 311, 312, 314, 314, 315, 315, 315, 318, 320, 320, 320, 320, 323, 324, 324, 325, 325, 327, 328, 329, 329, 329, 329, 330, 330, 330, 330, 330, 331, 331, 334, 334, 335, 335, 339, 339, 340, 340, 341, 341, 344, 346, 346, 346, 348, 348, 349, 349, 350, 350, 350, 351, 351, 352, 352, 354, 355, 356, 357, 362, 362, 363, 363, 364, 366, 366, 366, 367, 369, 369, 369, 370, 371, 371, 372, 373, 375, 376, 376, 378, 379, 380, 381, 383, 384, 384, 385, 385, 385, 388, 388, 390, 392, 393, 393, 393, 394, 395, 395, 396, 396, 398, 398, 398, 399, 400, 401, 404, 405, 405, 406, 406, 406, 407, 407, 407, 408, 408, 410, 410, 411, 413, 414, 414, 415, 419, 420, 422, 425, 426, 426, 431, 431, 433, 433, 433, 433, 434, 435, 436, 436, 438, 439, 440, 440, 441, 444, 446, 446, 446, 447, 447, 447, 448, 448, 448, 453, 454, 454, 455, 456, 456, 457, 460, 463, 464, 464, 469, 470, 471, 471, 474, 475, 475, 479, 482, 482, 482, 483, 484, 486, 486, 487, 487, 489, 489, 491, 492, 495, 496, 496, 496, 498, 498, 499, 499, 500, 503, 503, 505, 505, 507, 508, 508, 508, 510, 513, 514, 517, 519, 520, 522, 522, 522, 522, 523, 524, 524, 525, 527, 528, 528, 529, 530, 532, 534, 535, 535, 536, 538, 538, 539, 539, 540, 540, 541, 543, 545, 545, 547, 547, 548, 550, 551, 551, 553, 554, 554, 554, 554, 555, 555, 555, 556, 556, 558, 560, 560, 560, 561, 561, 562, 563, 563, 564, 565, 565, 565, 566, 568, 568, 569, 569, 570, 571, 574, 575, 575, 576, 577, 580, 580, 581, 581, 583, 585, 585, 586, 586, 589, 590, 591, 591, 592, 592, 592, 593, 594, 595, 596, 596, 596, 596, 597, 597, 597, 598, 598, 601, 601, 605, 605, 607, 609, 609, 611, 613, 613, 615, 616, 617, 617, 620, 620, 621, 624, 625, 626, 628, 628, 630, 631, 632, 633, 635, 636, 637, 637, 637, 638, 640, 642, 642, 643, 643, 644, 645, 646, 647, 648, 649, 650, 650, 650, 651, 654, 655, 659, 663, 663, 665, 666, 666, 667, 669, 671, 672, 676, 680, 682, 682, 684, 685, 685, 685, 685, 686, 687, 688, 691, 692, 693, 693, 693, 694, 694, 696, 697, 697, 698, 701, 702, 702, 704, 706, 706, 707, 708, 711, 711, 711, 713, 713, 715, 715, 717, 718, 718, 719, 720, 721, 723, 727, 727, 727, 729, 730, 730, 731, 732, 732, 733, 733, 735, 735, 736, 736, 736, 737, 739, 742, 742, 742, 742, 744, 744, 746, 746, 747, 748, 749, 749, 752, 753, 755, 755, 756, 756, 756, 758, 758, 759, 759, 759, 760, 761, 762, 765, 768, 768, 771, 772, 772, 772, 773, 773, 774, 775, 775, 776, 776, 777, 777, 779, 779, 779, 780, 781, 783, 783, 784, 784, 784, 785, 785, 786, 788, 788, 790, 791, 791, 794, 795, 795, 797, 797, 798, 798, 800, 801, 801, 801, 802, 803, 803, 804, 806, 807, 807, 807, 808, 809, 809, 812, 814, 815, 817, 818, 818, 820, 820, 821, 821, 823, 823, 824, 826, 826, 828, 833, 835, 835, 836, 839, 845, 845, 847, 850, 850, 850, 850, 851, 851, 852, 852, 852, 852, 852, 853, 854, 855, 860, 861, 861, 863, 863, 864, 864, 865, 866, 866, 867, 867, 868, 870, 872, 874, 874, 876, 877, 877, 878, 881, 881, 881, 883, 886, 889, 891, 894, 895, 899, 900, 902, 903, 904, 904, 905, 906, 907, 910, 911, 911, 911, 912, 914, 915, 916, 917, 918, 919, 921, 921, 921, 922, 923, 923, 926, 926, 927, 928, 929, 929, 930, 931, 932, 933, 935, 935, 937, 938, 939, 939, 940, 940, 940, 944, 944, 945, 946, 947, 947, 950, 952, 953, 953, 953, 954, 954, 955, 956, 957, 958, 959, 960, 961, 961, 963, 964, 964, 965, 965, 966, 966, 966, 969, 969, 969, 970, 970, 970, 971, 972, 972, 972, 973, 973, 973, 974, 974, 975, 976, 976, 978, 981, 982, 982, 983, 984, 985, 987, 988, 988, 988, 991, 992, 993, 993, 995, 995, 995, 996, 997, 999, 999, 1000, 1000};
        //System.out.println(Arrays.toString(arr));
        //int target = 809;
        //int search = search(arr, target);
        //System.out.println(search);

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2); treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4); treeNode.left.right = new TreeNode(5); treeNode.right.left = new TreeNode(6);

        ArrayList<ArrayList<Integer>> arrayLists = levelOrder(treeNode);
        System.out.println(arrayLists);

    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        //边界条件判断
        if (root == null)
            return new ArrayList<>();
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            ArrayList<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(node.val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，
            res.add(subList);
        }
        return res;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public static int search(int[] nums, int target) {
        // write code here
        //注意1:空串的处理
        if (nums.length < 1) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;

        int midIndex = nums.length / 2;


        if (nums[midIndex] < target) {
            int[] right = new int[(nums.length - 1) / 2];
            //注意2：子串的获取，注意其范围，
            for (int i = 0; i < (nums.length - 1) / 2; i++) {
                right[i] = nums[nums.length / 2 + 1 + i];
            }
            System.out.println("右侧" + Arrays.toString(right));
            if (right.length == 1) {
                if (right[0] != target) return -1;
                    //注意3：这里要 + 1，因为，右侧部分不包括中间值
                else return midIndex + 1;
            }
            //注意4：返回这个结果，注意，右侧的 index, 需要加上中间的坐标，并加1
            return midIndex + 1 + search(right, target);

        } else if (nums[midIndex] > target) {
            int[] left = Arrays.copyOf(nums, nums.length / 2);
            System.out.println("左侧：" + Arrays.toString(left));
            if (left.length == 1) {
                if (left[0] != target) return -1;
                else return midIndex - 1;
            }
            return search(left, target);
        } else {
            if (midIndex == 0) return midIndex;
            if (nums[midIndex - 1] < target) return midIndex;

            for (; midIndex >= 0; midIndex--) {
                if (nums[midIndex] < target) return midIndex + 1;
                if (midIndex == 0) return midIndex;
            }
            return midIndex;
        }
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static List<Integer> list = new ArrayList<>();

    /**
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders(TreeNode root) {
        // write code here
        if (null == root) return null;


        Qian(root);
        int[][] res = new int[3][list.size()];

        Zhong(root);

        Hou(root);

        for (int i = 0, k = 0; i < 3; i++) {
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = list.get(k);
                k++;
            }
        }

        return res;
    }

    public void Qian(TreeNode root) {
        list.add(root.val);
        if (null != root.left) Qian(root.left);
        if (null != root.right) Qian(root.right);
    }

    public void Zhong(TreeNode root) {
        if (null != root.left) Qian(root.left);
        list.add(root.val);
        if (null != root.right) Qian(root.right);
    }


    public void Hou(TreeNode root) {
        if (null != root.left) Qian(root.left);
        if (null != root.right) Qian(root.right);
        list.add(root.val);
    }
}
