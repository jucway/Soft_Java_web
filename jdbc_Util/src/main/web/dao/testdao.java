package main.web.dao;


import main.java.UserDao;
import main.java.entry;
import main.web.entity.News;
import main.web.entity.NewsDetail;

import java.sql.SQLException;
import java.util.List;

public class testdao {
    private static int id = 1;
    private int row = 1;

    public static void main(String[] args) throws SQLException {
        int nid = 63;
        NewsDao newsDao = new NewsDao();
        NewsDetail news = newsDao.findNewById(nid);

        System.out.println(newsDao.findNewById(nid));
//

//
    }
}