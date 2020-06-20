package com.leetCode;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TowSummary {

    int[] nums={2, 7, 11, 15};
    int target=9;

    public int[] sum(int[] nums,int target){
        Date startDate = new Date();
        for (int i=0;i<nums.length;i++){
            int b=target-nums[i];
            for (int p=i;p<nums.length;p++){
                if (nums[p] == b){
                    int[] ttt={i,p};
                    return ttt;
                }
            }
        }
        return null;
    }

    public int[] sum1(int[] nums,int target){
        Map<Integer, Integer> hash = new HashMap<>();
        int[] indexs=new int[2];

        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }

}
