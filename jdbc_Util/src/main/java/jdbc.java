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
            // 1. ��������
            String sql = "select * from news_users where usid = 10";
            Class.forName("com.mysql.cj.jdbc.Driver");
            // ���������������
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_news?useSSL=FALSE&serverTimezone=Asia/Shanghai","root","123456");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next())

            {
                // ʹ���α��ȡ��ǰ�У�ÿ�������ƶ�
                //��ȡ��ǰ�е�ÿһ������
                int id = rs.getInt("usid");
                String uname = rs.getString("uname");
                String pwd = rs.getString("upwd");
                System.out.println(id+uname+pwd);
            }

            System.out.println("\t���ӳɹ�");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try{
//            ��������
            System.out.println("\t�������� ");
            // 1. ����ִ�����
            String sql1 = "insert into news_users(uname, upwd) values('zcw', '123456')";
            // 2. ��������ִ�����ݿ����
            Statement stmt = con.createStatement();// statement ��ִ�����ݿ�
            // 3. ������ִ�в��뵽���ݿ�
            stmt.executeUpdate(sql1);
            System.out.println("\t���ݸ��³ɹ�+'zcw', '123456'������");
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        try{
//            ��������
            System.out.println("\tͳ�����ݣ� ");
            // 1. ����ִ�����
            String sql1 = "select COUNT(*) from news_users";
            // 2. ��������ִ�����ݿ����
            Statement stmt = con.createStatement();// statement ��ִ�����ݿ�
            // 3. ������ִ�в��뵽���ݿ�
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
//            ��������
            System.out.println("\tͳ�����ݣ� ");
            // 1. ����ִ�����
            String sql1 = "DELETE FROM news_users where usid = 16";
            // 2. ��������ִ�����ݿ����
            Statement stmt = con.createStatement();// statement ��ִ�����ݿ�
            // 3. ������ִ�в��뵽���ݿ�
            int row = stmt.executeUpdate(sql1);

            System.out.println("\tɾ���ˣ�"+row);

            System.out.println();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    }
}

