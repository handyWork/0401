package com.testPackage.hanNuoTa;

/**
 * 递归运算
 */
public class handle {

    /**
     * 通过汉诺塔例子  一共三座塔，A  B   C   将A塔上的盘子移动到C塔上   需要多少次  一次只能移动一个
     * @param n   一共多少个盘子
     * @param one   第一座塔
     * @param two   第二座塔
     * @param three 第三座塔
     */
    public static  void tower(int n,char one,char two,char three){
        if(n == 1){
            move(one,three,1);
        }else{
            tower(n-1,one,three,two);
            move(one,three,n);
            tower(n-1,two,one,three);
        }
/**
 *  1. 等于3时    将第一个放到第三个
 *
 */

    }

    /**
     * 移动盘子的方法
     * @param x  第一座塔
     * @param y  第二座塔
     * @param n  一共多少个盘子
     */
    public static  void move(char x,char y,int n){
        System.out.println(x+"的第"+n+"盘移动到"+y);
    }


    public static void main(String[] args) {
            handle.tower(3,'A','B','C');
    }


}
