package com.example.demo.schedule;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync //在启动类里面加了@EnableAsync标识，这里可以不加
@Log
public class ThreadPoolExecutorConfig {

    //@Value("${async.executor.thread.core_pool_size}")
    private int corePoolSize = 5;
    //@Value("${async.executor.thread.max_pool_size}")
    private int maxPoolSize = 5;
   // @Value("${async.executor.thread.queue_capacity}")
    private int queueCapacity = 99999;
    //@Value("${async.executor.thread.name.prefix}")
    private String namePrefix = "async-service-";

    /**
     * 异步线程池
     */
    @Bean("asyncServiceExecutor")
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutorConfig();
        //配置核心线程数
        executor.setCorePoolSize(corePoolSize);
        //配置最大线程数
        executor.setMaxPoolSize(maxPoolSize);
        //配置队列大小
        executor.setQueueCapacity(queueCapacity);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix(namePrefix);

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
