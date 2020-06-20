package com.example.demo.schedule;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Log
public class UserController {

    @Autowired
    private AsyncService asyncService;

    /**
     * 线程池测试入口
     */
    @GetMapping("executeAsyncPool")
    public String executeAsyncPool() {
        log.info("start submit");

        //调用service层的任务
        asyncService.executeAsync();

        log.info("end submit");

        return "success";
    }
}