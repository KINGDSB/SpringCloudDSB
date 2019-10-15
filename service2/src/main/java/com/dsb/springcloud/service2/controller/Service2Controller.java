package com.dsb.springcloud.service2.controller;

import com.dsb.springcloud.service2.service.Service1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RefreshScope
@RestController
@RequestMapping("service2")
public class Service2Controller {

    @Autowired
    private Service1Service service1Service;

    @RequestMapping(value = "/get-service2-string", method = RequestMethod.GET)
    public String getService2String(@RequestParam("id") String id){
        return id + "\n" + service1Service.getDate();
    }
}
