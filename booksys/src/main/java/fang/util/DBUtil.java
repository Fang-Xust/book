package fang.util;/*
 * @Program:booksys
 * @Description:description
 * @Author:Pufang
 * @Time:2020-07-03 19-48-34
 **/

import java.sql.Connection;

//import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import fang.exception.SystemException;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/book?serverTimezone=GMT";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static volatile DataSource DATA_SOURCE;
    private  DBUtil(){}
    private static DataSource getDataSource(){
        if(DATA_SOURCE == null){
            synchronized (DBUtil.class){
                if(DATA_SOURCE == null){
                    DATA_SOURCE = new MysqlDataSource();
                    ((MysqlDataSource)DATA_SOURCE).setUrl(URL);
                    ((MysqlDataSource)DATA_SOURCE).setUser(USERNAME);
                    ((MysqlDataSource)DATA_SOURCE).setPassword(PASSWORD);
                }
            }
        }
        return DATA_SOURCE;
    }
    public static java.sql.Connection getConnection(){
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            throw new SystemException("000001","获取数据库连接失败",e);
        }
    }
    public static void close(Connection c, Statement s){
        close(c, s, null);
    }

    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(r != null)
                r.close();
            if(s != null)
                s.close();
            if(c != null)
                c.close();
        } catch (SQLException e) {
            throw new SystemException("000002","释放数据库资源出错", e);
        }
    }
}
