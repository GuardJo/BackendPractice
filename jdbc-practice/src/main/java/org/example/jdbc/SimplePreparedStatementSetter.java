package org.example.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SimplePreparedStatementSetter {
    PreparedStatement setter(PreparedStatement preparedStatement) throws SQLException;
}
