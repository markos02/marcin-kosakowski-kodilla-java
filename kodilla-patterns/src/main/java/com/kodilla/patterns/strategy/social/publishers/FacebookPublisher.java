package com.kodilla.patterns.strategy.social.publishers;

public final class FacebookPublisher implements SocialPublisher{

    @Override
    public String share() {
        return "ZGeneration publishing on Facebook";
    }
}
