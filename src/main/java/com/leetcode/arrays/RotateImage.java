package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by guoyong1 on 2017/3/29.
 */
public class RotateImage {

    @Test
    public void test(){
        rotate(new int[][]{{1,2,3},{1,2,3},{1,2,3}});
    }

    public void rotate(int[][] matrix){

        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        if(n <= 1)
            return;
        for(int j=0; j<n/2; j++){//层遍历次数
            for(int i=0; i<(n+1)/2; i++){//行遍历次数
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
        System.out.println(matrix[2][1]);
        System.out.println(matrix[1][2]);

    }
}
