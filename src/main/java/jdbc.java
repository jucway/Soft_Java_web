package main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc {
    public static void main(String[] args) {
        Connection con = null;

        ResultSet rs = null;
        try {
            // 1. 引入驱动
            String sql = "select * from news_users where usid = 10";
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 访问驱动管理程序
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_news?useSSL=FALSE&serverTimezone=Asia/Shanghai","root","123456");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next())

            {
                // 使用游标获取当前行，每次往下移动
                //获取当前行的每一列数据
                int id = rs.getInt("usid");
                String uname = rs.getString("uname");
                String pwd = rs.getString("upwd");
                System.out.println(id+uname+pwd);
            }

            System.out.println("\t连接成功");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
//            插入数据
            System.out.println("\t插入数据 ");
            // 1. 创建执行语句
            String sql1 = "insert into news_users(uname, upwd) values('zcw', '123456')";
            // 2. 声明用于执行数据库语句
            Statement stmt = con.createStatement();// statement 来执行数据库
            // 3. 将数据执行插入到数据库
            stmt.executeUpdate(sql1);
            System.out.println("\t数据更新成功+'zcw', '123456'！！！");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        try{
//            插入数据
            System.out.println("\t统计数据： ");
            // 1. 创建执行语句
            String sql1 = "select COUNT(*) from news_users";
            // 2. 声明用于执行数据库语句
            Statement stmt = con.createStatement();// statement 来执行数据库
            // 3. 将数据执行插入到数据库
            rs = stmt.executeQuery(sql1);
            rs.next();
            int c = rs.getInt(1);
            System.out.println("\tcount:"+c);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try{
//            插入数据
            System.out.println("\t统计数据： ");
            // 1. 创建执行语句
            String sql1 = "DELETE FROM news_users where usid = 16";
            // 2. 声明用于执行数据库语句
            Statement stmt = con.createStatement();// statement 来执行数据库
            // 3. 将数据执行插入到数据库
            int row = stmt.executeUpdate(sql1);

            System.out.println("\t删除了："+row);

            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
}

