package main.web.dao;

import main.java.BaseDao;
import main.web.entity.News;

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


}
