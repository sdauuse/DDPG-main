package com.miao.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author：渺阴
 * @date: 2024-04-15
 * @Copyright：
 */
public class TwoZeroZero {
    public static void main(String[] args) {
        char[][] grid = {{'0','1','0'},{'1','0','1'},{'0','1','0'}};

        Solution s = new Solution();
        int count = s.numIslands(grid);
        System.out.println(count);
    }

}
class Solution {
    // 上 右 下 左
    int[] dx = { 0, 1, 0, -1 };
    int[] dy = { -1, 0, 1, 0 };
    public boolean[][] visited;

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int count = 0;
        Queue<PII> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visited[i][j] = true;
                    q.add(new PII(i, j));
                    count++;
                }

                while (!q.isEmpty()) {
                    PII now = q.poll();
                    for (int k = 0; k < 4; k++) {
                        if (!over(now, dx[k], dy[k], row, col) && grid[now.x + dx[k]][now.y + dy[k]] == '1' && !visited[now.x + dx[k]][now.y + dy[k]]) {
                            q.add(new PII(now.x + dx[k], now.y + dy[k]));
                            visited[now.x + dx[k]][now.y + dy[k]] = true;
                        }
                    }
                }
            }
        }

        return count;
    }

    public boolean over(PII now, int x, int y, int row, int col) {
        if (now.x + x >= row || now.y + y >= col || now.x + x < 0 || now.y + y < 0) {
            return true;
        }
        return false;
    }
}

class PII {
    int x;
    int y;

    public PII(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PII() {

    }
}