package com.example.demo.util; /**
 * 刘广
 * @time2021-05-20
 */
import java.sql.*;
public class JDBCUtil {

    static final String DriverName="org.apache.hive.jdbc.HiveDriver";
    static final String url="jdbc:hive2://10.180.59.226:10000/default";
    static final String user="bonc";
    static final String pass="gpadmin";


    /**
     * 创建连接，漏洞扫描导致此处注解
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
//    public static Connection getConn() throws ClassNotFoundException, SQLException {
//        Class.forName(DriverName);
//        Connection connection = DriverManager.getConnection(url,user,pass);
//        return connection;
//    }

    /**
     * 创建命令
     * @param connection
     * @return
     * @throws SQLException
     */
    public static Statement getStmt(Connection connection) throws SQLException {
        return connection.createStatement();
    }

    /**
     * 关闭连接
     * @param connection
     * @param statement
     * @throws SQLException
     */
    public static void closeFunc(Connection connection,Statement statement) throws SQLException {
        statement.close();
        connection.close();
    }

}


