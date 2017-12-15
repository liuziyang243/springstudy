import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/11 9:55
 * @version v1.00
 */
public class ShiroTest {

    @Test
    public void testShiroHelloworld() {
        // 初始化securityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);

        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();

        // 登陆
        UsernamePasswordToken token = new UsernamePasswordToken("shiro", "201314");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("log in fail.");
            return;
        }
        System.out.println("log successful! Welcome " + subject.getPrincipal());

        // 注销
        subject.logout();
    }
}
