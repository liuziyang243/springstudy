package com.springtest.chapter1;

import org.springframework.stereotype.Component;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 9:46
 * @version v1.00
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Papper's Lonely Heart Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
