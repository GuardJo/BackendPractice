package org.example.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleJdbcTemplate {
    public void executeUpdate(User user, String sql, SimplePreparedStatementSetter simplePreparedStatementSetter) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionHandler.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            simplePreparedStatementSetter.setter(preparedStatement);
            preparedStatement.executeUpdate();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    public User executeQuery(String userId, String sql, SimplePreparedStatementSetter simplePreparedStatementSetter, SimpleRowMapper simpleRowMapper) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = ConnectionHandler.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            simplePreparedStatementSetter.setter(preparedStatement);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = (User) simpleRowMapper.map(resultSet);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return user;
    }
}
