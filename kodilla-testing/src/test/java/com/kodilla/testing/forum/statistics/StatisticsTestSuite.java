package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.shape.ShapeCollector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatisticsTestSuite {

    @Mock
    private static Statistics statisticsMock;

    private List<String> usersNamesGenerator(int numberUsers) {

        List<String> resultList = new ArrayList<>();

        for (int i = 1; i <= numberUsers; i++) {
            resultList.add("User " + i);
        }

        return resultList;

    }

    @Nested
    @DisplayName("Tests calculateAdvStatistics")
    class testCalculateAdvStatistics {

        @Test
        void testCalculateAdvStatistics0Posts() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(0, resultPostsPerUser);
            assertEquals(0, resultCommentsPerUser);
            assertEquals(0, resultCommentsPerPost);
            verify(statisticsMock, times(1)).commentsCount();
            verify(statisticsMock, times(1)).postsCount();
            verify(statisticsMock, times(1)).usersNames();
        }

        @Test
        void testCalculateAdvStatistics1000Posts() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(10));
            when(statisticsMock.commentsCount()).thenReturn(2000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(100, resultPostsPerUser);
            assertEquals(200, resultCommentsPerUser);
            assertEquals(2, resultCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatistics0Comments() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(10));
            when(statisticsMock.commentsCount()).thenReturn(0);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(100, resultPostsPerUser);
            assertEquals(0, resultCommentsPerUser);
            assertEquals(0, resultCommentsPerPost);
            verify(statisticsMock, times(1)).commentsCount();
        }

        @Test
        void testCalculateAdvStatisticsLessCommentsThanPosts() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(10));
            when(statisticsMock.commentsCount()).thenReturn(200);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(100, resultPostsPerUser);
            assertEquals(20, resultCommentsPerUser);
            assertEquals(0.2, resultCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatisticsMoreCommentsThanPosts() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(10));
            when(statisticsMock.commentsCount()).thenReturn(2000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(100, resultPostsPerUser);
            assertEquals(200, resultCommentsPerUser);
            assertEquals(2, resultCommentsPerPost);
        }

        @Test
        void testCalculateAdvStatistics0Users() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(0));
            when(statisticsMock.commentsCount()).thenReturn(2000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(0, resultPostsPerUser);
            assertEquals(0, resultCommentsPerUser);
            assertEquals(0, resultCommentsPerPost);
            verify(statisticsMock, times(1)).commentsCount();
            verify(statisticsMock, times(1)).postsCount();
            verify(statisticsMock, times(1)).usersNames();
        }

        @Test
        void testCalculateAdvStatistics100Users() {
            //Given
            StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
            when(statisticsMock.postsCount()).thenReturn(1000);
            when(statisticsMock.usersNames()).thenReturn(usersNamesGenerator(100));
            when(statisticsMock.commentsCount()).thenReturn(2000);

            //When
            statisticsCalculator.calculateAdvStatistics(statisticsMock);
            double resultPostsPerUser = statisticsCalculator.getAverageQuantityPostsPerUser();
            double resultCommentsPerUser = statisticsCalculator.getAverageQuantityCommentsPerUser();
            double resultCommentsPerPost = statisticsCalculator.getAverageQuantityCommentsPerPost();

            //Then
            assertEquals(10, resultPostsPerUser);
            assertEquals(20, resultCommentsPerUser);
            assertEquals(2, resultCommentsPerPost);
        }
    }
}
