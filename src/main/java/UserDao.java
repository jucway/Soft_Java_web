package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao { // 继承

    ResultSet rs = null;
    public List<entry.Users> findAllUsers() throws SQLException {
        // 查询所有用户
        String sql = "select * from news_users";
        Connection con = this.getConnection();
        Statement stamt = null;
        ResultSet rs = null;
        List<entry.Users> list = new ArrayList<>();
        stamt = con.createStatement();
        rs = stamt.executeQuery(sql);

        while (rs.next())
        {

            entry.Users user = new entry.Users();
            user.setId(rs.getInt("usid"));
            user.setUsername(rs.getString("uname"));
            user.setPassword(rs.getString("upwd"));
            list.add(user);
        }

        return list;
    }

    public entry.Users findUsersById(int id) {
        String sql = "SELECT * FROM news_users WHERE usid=?"; // 传进来一个id 返回一个用户

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        entry.Users user = null;
        try {
            pstmt = con.prepareStatement(sql);  //预编译sql
            //设置占位符参数
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if(rs.next()) {  //移动数据库游标 ，往下移一行
                //获取当前行的每一列的数据
                user = new entry.Users();
                user.setId(rs.getInt("usid"));
                user.setUsername(rs.getString("uname"));
                user.setPassword(rs.getString("upwd"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDB(con, pstmt, rs);
        }
        return user;
    }


    /**
     * 添加用户
     * @param user 用户对象的载体
     * @return     返回影响行数
     */
    public int addUser(entry.Users user) { // 返回值是int
        String sql = "INSERT INTO news_users(uname,upwd) VALUES(?,?)";

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try {
            pstmt = con.prepareStatement(sql);  //预编译sql 使用占位符
            //设置占位符参数
            pstmt.setString(1, user.getUsername()); // 用户名在第一位
            pstmt.setString(2, user.getPassword()); // 密码在第二位

            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDB(con, pstmt, null);
        }
        return row;

    }

    /**
     * 修改用户
     * @param user 用户对象的载体
     * @return     返回影响行数
     */
    public int updateUser(entry.Users user) {
        String sql = "UPDATE news_users SET uname=?,upwd=? WHERE usid=?";

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try {
            pstmt = con.prepareStatement(sql);  //预编译sql // 给预编译占位符设置初始值
            //设置占位符参数
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getId());

            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDB(con, pstmt, null);
        }
        return row;

    }


    public int deleteUser(int id) {
        String sql = "DELETE FROM news_users WHERE usid=?";

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try {
            pstmt = con.prepareStatement(sql);  //预编译sql
            //设置占位符参数
            pstmt.setInt(1, id);

            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDB(con, pstmt, null);
        }
        return row;

    }

}
