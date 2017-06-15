package com.test;
/**
 * Created by guoyong1 on 2017/6/14.
 */

import org.junit.Test;

public class Fibonacci {

    @Test
    public void test() {

    }

    public static int downToTopReslove(int n) {
        if(n == 0) {
            return 0;
        } else if(n == 1 || n == 2) {
            return 1;
        } else {
            int[] fibonacciArray = new int[n+1]; //fibonacciArray[i]表示第i个斐波那契数
            fibonacciArray[0] = 0;
            fibonacciArray[1] = 1;
            fibonacciArray[2] = 1;
            for(int i=3;i<=n;i++) { //注意由于fibonacciArray[0]表示第0个元素，这里是i<=n，而不是i<n
                fibonacciArray[i] = fibonacciArray[i-1] + fibonacciArray[i-2];
            }
            return fibonacciArray[fibonacciArray.length-1];
        }
    }

}
