import com.springtest.chapter10.OriginalSpitterRepository;
import com.springtest.chapter10.Spitter;
import com.springtest.chapter10.SpitterRepository;
import com.springtest.chapter10.config.DAOConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.*;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 12:36
 * @version v1.00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DAOConfig.class})
//@ActiveProfiles("dev")
public class JDBCTest {

    @Autowired
    private OriginalSpitterRepository originalSpitterRepository;

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void testFindOne() {
        Spitter spitter = originalSpitterRepository.findOne(1);
        assertNotNull(spitter);
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
        for (Spitter spitter : spitters) {
            System.out.println(spitter.toString());
        }
    }

    @Test
    public void testRepositoryFindOne() {
        Optional<Spitter> spitter = spitterRepository.findById(2L);
        System.out.println(spitter.toString());
    }

    @Test
    public void testRepositoryDelete() {
        spitterRepository.deleteById(12L);
    }

    @Test
    public void testMetaData() {
        String url = "jdbc:hsqldb:file:D:/Code/springstudy/mydb";
        String user = "sa";
        String password = "";

        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection(url, user, password);
            DatabaseMetaData mrs = conn.getMetaData();
            System.out.println("MaxConnection:" + mrs.getMaxConnections());
            System.out.println("MaxStatements:" + mrs.getMaxStatements());
            System.out.println("JDBC version:" + mrs.getJDBCMajorVersion() + "." + mrs.getJDBCMinorVersion());
            ResultSet rs = mrs.getTables(null, null, null, new String[]{"Table"});
            System.out.println("Support batch:" + mrs.supportsBatchUpdates());
            while (rs.next()) {
                System.out.println(rs.getString(3));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
