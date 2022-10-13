package org.example.jdbc;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHandler {
    private static DataSource dataSource;

    static {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(DBConnectionConstant.DB_DRIVER_NAME);
        hikariDataSource.setJdbcUrl(DBConnectionConstant.DB_URL);
        hikariDataSource.setUsername(DBConnectionConstant.DB_USER_NAME);
        hikariDataSource.setPassword(DBConnectionConstant.DB_PASSWORD);
        hikariDataSource.setMaximumPoolSize(DBConnectionConstant.DB_MAXIMUM_POOL_SIZE);

        dataSource = hikariDataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}
