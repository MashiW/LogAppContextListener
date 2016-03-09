package contextlogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    /**
     * Database connection class
     */

   private static Connection conn;

    public Database(String dburl, String dbUname, String dbPasswd){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            this.conn = DriverManager.getConnection(dburl, dbUname, dbPasswd);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConn(){
        return conn;
    }
    public ResultSet runSql(String sql) throws SQLException{
        Statement sta = conn.createStatement();
        return  sta.executeQuery(sql);
    }
}
