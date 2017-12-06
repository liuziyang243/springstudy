package com.springtest.chapter1;

import org.springframework.context.annotation.Primary;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 10:38
 * @version v1.00
 */
@Named("injectCDPlayer")
@Primary
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
