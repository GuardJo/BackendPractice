package org.example.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface SimpleRowMapper {
    Object map(ResultSet resultSet) throws SQLException;
}
