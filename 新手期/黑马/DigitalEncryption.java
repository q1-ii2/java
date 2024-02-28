package com.itheima.demo2;

public class DigitalEncryption {
    public static void main(String[]args){
        int num=1983;
        int GeWei = num%10;
        int ShiWei = num/10%10;
        int BaiWei = num/100%10;
        int QianWei = num/1000;
        System.out.println("千位："+QianWei);
        System.out.println("百位："+BaiWei);
        System.out.println("十位："+ShiWei);
        System.out.println("个位："+GeWei);

        int[] count= {QianWei,BaiWei,ShiWei,GeWei};
        int [] tem=new int[4];
        for (int i = 0; i < 4; i++) {
            tem[i]=count[i];
        }
        for (int i = 0; i < 4; i++) {
            tem[i]=(tem[i]+5)%10;

        }
        for(int i=0,j=tem.length-1;i<j;i++,j--)
        {
            int temp;
            temp=tem[i];
            tem[i]=tem[j];
            tem[j]=temp;
        }
        int number = 0;
        for (int i = 0; i < tem.length; i++) {
            number=number*10+tem[i];
        }
        System.out.println(number);
    }
}
