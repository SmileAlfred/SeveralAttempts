package com.company.nowcode;

import org.junit.Test;
import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import javax.xml.transform.Source;
import java.util.Arrays;

/**
 * @author SmileAlfred
 * @create 2021-03-11 16:24
 * @csdn https://blog.csdn.net/liusaisaiV1
 * @description 链接：https://www.nowcoder.com/questionTerminal/0c9664d1554e466aa107d899418e814e
 * 来源：牛客网
 * <p>
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 示例1
 * 输入
 * [[1,1,0,0,0],[0,1,0,1,1],[0,0,0,1,1],[0,0,0,0,0],[0,0,1,1,1]]
 * 输出
 * 3
 */
public class NC109IslandCount {
    @Test
    public void test() {
        char[][] grid = new char[][]{{'1', '0', '0', '0', '0'}, {'0', '1', '0', '1', '1'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '1'}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + "\t");
            }
            System.out.println();
        }
        int solve = solve(grid);
        System.out.println("岛屿数量：" + solve);
    }

    /**
     * 判断岛屿数量
     *
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve(char[][] grid) {
        // write code here
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    gg(grid, i, j);
                    //此处不加判断那么结果是可以通过测试的，但是对于下面的数组，理应有两个 岛屿，结果却是 4 个
                    //{{'1', '0', '0', '0', '0'}, {'0', '1', '0', '1', '1'}, {'0', '0', '0', '1', '1'}, {'0', '0', '0', '0', '0'}, {'0', '0', '1', '1', '1'}};
                    if (num > 0) count++;
                    num = -1;
                }
            }
        }
        return count;
    }

    int num = -1;

    public void gg(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        if (grid[i][j] == '1') num++;
        grid[i][j] = '0';
        gg(grid, i + 1, j);//向右找
        gg(grid, i, j + 1);//向下找
        gg(grid, i, j - 1);//向上找
        gg(grid, i - 1, j);//向左找
    }
}
