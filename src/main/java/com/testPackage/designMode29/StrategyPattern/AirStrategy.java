package com.testPackage.designMode29.StrategyPattern;

/**
 * 飞机出行策略
 */
public class AirStrategy implements TravelStrategy {
    @Override
    public void travelStyle() {
        System.out.println("乘坐飞机出行");
    }
}
