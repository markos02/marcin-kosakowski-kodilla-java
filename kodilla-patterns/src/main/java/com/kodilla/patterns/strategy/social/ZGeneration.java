package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.FacebookPublisher;

public final class ZGeneration extends User{

    public ZGeneration(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
