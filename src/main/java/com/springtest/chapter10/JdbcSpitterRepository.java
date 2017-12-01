package com.springtest.chapter10;

import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

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
public class JdbcSpitterRepository implements OriginalSpitterRepository {
    private JdbcOperations jdbcOperations;

    @Inject
    public JdbcSpitterRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void addSpitter(Spitter spitter) {
        String INSERT_SPITTER = "INSERT INTO PUBLIC.SPITTER (USERNAME, PASSWORD, FULLNAME, EMAIL, UPDATEBYEMAIL) VALUES (?,?,?,?,?)";
        jdbcOperations.update(INSERT_SPITTER,
                spitter.getUsername(),
                spitter.getPassword(),
                spitter.getFullName(),
                spitter.getEmail(),
                spitter.isUpdateByEmail());
    }

    @Override
    public Spitter findOne(long id) {
        String SELECT_SPITTER_BY_ID = "SELECT * FROM PUBLIC.SPITTER WHERE ID=?";
        return jdbcOperations.queryForObject(SELECT_SPITTER_BY_ID, this::mapSpitter, id);
    }

    private Spitter mapSpitter(ResultSet rs, int row) throws SQLException {
        if (row > 0) {
            return new Spitter(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("fullName"),
                    rs.getString("email"),
                    rs.getBoolean("updateByEmail"));
        }
        return null;
    }
}
