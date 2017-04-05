package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/4.
 */

import org.junit.Test;

import java.util.HashSet;

public class ValidSudoku {

    @Test
    public void test() {

    }

    public boolean isValidSudoku(char[][] board) {
        /* 3*3宫格中没有重复元素 */
        for(int i=0; i<9; i++){
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for(int j=0; j<9; j++){
                /* 行 9个元素*/
                if(board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                /* 列 9个元素*/
                if(board[j][i] != '.' && ! columns.add(board[j][i]))
                    return false;
                //cube 位置
                int rowIndex = 3*(i/3);
                int colIndex = 3*(i%3);
                /* 3*3 九宫格 */
                /**
                 * 0,0 0,1 0,2
                 * 1,0 1,1 1,2
                 * 2,0 2,1 2,2
                 */
                if(board[rowIndex + j/3][colIndex + j%3]!='.'
                        && !cube.add(board[rowIndex+j/3][colIndex+j%3]))
                    return false;
            }
        }
        return true;
    }
}
