package com.kodilla.patterns2.observer.homework;

import java.util.ArrayList;
import java.util.List;

public class StudentHomeworkQueue implements Observable {
    private final String studentName;
    private final List<String> homeworkList;
    private final List<Observer> observerList;

    public StudentHomeworkQueue(String studentName) {
        this.studentName = studentName;
        homeworkList = new ArrayList<>();
        observerList = new ArrayList<>();
    }

    public void addNewHomework(String gitHubUrl) {
        homeworkList.add(gitHubUrl);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getHomeworkList() {
        return homeworkList;
    }
}
