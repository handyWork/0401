package com.testPackage.meituan;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author handy
 * @version 1.0
 * @date 2021/3/11 22:34
 * 浙江春晚上郭冬临搭档韩雪出演小品《没那么简单》讲述的是这样一个故事：
 * 郭冬临用10块钱买了5瓶水，根据游戏规则，4个空瓶可以兑换1瓶水，2个空盖可以兑换1瓶水。
 * 请设计程序，计算郭冬临一共能喝多少瓶水，请打印出兑换过程，并输出最终剩余多少空瓶，多少瓶盖
 *
 */
public class Question {

    public static void main(String[] args) {

        AtomicInteger a = new AtomicInteger();

        int shui = 5;
        int pingzi = 0;
        int gai = 0;

        while(shui>0 || pingzi>=4 || gai>=2){
            if(shui>0){
                System.out.println("直接喝水");
                shui--;
                System.out.println("第"+a.incrementAndGet()+"喝水");
                pingzi++;
                gai++;
            }else if(pingzi>=4){
                System.out.println("瓶子兑换水");
                pingzi-=4;
                System.out.println("第"+a.incrementAndGet()+"喝水");
                pingzi++;
                gai++;
            }else if(gai>=2){
                System.out.println("盖子换水");
                gai-=2;
                System.out.println("第"+a.incrementAndGet()+"喝水");
                pingzi++;
                gai++;
            }
        }

        System.out.println("瓶子剩余"+pingzi);
        System.out.println("盖子剩余"+gai);

    }
}
