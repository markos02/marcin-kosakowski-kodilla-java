package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class BoardTestSuite {

    @Test
    void testConditional() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);

        //When
        //Then
        assertTrue(context.containsBean("getBoard"));
        assertTrue(context.containsBean("toDoTaskList"));
        assertTrue(context.containsBean("inProgressTaskList"));
        assertTrue(context.containsBean("doneTaskList"));
    }

    @Test
    void testTaskAdd() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);

        //When
        String taskToDo = "To do list: Task one";
        String taskInProgress = "In Progress List: Task one";
        String taskDone = "Done List: Task one";

        board.taskAdd("toDoList", taskToDo);
        board.taskAdd("inProgressList", taskInProgress);
        board.taskAdd("doneList", taskDone);

        //Then
        assertEquals(taskToDo, board.getToDoList().getTasks().get(0));
        assertEquals(taskInProgress, board.getInProgressList().getTasks().get(0));
        assertEquals(taskDone, board.getDoneList().getTasks().get(0));

    }
}
