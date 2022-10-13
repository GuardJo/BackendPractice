package org.example.jdbc;

import java.sql.*;

public class UserDao {
    public void create(User user) throws SQLException {
        String sql = "INSERT INTO USERS VALUES(?, ?, ?, ?)";

        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate();
        simpleJdbcTemplate.executeUpdate(user, sql, new SimplePreparedStatementSetter() {
            @Override
            public PreparedStatement setter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, user.getUserId());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getName());
                preparedStatement.setString(4, user.getEmail());

                return preparedStatement;
            }
        });
    }

    public User findById(String userId) throws SQLException {
        SimpleJdbcTemplate simpleJdbcTemplate = new SimpleJdbcTemplate();
        String sql = "SELECT userId, password, name, email FROM USERS WHERE userId=?";
        User user = null;

        user = simpleJdbcTemplate.executeQuery(userId, sql, new SimplePreparedStatementSetter() {
            @Override
            public PreparedStatement setter(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, userId);

                return preparedStatement;
            }
        }, new SimpleRowMapper() {
            @Override
            public Object map(ResultSet resultSet) throws SQLException {
                return new User(resultSet.getString("userId"), resultSet.getString("password"),
                        resultSet.getString("name"), resultSet.getString("email"));
            }
        });

        return user;
    }
}
