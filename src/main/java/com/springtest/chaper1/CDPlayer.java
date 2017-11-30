package com.springtest.chaper1;


import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 10:38
 * @version v1.00
 */
@Named
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
