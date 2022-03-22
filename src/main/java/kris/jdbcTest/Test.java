package kris.jdbcTest;

import kris.utils.jdbc.mysql.InsertDate;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        InsertDate.getConnection();
        InsertDate.in("well");
    }
}