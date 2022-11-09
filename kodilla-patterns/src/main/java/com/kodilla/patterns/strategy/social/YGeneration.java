package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;

public final class YGeneration extends User{

    public YGeneration(String name) {
        super(name);
        this.socialPublisher = new TwitterPublisher();
    }
}
