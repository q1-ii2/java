package com.itheima.demo2;

public class ArrayElement {
    public static void main(String[] args){
        /*
        需求：
        把一个数组中的元素复制到另一个新数组中去
         */
        //分析：
        //1.定义一个老数组并存储一些元素
        int[]arr={1,2,3,4,5};
        //2.定义一个新数组的长度跟老数组一直
        int[]newArr=new int[arr.length];
        //3.遍历老数组,得到老数组中的每一个元素,一次存入到新数组当中
        for (int i = 0; i < arr.length; i++) {
            //i表示老数组中的索引。新数组中的每一个索引
            //arr[i] 表示老数组中的元素
            newArr[i]=arr[i];
        }

        //4.新数组中已经存满元素了
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i]);
        }
    }
}
