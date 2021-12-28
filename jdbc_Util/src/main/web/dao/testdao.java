package main.web.dao;


import main.java.UserDao;
import main.java.entry;
import main.web.entity.News;

import java.sql.SQLException;
import java.util.List;

public class testdao {
    private static int id = 1;
    private int row = 1;

    public static void main(String[] args) throws SQLException {
        NewsDao newsDao = new NewsDao();
        List<News> list = newsDao.findAllNews();


        for (News news : list) {
            System.out.println(news.getNid() + ',' + news.getNtid() + "," + news.getNauthor());
        }
    }
}