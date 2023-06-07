package com.example.workflow.test;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CreateUser implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        System.out.printf("[%s] Пользователь %s зарегистрирован\n", CreateUser.class.getName(),
                delegateExecution.getVariable("username"));
    }
}