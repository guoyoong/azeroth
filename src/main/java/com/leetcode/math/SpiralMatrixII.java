package com.leetcode.math;
/**
 * Created by guoyong1 on 2017/6/22.
 */

import org.junit.Test;

public class SpiralMatrixII {

    /**
     * https://leetcode.com/problems/spiral-matrix-ii/#/description
     */

    @Test
    public void test() {
        int[][] matrix = generateMatrix(4);
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                System.out.print(matrix[i][j]+",");
            }
            System.out.println();
        }
    }

    public int[][] generateMatrix(int n) {
        int val = 1, p = n;
        int[][] matrix = new int[n][n];
        for(int i=0; i<n / 2; i++, p-=2){
            for(int col=i; col<i+p; col++)
                matrix[i][col] = val++;
            for(int row=i+1; row<i+p; row++)
                matrix[row][i+p-1] = val++;
            for(int col=i+p-2; col>=i; col--)
                matrix[i+p-1][col] = val++;
            for(int row=i+p-2; row>i; row--)
                matrix[row][i] = val++;
        }
        if(n % 2 != 0)
            matrix[n/2][n/2] = val;
        return matrix;
    }

}
