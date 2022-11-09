package com.kodilla.spring.portfolio;

import com.kodilla.spring.reader.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BoardConfig {

    @Autowired
    @Qualifier("toDoTaskList")
    TaskList taskList1;

    @Autowired
    @Qualifier("inProgressTaskList")
    TaskList taskList2;

    @Autowired
    @Qualifier("doneTaskList")
    TaskList taskList3;

    @Bean
    public Board getBoard() {
        return new Board(taskList1, taskList2, taskList3);
    }

    @Bean(name = "toDoTaskList")
    @Scope("prototype")
    public TaskList getTaskListOne() {
        return new TaskList();
    }

    @Bean(name = "inProgressTaskList")
    @Scope("prototype")
    public TaskList getTaskListTwo() {
        return new TaskList();
    }

    @Bean(name = "doneTaskList")
    @Scope("prototype")
    public TaskList getTaskListThree() {
        return new TaskList();
    }

}
