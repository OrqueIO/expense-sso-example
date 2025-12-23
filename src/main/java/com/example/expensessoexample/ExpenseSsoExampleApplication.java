package com.example.expensessoexample;

import io.orqueio.bpm.engine.RuntimeService;
import io.orqueio.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import io.orqueio.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication
public class ExpenseSsoExampleApplication {
    @Autowired
    private RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(ExpenseSsoExampleApplication.class, args);
    }

    @EventListener
    public void processPostDeploy(PostDeployEvent event) {
        runtimeService.startProcessInstanceByKey("expense-report");
    }


}
