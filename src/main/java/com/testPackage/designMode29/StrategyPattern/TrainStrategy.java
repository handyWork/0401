package com.testPackage.designMode29.StrategyPattern;

/**
 * 火车策略类
 */
public class TrainStrategy implements  TravelStrategy {
    @Override
    public void travelStyle() {
        System.out.println("乘坐火车");
    }
}

