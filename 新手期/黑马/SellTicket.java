//package com.itheima.demo2;
//
//import java.util.Scanner;
//
///**
// * 机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
// * 按早如下规则计算机票价格：旺季（5~10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
// *
// */
//public class SellTicket {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        System.out.println("请输入你想设置的机票原价格(头等舱)：");
//        double firstPrice=sc.nextDouble();
//        System.out.println("请输入你想设置的机票原价格(经济舱)：");
//        double ecoPrice=sc.nextDouble();
//        System.out.println("请输入你想买几月份的机票(旺季:5-10月,淡季:11-4月)：");
//        int mouth=sc.nextInt();
//        System.out.println("您想买头等舱还是经济舱呢？(头等舱输入1,经济舱输入0)：");
//        int i=sc.nextInt();
////        boolean flag=false;
////        switch(mouth){
////            case 11,12,1,2,3,4-> flag=true;
//////                    System.out.println("为淡季(头等舱7折,经济舱6.5折)");
////            case 5,6,7,8,9,10->flag=false;
//////                    System.out.println("为旺季(头等舱9折,经济舱8.5折)");
////        }
////        double x=0;
////        if(flag){
////             x=OffSeason(firstPrice,ecoPrice,i);
////        }else {
////            x=PeakSeason(firstPrice,ecoPrice,i);
////        }
////        System.out.println("您选择的机票的价格为:"+x);
////
//        double x=0;
//        switch(mouth){
//            case 11,12,1,2,3,4-> x=OffSeason(firstPrice,ecoPrice,i);
//            case 5,6,7,8,9,10->x=PeakSeason(firstPrice,ecoPrice,i);
//        }
//        System.out.println("您选择的机票的价格为:"+x);
//    }
//    public static double OffSeason(double firstPrice,double ecoPrice,int i){
//            if(i==1){
//                return firstPrice*0.7;
//            }else return ecoPrice*0.65;
//    }
//    public static double PeakSeason(double firstPrice,double ecoPrice,int i) {
//        if(i==1){
//            return firstPrice*0.9;
//        }else return ecoPrice*0.85;
//    }
//}
package com.itheima.demo2;

import java.util.Scanner;

/**
 * 机票价格按照淡季旺季、头等舱和经济舱收费、输入机票原价、月份和头等舱或经济舱。
 * 按早如下规则计算机票价格：旺季（5~10月）头等舱9折，经济舱8.5折，淡季（11月到来年4月）头等舱7折，经济舱6.5折。
 *
 */
//ctrl+alt+M可以快捷提取方法
public class SellTicket {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你想设置的机票原价格：");
        double ticket=sc.nextDouble();
        System.out.println("请输入你想买几月份的机票(旺季:5-10月,淡季:11-4月)：");
        int mouth=sc.nextInt();
        System.out.println("您想买头等舱还是经济舱呢？(头等舱输入1,经济舱输入0)：");
        int seat=sc.nextInt();
        double x=0;
        switch(mouth){
            case 11,12,1,2,3,4-> x=getPrice(ticket,seat,0.9,0.85);
            case 5,6,7,8,9,10->x=getPrice(ticket,seat,0.7,0.65);
        }
        System.out.println("您选择的机票的价格为:"+x);
    }
    public static double getPrice(double Price,int seat,double v0,double v1){
        if(seat==1){
            return Price*v0;
        }else return Price*v1;
    }
}

