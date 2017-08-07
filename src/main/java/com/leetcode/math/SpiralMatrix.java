package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/6/22.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * https://leetcode.com/problems/spiral-matrix/#/description
     */

    @Test
    public void test() {
        List<Integer> rs = spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        for(int i : rs)
            System.out.print(i+",");
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rs = new ArrayList<>();
        if(matrix == null)
            return rs;
        int p = matrix.length, n = matrix.length;
        for(int i=0; i<n/2; i++, p-=2){
            for(int col=i; col<i+p; col++)
                rs.add(matrix[i][col]);
            for(int row=i+1; row<i+p; row++)
                rs.add(matrix[row][i+p-1]);
            for(int col=i+p-2; col>=i; col--)
                rs.add(matrix[i+p-1][col]);
            for(int row=i+p-2; row>i; row--)
                rs.add(matrix[row][i]);
        }
        if(n % 2 != 0)
            rs.add(matrix[n/2][n/2]);
        return rs;
    }

}
