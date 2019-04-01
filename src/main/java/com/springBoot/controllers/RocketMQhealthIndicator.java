package com.springBoot.controllers;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 *
 */
public class RocketMQhealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0) {
            return Health.down().withDetail("ErrorCode", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        //对监控对象的检测操作
        return 1;
    }
}
