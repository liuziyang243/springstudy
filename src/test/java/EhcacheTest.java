import com.springtest.cache.EhCacheConfig;
import com.springtest.cache.EhCacheTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/8 11:17
 * @version v1.00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EhCacheConfig.class})
public class EhcacheTest {
    @Autowired
    private EhCacheTestService ehCacheTestService;

    @Test
    public void getTimestampTest() throws InterruptedException {
        System.out.println("第一次调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(2000);
        System.out.println("2秒之后调用：" + ehCacheTestService.getTimestamp("param"));
        Thread.sleep(11000);
        System.out.println("再过11秒之后调用：" + ehCacheTestService.getTimestamp("param"));
    }
}
