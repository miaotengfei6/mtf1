package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private char[][] chars={{1,1,1,1,0},{1,1,0,1,0},{1,1,0,0,0},{0,0,0,0,0}};

    //测试demodemo
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numIslands(chars);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int row = grid.length, columns = grid[0].length, count = 0;
        for (int i = 0; i < row; i++) {//遍历所有点
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, row, columns);//dfs遍历所有连接的点
                    count++;//记录岛屿数量
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j, int row, int columns) {
        if (i < 0 || j < 0 || i >= row || j >= columns || grid[i][j] == '0') return;//基线条件
        grid[i][j] = '0';//遍历过的点置 0
        dfs(grid, i + 1, j, row, columns);
        dfs(grid, i, j + 1, row, columns);
        dfs(grid, i - 1, j, row, columns);
        dfs(grid, i, j - 1, row, columns);
    }

}
