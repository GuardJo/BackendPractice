package org.example.jdbc;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class ConnectionHandler {

    public static DataSource getDataSource() {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName("org.h2.Driver");
        hikariDataSource.setJdbcUrl("jdbc:h2:mem://localhost/~/jdbc-practice;MODE=MySQL;DB_CLOSE_DELAY=-1");
        hikariDataSource.setUsername("Kyeongho");
        hikariDataSource.setPassword("1234");

        return hikariDataSource;
    }
}
