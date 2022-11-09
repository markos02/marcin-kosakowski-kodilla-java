package com.kodilla.patterns.strategy.social.publishers;

public final class SnapchatPublisher implements SocialPublisher{

    @Override
    public String share() {
        return "Millenial publishing on Snapchat";
    }
}
