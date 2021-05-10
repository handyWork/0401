package com.testPackage.designMode29.StrategyPattern;

/**
 * 环境类
 */
public class Travelr {
    TravelStrategy travelStrategy;

    /**
     * 设置出行策略
     * @param travelStrategy
     */
    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    /**
     * 为当前用户设置出行方式
     */
    public void travelStyle(){
        travelStrategy.travelStyle();
    }
}
