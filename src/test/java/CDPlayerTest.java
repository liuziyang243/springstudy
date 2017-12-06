import com.springtest.chapter1.CompactDisc;
import com.springtest.chapter1.MediaPlayer;
import com.springtest.chapter1.config.SoundSystemConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/11/30 9:49
 * @version v1.00
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SoundSystemConfig.class})
@ActiveProfiles("dev")
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    @Qualifier("compactDisc")
    private CompactDisc cd;

    @Autowired
    @Qualifier("blankDisc")
    private CompactDisc blankcd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void blankCDShouldNotBeNull() {
        assertNotNull(blankcd);
        blankcd.play();
    }

    @Test
    public void testPlay() {
        player.play();
        assertEquals("Playing Sgt. Papper's Lonely Heart Club Band" +
                        " by The Beatles\n",
                log.getLog());
    }
}
