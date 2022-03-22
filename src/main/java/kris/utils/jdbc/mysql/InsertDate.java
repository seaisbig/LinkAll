package kris.utils.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertDate {
    private static Connection conn = null;
    public static Connection getConnection() {
        if (null == conn) {
            try {
                // 加载驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                // 创建数据库连接
                // 数据库地址
                String url = "jdbc:mysql://localhost:3306/textfiles?serverTimezone=UTC";
                // 数据库密码
                String passWord = "root";
                // 数据库用户名
                String userName = "root";
                conn = DriverManager.getConnection(url, userName, passWord);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void in(String m) throws SQLException {
        // 准备sql
        String sql = "INSERT INTO textfile(File) VALUES(?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,m);
        Connection conn = getConnection();
        ps.executeUpdate();
        conn.close();
        ps.close();
        System.out.println("**insert OK**");
    }
}