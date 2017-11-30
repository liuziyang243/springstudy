import com.springtest.chaper1.CompactDisc;
import com.springtest.chaper1.MediaPlayer;
import com.springtest.chaper1.config.CDPlayerConfig;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void testPlay() {
        player.play();
        assertEquals("Playing Sgt. Papper's Lonely Heart Club Band" +
                        " by The Beatles\n",
                log.getLog());
    }
}
