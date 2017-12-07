import com.springtest.chapter4.AOPConfig;
import com.springtest.chapter4.Encoreable;
import com.springtest.chapter4.Performance;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/6 14:31
 * @version v1.00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AOPConfig.class})
public class AOPTest {

    @Autowired
    @Qualifier("comedy")
    Performance performance;

    @Autowired
    @Qualifier("dramaPerformance")
    Performance performance2;

    @Test
    public void testAOP() {
        performance.perform();
        Encoreable encoreable = (Encoreable) performance;
        encoreable.performanceEncore();
        performance2.perform();
    }

    @Test
    public void testAspectJ() {
        performance.perform();
    }
}
