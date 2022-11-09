package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User marcin = new Millenials("Marcin");
        User michal = new YGeneration("Michal");
        User krzys = new ZGeneration("Krzys");

        //When
        String millenialPublishes = marcin.sharePost();
        String yGenerationPublishes = michal.sharePost();
        String zGenerationPublishes = krzys.sharePost();

        //Then
        assertEquals("Millenial publishing on Snapchat",millenialPublishes);
        assertEquals("YGeneration publishing on Twitter",yGenerationPublishes);
        assertEquals("ZGeneration publishing on Facebook",zGenerationPublishes);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User marcin = new Millenials("Marcin");

        //When
        String millenialPublishes = marcin.sharePost();
        System.out.println(millenialPublishes);
        marcin.setSocialPublisher(new TwitterPublisher());
        millenialPublishes = marcin.sharePost();
        System.out.println(millenialPublishes);

        //Then
        assertEquals("YGeneration publishing on Twitter",millenialPublishes);
    }
}
