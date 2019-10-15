package com.dsb.springcloud.service2.service.impl;

import com.dsb.springcloud.service2.service.Service1Service;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class Service1ServiceFallback implements Service1Service {
    @Override
    public String getString(String id) {
        return "请求失败时的默认返回";
    }

    @Override
    public LocalDateTime getDate() {
        return null;
    }
}
