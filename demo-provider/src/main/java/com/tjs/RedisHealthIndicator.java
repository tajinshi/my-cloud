package com.tjs;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

/**
 * 自定义健康检查
 */
@Component
public class RedisHealthIndicator extends AbstractHealthIndicator {
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        // 检查redis是否正常
        builder.up().withDetail("redis", "ping ...");
    }
}
