package com.example.workflow.loanapp;

import com.example.workflow.Notification;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class Response implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        boolean system_desicion = (Boolean) delegateExecution.getVariable("scoring_good");
        boolean expert_desicion = (Boolean) delegateExecution.getVariable("scoring_good");

        if (system_desicion & expert_desicion) {
            System.out.println("Одобрено!");
        } else {
            System.out.println("Не одобрено!");
        }
    }
}