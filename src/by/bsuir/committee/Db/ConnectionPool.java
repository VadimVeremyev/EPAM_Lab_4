package by.bsuir.committee.Db;

import java.sql.Connection;

public interface ConnectionPool {

    Connection getConnection();

    boolean releaseConnection(Connection connection);
}
