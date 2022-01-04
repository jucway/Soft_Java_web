package main.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends BaseDao { // �̳�

    ResultSet rs = null;
    public List<entry.Users> findAllUsers() throws SQLException {
        // ��ѯ�����û�
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
        String sql = "SELECT * FROM news_users WHERE usid=?"; // ������һ��id ����һ���û�

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        entry.Users user = null;
        try {
            pstmt = con.prepareStatement(sql);  //Ԥ����sql
            //����ռλ������
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            if(rs.next()) {  //�ƶ����ݿ��α� ��������һ��
                //��ȡ��ǰ�е�ÿһ�е�����
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
     * ����û�
     * @param user �û����������
     * @return     ����Ӱ������
     */
    public int addUser(entry.Users user) { // ����ֵ��int
        String sql = "INSERT INTO news_users(uname,upwd) VALUES(?,?)";

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try {
            pstmt = con.prepareStatement(sql);  //Ԥ����sql ʹ��ռλ��
            //����ռλ������
            pstmt.setString(1, user.getUsername()); // �û����ڵ�һλ
            pstmt.setString(2, user.getPassword()); // �����ڵڶ�λ

            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeDB(con, pstmt, null);
        }
        return row;

    }

    /**
     * �޸��û�
     * @param user �û����������
     * @return     ����Ӱ������
     */
    public int updateUser(entry.Users user) {
        String sql = "UPDATE news_users SET uname=?,upwd=? WHERE usid=?";

        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try {
            pstmt = con.prepareStatement(sql);  //Ԥ����sql // ��Ԥ����ռλ�����ó�ʼֵ
            //����ռλ������
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
            pstmt = con.prepareStatement(sql);  //Ԥ����sql
            //����ռλ������
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
