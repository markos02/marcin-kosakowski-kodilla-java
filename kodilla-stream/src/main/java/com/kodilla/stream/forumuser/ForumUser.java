package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userId;
    private final String username;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int numberPosts;

    public ForumUser(int userId, String username, char sex, LocalDate dateOfBirth, int numberPosts) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.numberPosts = numberPosts;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getNumberPosts() {
        return numberPosts;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex=" + sex +
                ", dateOfBirth=" + dateOfBirth +
                ", numberPosts=" + numberPosts +
                '}';
    }
}
