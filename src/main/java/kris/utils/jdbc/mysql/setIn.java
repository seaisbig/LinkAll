package kris.utils.jdbc.mysql;

import java.sql.SQLException;

public class setIn {
    public static void set(String message) throws SQLException {
        InsertDate.getConnection();
        InsertDate.in(message);
    }
}
