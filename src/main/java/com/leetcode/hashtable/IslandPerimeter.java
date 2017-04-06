package com.leetcode.hashtable;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by y on 2017/4/6.
 */
public class IslandPerimeter {

    @Test
    public void test() {
        System.out.println(islandPerimeter(new int[][]{
                {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}
        }));
    }

    public int islandPerimeter(int[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        int islandNum = 0, nearNum = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j] == 1) {
                    islandNum++;
                    if (j > 0 && grid[i][j - 1] == 1)
                        nearNum++;
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1)
                        nearNum++;
                    if (i > 0 && grid[i - 1][j] == 1)
                        nearNum++;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1)
                        nearNum++;
                }
            }
        }
        return 4*islandNum - nearNum;
    }
}
