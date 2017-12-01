package com.springtest.chapter10;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 9:05
 * @version v1.00
 */
@Configuration
@Import({JpaConfiguration.class})
@ComponentScan("com.springtest.chapter10")
public class DAOConfig {

    @Profile("dev")
    @Bean
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUrl("jdbc:hsqldb:file:D:/Code/springstudy/mydb");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(2);
        dataSource.setValidationQuery("select 1 from INFORMATION_SCHEMA.SYSTEM_USERS");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
