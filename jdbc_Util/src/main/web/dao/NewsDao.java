package main.web.dao;

import main.java.BaseDao;
import main.web.entity.News;
import main.web.entity.NewsDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsDao extends BaseDao {

    public List<News> findAllNews(){
        // 查询所有新闻结果列表
        String sql = "SELECT * FROM news";
        Connection con = this.getConnection();
        PreparedStatement pstam = null;
        ResultSet rs = null;
        List<News> list = new ArrayList<>();
        try {
            pstam = con.prepareStatement(sql);
            rs = pstam.executeQuery();
            while (rs.next())
            {
                News news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getString("ncreatedate"));
                news.setNcontent(rs.getString("ncontent"));
                news.getNsummary(rs.getString("nsummary"));
                news.getNpicpath(rs.getString("npicpath"));
                list.add(news);
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



    public List<News> findNewsByPage(int PageNum, int PageSize){
        // 查询所有新闻结果列表
        String sql = "SELECT * FROM news LIMIT ?,?";
        Connection con = this.getConnection();
        PreparedStatement pstam = null;
        ResultSet rs = null;
        List<News> list = new ArrayList<>();
        try {
            pstam = con.prepareStatement(sql);
            pstam.setInt(1,(PageNum-1)*PageSize);
            pstam.setInt(2,PageSize);
            rs = pstam.executeQuery();
            while (rs.next())
            {
                News news = new News();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getString("ncreatedate"));
                news.setNcontent(rs.getString("ncontent"));
                news.getNsummary(rs.getString("nsummary"));
                news.getNpicpath(rs.getString("npicpath"));
                list.add(news);
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


    public int getAllCount(){
        // 查询所有新闻结果列表
        String sql = "SELECT COUNT(*) FROM news;";
        Connection con = this.getConnection();
        PreparedStatement pstam = null;
        ResultSet rs = null;
        int count = 0;
        try {
            pstam = con.prepareStatement(sql);
            rs = pstam.executeQuery();
            rs.next();
            count = rs.getInt(1);
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            this.closeDB(con, pstam, rs);
        }
        return count;
    }


    public  NewsDetail findNewById(int nid){
        // 查询所有新闻结果列表
        String sql = "select n.*, t.tname from news n, topic t where n.ntid=t.tid AND nid=?";
        Connection con = this.getConnection();
        PreparedStatement pstam = null;
        ResultSet rs = null;
        NewsDetail news = null;

        try {
            pstam = con.prepareStatement(sql);
            pstam.setInt(1,nid);

            rs = pstam.executeQuery();
            if (rs.next()) // 查找id，如果找到就返回这条新闻的全部消息
            {
                news = new NewsDetail();
                news.setNid(rs.getInt("nid"));
                news.setNtid(rs.getInt("ntid"));
                news.setNtitle(rs.getString("ntitle"));
                news.setNauthor(rs.getString("nauthor"));
                news.setNcreatedate(rs.getString("ncreatedate"));
                news.setNcontent(rs.getString("ncontent"));
                news.getNsummary(rs.getString("nsummary"));
                news.getNpicpath(rs.getString("npicpath"));
                news.setTname(rs.getString("tname")); // 添加新闻

            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            this.closeDB(con, pstam, rs);
        }
        return news;
    }


}
