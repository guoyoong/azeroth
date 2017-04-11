package com.leetcode.hashtable;
/**
 * Created by guoyong1 on 2017/4/10.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    @Test
    public void test() {
        System.out.println(isHappy(1));

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while(!set.contains(n)){
            System.out.println(n);
            set.add(n);
            if(n == 1)
                return true;
            Integer[] arr = getNum(n);
            int sum = 0;
            for(Integer i : arr){
                sum += (i * i);
            }
            n = sum;
        }
        return false;
    }

    public Integer[] getNum(int n){
        List<Integer> list = new ArrayList<Integer>();
        while(n != 0){
            list.add(n % 10);
            n /= 10;
        }
        return list.toArray(new Integer[0]);
    }
}
