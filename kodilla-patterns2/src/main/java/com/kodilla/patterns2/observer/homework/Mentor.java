package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer{
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
        updateCount = 0;
    }

    @Override
    public void update(StudentHomeworkQueue studentHomeworkQueue) {
        System.out.println(studentHomeworkQueue.getStudentName() + " added new homework to queue " + "\n" +
                "total: " + studentHomeworkQueue.getHomeworkList().size() + " homeworks in queue");
        updateCount++;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
