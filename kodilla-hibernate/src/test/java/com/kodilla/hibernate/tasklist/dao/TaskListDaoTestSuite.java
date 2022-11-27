package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskListDaoTestSuite {

    private final static String LISTNAME = "Test list 1";


    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList(LISTNAME, "Grocery list");

        //When
        taskListDao.save(taskList);

        //Then
        List<TaskList> resultList = taskListDao.findByListName(LISTNAME);
        assertEquals(1, resultList.size());
        assertTrue(resultList.contains(taskList));

        //CleanUp
        int id = resultList.get(0).getId();
        taskListDao.deleteById(id);

    }
}
