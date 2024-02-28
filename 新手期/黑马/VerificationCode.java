package com.itheima.demo2;

import java.util.Random;
import java.util.Scanner;

public class VerificationCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char[]chs=new char[52];
        for (int i = 0; i < chs.length; i++) {
            //ASCII码表
            if(i<=25){
                //添加小写字母
            chs[i]=(char)(97+i);
            }else{//27
                //添加大写字母
                //A---65
                chs[i]=(char)(65+i-26);
            }
        }
//        定义一个字符串类型的变量，用来记录最终的结果
        String result ="";
//        随机抽取4次
//        随机抽取数组中的索引
        Random r=new Random();
        for (int i = 0; i < 4; i++) {
            int randomIndex=r.nextInt(chs.length);
//            利用随机索引，获取对应的元素
//            System.out.print(chs[randomIndex]);
            result=result+chs[randomIndex];
        }
        int number = r.nextInt(10);
        result+=number;
        System.out.println(result);
        System.out.println("请输入验证码：");
        String pareNum=sc.next();
        if(pareNum.equals(result)){
            System.out.println("验证码正确！");
        }else System.out.println("输入错误");
    }
}
