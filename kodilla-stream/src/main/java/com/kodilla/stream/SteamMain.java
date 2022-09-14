package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;


import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class SteamMain {
    public static void main(String[] args) {

        BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);

        System.out.println("\nZadanie: funkcyjny spacer po liście użytkowników forum");
        Forum forum = new Forum();

        Map<Integer, ForumUser> par = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> user.getDateOfBirth().isBefore(LocalDate.now().minusYears(20)))
                .filter(user -> user.getNumberPosts() > 0)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        par.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);


    }
}
