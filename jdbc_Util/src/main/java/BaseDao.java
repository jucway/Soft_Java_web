package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BaseDao {
    Connection con = null;
    public Connection getConnection()
    {
        try {
            String sql = "select * from news_users where usid = 10";
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 访问驱动管理程序
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_news?useSSL=FALSE&serverTimezone=Asia/Shanghai","root","123456");
            System.out.println("连接成功");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }

    public void closeDB(Connection con, Statement stamt, ResultSet rs)
    {
        try {
            if(rs != null)
            {
                rs.close();
            }
            if(stamt != null)
            {
                stamt.close();
            }
            if(con != null)
            {
                con.close();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}
