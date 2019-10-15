package com.dsb.springcloud.service2.service;

import com.dsb.springcloud.service2.service.impl.Service1ServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@FeignClient(name = "service1", fallback = Service1ServiceFallback.class)
public interface Service1Service {

    @RequestMapping(value = "/service1/get-string", method = RequestMethod.GET)
    String getString(@RequestParam("id") String id);

    @GetMapping("/service1/get-date")
    @ResponseBody
    LocalDateTime getDate();
}
