package com.kodilla.patterns.strategy.social.publishers;

public final class TwitterPublisher implements SocialPublisher{

    @Override
    public String share() {
        return "YGeneration publishing on Twitter";
    }
}
