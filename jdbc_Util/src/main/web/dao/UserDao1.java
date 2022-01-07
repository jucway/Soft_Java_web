package main.web.dao;
import main.java.BaseDao;
import main.web.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 返回用户对象，判断是否为空
public class UserDao1 extends BaseDao {
    public User login(String username, String password){
        String sql = "select * from news_users where uname=? and upwd=?";
        Connection con = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User loginUser = null;
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                loginUser = new User();
                loginUser.setUid(rs.getInt("usid"));
                loginUser.setUpwd(rs.getString("upwd"));
                loginUser.setUname(rs.getString("uname"));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            this.closeDB(con, pstmt, rs);
        }
        return loginUser;

    }

    public static void main(String[] args) {
        String username  = "admin";
        String userpwd = "admin";
        UserDao1 userDao = new UserDao1();
        User loginUser = userDao.login(username,userpwd);
        System.out.println(loginUser.getUname());
    }
}
