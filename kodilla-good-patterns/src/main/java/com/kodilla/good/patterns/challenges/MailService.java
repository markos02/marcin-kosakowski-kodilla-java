package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService{

    @Override
    public void inform() {
        System.out.println("Sending confirmation email to the customer");
    }
}
