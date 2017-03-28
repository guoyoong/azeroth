package com.leetcode.arrays;

import org.junit.Test;

/**
 * Created by y on 2017/3/28.
 */
public class TrappingRainWater {

    @Test
    public void test(){
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

    }

    /**
     * 类似倒酒模式，不过是从两边向中间靠拢。
     * @param height
     * @return
     */
    public int trap2(int[] height){
        if(height.length<3 || height==null)
            return 0;
        int leftMax = 0, rightMax = 0;
        int start = 0, end = height.length - 1;
        int res = 0;
        while(start <= end){
            if(height[start] <= height[end]){
                if(height[start] >= leftMax)
                    leftMax = height[start];
                else
                    res += leftMax - height[start];
                start++;
            }else{
                if(height[end] >= rightMax)
                    rightMax = height[end];
                else
                    res += rightMax - height[end];
                end--;
            }
        }
        return res;
    }

    /**
     * 顶尖 分散 类似倒酒
     * @param height
     * @return
     */
    public int trap(int[] height){
        if(height.length<3 || height==null)
            return 0;
        int max = 0;
        for(int i=0; i<height.length; i++)
            if(height[i]>height[max])
                max = i;
        int ans = 0;
        for(int i=0,leftMax=0; i<max; i++){
            if(height[i] > leftMax)
                leftMax = height[i];
            else
                ans += leftMax-height[i];
        }
        for(int i=height.length-1,rightMax=0; i>max; i--){
            if(height[i] > rightMax)
                rightMax = height[i];
            else
                ans += rightMax-height[i];
        }
        return ans;
    }
}
