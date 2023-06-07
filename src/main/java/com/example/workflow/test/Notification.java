package com.example.workflow.test;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component
public class Notification implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        if ((Boolean) delegateExecution.getVariable("decision")) {
            System.out.printf("[%s] %s, здравствуйте!\n",
                    Notification.class.getName(), delegateExecution.getVariable("username"));
        } else {
            System.out.printf("[%s] %s, Вам отказано в регистрации!\n", Notification.class.getName(),
                    delegateExecution.getVariable("username"));
        }
    }
}
