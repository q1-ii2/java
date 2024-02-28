package com.itheima.demo2;

import java.util.Arrays;
import java.util.Random;

public class PlayerScoring {
    public static void main(String[] args){
        //六名评委给选手打分,分数范围是0-100之间的整数
        //选手的最后得分为:去掉最高分,最低分后的4个评委的平均分
        Random r=new Random();
        int [] scores=new int[6];
        for (int i = 0; i < 6; i++) {
            scores[i]=r.nextInt(101);
        }
        System.out.println("评委分数：" + Arrays.toString(scores));
        int totalScore =0;
        int maxScore=Integer.MIN_VALUE;
        int minScore=Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            totalScore+=scores[i];
            maxScore=Math.max(maxScore,scores[i]);
            minScore=Math.min(minScore,scores[i]);
        }
        //计算最后得分
        int finalScore=(totalScore-maxScore-minScore)/(scores.length-2);
        System.out.println("最后得分："+finalScore);
    }
}
