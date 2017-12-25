package com.springtest.chapter10;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author lzy
 * <p>
 * Create Time: 2017/12/1 11:57
 * @version v1.00
 */
@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = RuntimeException.class, timeout = 10)
public class JdbcSpitterRepository implements OriginalSpitterRepository {

    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
    @CachePut(value = "spittleCache", key = "#spitter.id")
    public void addSpitter(Spitter spitter) {
        String INSERT_SPITTER = "INSERT INTO PUBLIC.SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, UPDATEBYEMAIL, GENDER) VALUES (?,?,?,?,?,?)";
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail(),
                spitter.getGender());
    }

    @Override
    @Cacheable("spittleCache")
    public Spitter findOne(long id) {
        String SELECT_SPITTER_BY_ID = "SELECT * FROM PUBLIC.SPITTER WHERE ID=?";
        try {
            return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, this::mapSpitter, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = RuntimeException.class)
    @CacheEvict(value = "spittleCache", key = "id")
    public void remove(long id) {
        String DELETE_SPITTER_BY_ID = "DELETE FROM PUBLIC.SPITTER WHERE ID=?";
        jdbcOperations.update(DELETE_SPITTER_BY_ID, id);
    }

    private Spitter mapSpitter(ResultSet rs, int row) throws SQLException {
        if (row > 0) {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullName"),
                    rs.getString("email"),
                    rs.getBoolean("updateByEmail"),
                    Enum.valueOf(Gender.class, rs.getString("gender")));
        }
        return null;
    }
}
