package com.example.workflow.loanapp;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class Scoring implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) {
        String name = (String) delegateExecution.getVariable("name");
        String surname = (String) delegateExecution.getVariable("surname");
        long age = (Long) delegateExecution.getVariable("age");
        long salary = (Long) delegateExecution.getVariable("salary");
        boolean rf = (Boolean) delegateExecution.getVariable("rf");
        //String pasport = (String) delegateExecution.getVariable("pasport");
        System.out.println("Заявка от: " + name + " " + surname);
        String varName = "scoring_good";
        Boolean varValue = score(age, salary, rf);
        delegateExecution.setVariable(varName, varValue);
    }

    public boolean score(long age, long salary, boolean rf) {
        if (rf && (age > 18)) {
            if ((age < 30) && (salary > 200000)){
                return true;
            }
            return (age >= 30) && (salary > 100000);
        }
        return false;
    }

}