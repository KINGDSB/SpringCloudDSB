package com.dsb.springcloud.service1.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RefreshScope
@RestController
@RequestMapping("service1")
public class Service1Controller {

    @Value("${sleep}")
    private Integer sleep;

    @GetMapping("/get-date")
    @ResponseBody
    public LocalDateTime getDate() {
        return LocalDateTime.now();
    }

    @GetMapping("/get-sleep")
    public Integer getSleep() {
        return sleep;
    }

    @RequestMapping(value = "/get-string", method = RequestMethod.GET)
    public String getString(@RequestParam("id") String id){
        return id;
    }

    /**
     * 限流接口 需要在nacos中 配置protected-resource
     * @return
     */
    @GetMapping("/get-sentinel")
    @SentinelResource(value = "protected-resource", blockHandler = "getSentinelBlock")
    public String getSentinel() {
        return "正常返回";
    }

    public String getSentinelBlock(BlockException e) {
        return "限流中";
    }
}
