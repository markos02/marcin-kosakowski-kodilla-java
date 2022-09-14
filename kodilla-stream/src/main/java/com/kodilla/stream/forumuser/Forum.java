package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> usersList = new ArrayList<>();

    public Forum() {
        usersList.add(new ForumUser(1, "user1", 'M', LocalDate.of(2000, 01, 15), 12));
        usersList.add(new ForumUser(2, "user2", 'F', LocalDate.of(1999, 04, 3), 1));
        usersList.add(new ForumUser(3, "user3", 'M', LocalDate.of(1998, 01, 23), 4));
        usersList.add(new ForumUser(4, "user4", 'F', LocalDate.of(1997, 07, 7), 3));
        usersList.add(new ForumUser(5, "user5", 'M', LocalDate.of(2010, 10, 22), 15));
        usersList.add(new ForumUser(6, "user6", 'F', LocalDate.of(2011, 02, 6), 0));
        usersList.add(new ForumUser(7, "user7", 'M', LocalDate.of(2012, 05, 15), 21));
        usersList.add(new ForumUser(8, "user8", 'F', LocalDate.of(2013, 8, 9), 900));
        usersList.add(new ForumUser(9, "user9", 'M', LocalDate.of(2014, 11, 01), 0));
        usersList.add(new ForumUser(10, "user10", 'F', LocalDate.of(2015, 03, 30), 2));
    }

    public List<ForumUser> getUserList() {return new ArrayList<>(usersList);}
}
