package com.example.workflow.loanapp;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class Scoring implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = (String) delegateExecution.getVariable("name");
        String surname = (String) delegateExecution.getVariable("surname");
        String pasport = (String) delegateExecution.getVariable("pasport");
        System.out.println("Заявка от: " + name + " " + surname);
        String varName = "scoring_good";
        Boolean varValue = true;
        delegateExecution.setVariable(varName, varValue);
    }

}