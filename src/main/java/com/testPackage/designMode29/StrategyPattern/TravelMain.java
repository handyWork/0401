package com.testPackage.designMode29.StrategyPattern;

/**
 * 策略模式
 * 策略模式的优点：
 * 我们之前在选择出行方式的时候，往往会使用if-else语句，也就是用户不选择A那么就选择B这样的一种情况。这种情况耦合性太高了，而且代码臃肿，有了策略模式我们就可以避免这种现象，
 * 策略模式遵循开闭原则，实现代码的解耦合。扩展新的方法时也比较方便，只需要继承策略接口就好了
 */
public class TravelMain {

    public static void main(String[] args) {
        Travelr travel = new Travelr();

        travel.setTravelStrategy(new AirStrategy());
        travel.travelStyle();


    }


}
