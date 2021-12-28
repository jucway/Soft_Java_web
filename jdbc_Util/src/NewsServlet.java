import main.web.dao.NewsDao;
import main.web.entity.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class NewsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsDao newsDao = new NewsDao();
        // �ҵ������б� todo���������б���ȡ����
        List<News> newsList = newsDao.findAllNews();
        for (News news : newsList) {
            System.out.println(news.getNid() + ',' + news.getNtid() + "," + news.getNauthor());
        }
        req.setAttribute("newsList",newsList);
        // ��ת��.jsp
        req.getRequestDispatcher("/index.jsp").forward(req,resp);


    }
}
// todo: ���沼�ֵĻ�����web ǰ������