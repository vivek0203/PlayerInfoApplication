package player_info_application.player_info_application.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    static Connection conn;
    public static Connection createConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String dbUrl = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String pass = "password";

            conn = DriverManager.getConnection(dbUrl,user,pass);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return conn;

    }
}