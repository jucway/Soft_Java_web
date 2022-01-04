package main.web.dao;

import main.java.BaseDao;
import main.web.entity.Comment;
import main.web.entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class CommentDao extends BaseDao {
    // 查询评论链表

    public List<Comment> findCommentByNews(int nid){
        // 查询所有新闻结果列表
        String sql = "SELECT * FROM comments where cnid=?";
        Connection con = this.getConnection();
        PreparedStatement pstam = null;
        ResultSet rs = null;
        List<Comment> list = new ArrayList<>();
        try {
            pstam = con.prepareStatement(sql);
            pstam.setInt(1,nid);
            rs = pstam.executeQuery();
            while (rs.next())
            {
                Comment comment = new Comment();
                comment.setCid(rs.getInt("cid"));
                comment.setCnid(rs.getInt("cnid"));
                comment.setCcontent(rs.getString("ccontent"));
                comment.setCdate(rs.getString("cdate"));
                comment.setCip(rs.getString("cip"));
                comment.setCauthor(rs.getString("cauthor"));
                list.add(comment);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            this.closeDB(con, pstam, rs);
        }
        return list;
    }


    public int addComment(Comment comment){
        String sql = "insert into comments (cnid, ccontent, cdate, cip, cauthor)\n" +
                "values (?,?,now(),?,?)";
        Connection con = this.getConnection();
        PreparedStatement pstmt = null;

        int row = 0;
        try{
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, comment.getCnid());
            pstmt.setString(2, comment.getCcontent());
            pstmt.setString(3, comment.getCip());
            pstmt.setString(4, comment.getCauthor());

            row = pstmt.executeUpdate();
        }
        catch (Exception e)
        {

        }
        return row;
    }
}
