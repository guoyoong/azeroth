package com.leetcode.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by guoyong1 on 2017/8/22.
 */

public class SingletonTest {


//    private SingletonTest(){}

    //1.第一种  需要加锁效率低
    private static SingletonTest instance = null;
    public static SingletonTest getInstance(){
        if(instance == null){
            synchronized (SingletonTest.class){
                if(instance == null){
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

    //2.第二种  浪费内存
    private static SingletonTest instance2 = new SingletonTest();
    public static SingletonTest getInstance2(){
        return instance2;
    }

    //3.第三种
    private static class SingletonHolder{
        private final static SingletonTest instance3 = new SingletonTest();
    }
    public static SingletonTest getInstance3(){
        return SingletonHolder.instance3;
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println(ClassLoader.getSystemClassLoader());
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getContextClassLoader());
            }
        }.start();
        Thread.sleep(1000);
    }


    public String countAndSay(int n) {
        if(n < 1)
            return"";
        if(n == 1)
            return"1";
        String str = countAndSay(n-1);
        StringBuilder sb =new StringBuilder();
        int count = 1;
        for(int i = 1; i < str.length(); i++) {
            if(str.charAt(i) == str.charAt(i - 1))
                count++;
            else{
                sb.append(count);
                sb.append(str.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }


}
