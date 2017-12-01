import com.springtest.chapter10.DAOConfig;
import com.springtest.chapter10.OriginalSpitterRepository;
import com.springtest.chapter10.Spitter;
import com.springtest.chapter10.SpitterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertNull;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 12:36
 * @version v1.00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DAOConfig.class})
@ActiveProfiles("dev")
public class JDBCTest {

    @Autowired
    private OriginalSpitterRepository originalSpitterRepository;

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void testFindOne() {
        Spitter spitter = originalSpitterRepository.findOne(1);
        assertNull(spitter);
    }

    @Test
    public void testInsert() {
        Spitter spitter = new Spitter();
        spitter.setUsername("test");
        spitter.setPassword("124");
        spitter.setFullName("test");
        spitter.setEmail("test@qq.com");
        spitter.setUpdateByEmail(true);

        originalSpitterRepository.addSpitter(spitter);
    }

    @Test
    public void testRepository() {
        List<Spitter> spitters = spitterRepository.findAll();
        System.out.println(spitters.toString());
    }
}
