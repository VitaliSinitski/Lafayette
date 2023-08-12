package com.example.workflow;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Named
public class ReserveSeatOnBoat implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String money = "0.0";
        String ticketType = "Coach";

        money = (String) delegateExecution.getVariable("money");
        double moneyDouble = Double.parseDouble(money);

        if (moneyDouble >= 10000) {
            ticketType = "First class";
        } else if (moneyDouble >= 5000) {
            ticketType = "Business class";
        }

        delegateExecution.setVariable("ticketType", ticketType);
    }
}
