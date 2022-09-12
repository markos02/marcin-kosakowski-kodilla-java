package com.kodilla.testing.forum.statistics;

public class StatisticsCalculator {

    private int usersQuantity;
    private int postsQuantity;
    private int commentsQuantity;
    private double averageQuantityPostsPerUser = 0;
    private double averageQuantityCommentsPerUser = 0;
    private double averageQuantityCommentsPerPost = 0;


    public void calculateAdvStatistics(Statistics statistics) {
        usersQuantity = statistics.usersNames().size();
        postsQuantity = statistics.postsCount();
        commentsQuantity = statistics.commentsCount();

        if (usersQuantity != 0 && postsQuantity != 0) {
            averageQuantityPostsPerUser = (double) postsQuantity / usersQuantity;
            averageQuantityCommentsPerUser = (double) commentsQuantity / usersQuantity;
            averageQuantityCommentsPerPost = (double) commentsQuantity / postsQuantity;
        }
    }

    public void showStatistics() {
        //temporary result
        System.out.println("Temporary result");
    }

    public double getAverageQuantityPostsPerUser() {
        return averageQuantityPostsPerUser;
    }

    public double getAverageQuantityCommentsPerUser() {
        return averageQuantityCommentsPerUser;
    }

    public double getAverageQuantityCommentsPerPost() {
        return averageQuantityCommentsPerPost;
    }

}
