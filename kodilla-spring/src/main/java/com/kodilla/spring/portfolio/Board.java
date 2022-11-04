package com.kodilla.spring.portfolio;

public final class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }

    public void taskAdd(String taskList, String task) {

        switch (taskList) {
            case "toDoList":
                toDoList.addTask(task);
                break;
            case "inProgressList":
                inProgressList.addTask(task);
                break;
            case "doneList":
                doneList.addTask(task);
                break;
            default:
                System.out.println("List doesn't exist");
        }
    }
}
