package com.kodilla.stream;

import com.kodilla.stream.beautifier.AdvancedDecorator;
import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.reference.FunctionalCalculator;

public class SteamMain {
    public static void main(String[] args) {
        System.out.println("Welcome to module 7 - Stream");

        //SaySomething saySomething = new SaySomething();
        //saySomething.say();

        Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("This is an example text.");

        processor.execute(codeToExecute);

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);

        System.out.println("\nZadanie: upiększacz tekstów");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String textToBeautify = "Beautified text";
        poemBeautifier.beautify(textToBeautify, s -> System.out.println(s.toUpperCase()));
        poemBeautifier.beautify(textToBeautify, s -> System.out.println("ABC " + s + " ABC"));
        poemBeautifier.beautify(textToBeautify, AdvancedDecorator::frame);
        poemBeautifier.beautify(textToBeautify, AdvancedDecorator::addSpaces);
    }
}
