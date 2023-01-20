package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHomeworkQueueTest {

    @Test
    void testUpdate() {
        // Given
        StudentHomeworkQueue studentJohn = new StudentHomeworkQueue("John Malkovich");
        StudentHomeworkQueue studentTommy = new StudentHomeworkQueue("Tommy Lee Jones");
        StudentHomeworkQueue studentDavid = new StudentHomeworkQueue("David Hasselhoff");
        Mentor mentorAndrzej = new Mentor("Andrzej");
        Mentor mentorKarol = new Mentor("Karol");
        studentJohn.registerObserver(mentorAndrzej);
        studentTommy.registerObserver(mentorKarol);
        studentDavid.registerObserver(mentorKarol);
        // When
        studentJohn.addNewHomework("https://github.com/johnmalkovich/1");
        studentTommy.addNewHomework("https://github.com/tlj/1");
        studentTommy.addNewHomework("https://github.com/tlj/2");
        studentDavid.addNewHomework("https://github.com/tlj/3");
        studentDavid.addNewHomework("https://github.com/Hasselhoff/1");
        studentDavid.addNewHomework("https://github.com/Hasselhoff/2");
        //Then
        assertEquals(1, mentorAndrzej.getUpdateCount());
        assertEquals(5, mentorKarol.getUpdateCount());
    }

}