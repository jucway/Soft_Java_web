import main.web.dao.CommentDao;
import main.web.dao.NewsDao;
import main.web.entity.Comment;
import main.web.entity.News;
import main.web.entity.NewsDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class NewsServlet extends HttpServlet {
    public static int PageSize = 4;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if("newsList".equals(action)) {
            doListNews(req, resp);
        }

        // ���ŵ������ѯ
        else if("detail".equals(action))
        {
            doDetail(req,resp);
        }
        else if("newComment".equals(action))
            donewComment(req,resp);
        }

    private void donewComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CommentDao commentDao = new CommentDao();
        Comment comment = new Comment();
        int nid = Integer.parseInt(req.getParameter("nid"));
        comment.setCnid(nid);
        comment.setCip(req.getParameter("cip"));
        String str = new String(req.getParameter("cauthor").getBytes("ISO-8859-1"),"utf-8");
        comment.setCauthor(str);
        String cont = new String(req.getParameter("ccontent").getBytes("ISO-8859-1"),"utf-8");
        comment.setCcontent(cont);
        commentDao.addComment(comment);
        req.getRequestDispatcher("/news?action=detail&nid="+nid).forward(req,resp);
    }


    private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        NewsDao newsDao = new NewsDao();
        CommentDao commentDao = new CommentDao();

        // ��ȡ���ӵ�id
        int nid = Integer.parseInt(req.getParameter("nid"));
        NewsDetail news = newsDao.findNewById(nid);
        List<Comment> commentList = commentDao.findCommentByNews(nid);

//        req.setAttribute("allCount", allCount);
        req.setAttribute("news", news);
        req.setAttribute("commentList", commentList);
        req.getRequestDispatcher("news_read.jsp").forward(req,resp);

    }


    private void doListNews(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        NewsDao newsDao = new NewsDao();
        // �ҵ������б� todo���������б���ȡ����
//        List<News> newsList = newsDao.findAllNews();
//        NewsDao newsDao = new NewsDao();

        int allPage = 0;
        int pageNum = 1;
        if (req.getParameter("pageNum") != null) {
            pageNum = Integer.parseInt(req.getParameter("pageNum")); // ��ȡҳ��
        }
        List<News> newsList = newsDao.findNewsByPage(pageNum, PageSize);
        int allCount = newsDao.getAllCount();
        // ��������
        if (allCount % PageSize != 0) {
            allPage = allCount / PageSize + 1;
        } else {
            allPage = allCount / PageSize;
        }
        int next = pageNum; // ��һҳ
        int prev = pageNum; // ��һҳ
        // �ж�ҳ��ı߽� �������һҳ��û����һҳ
        if (pageNum <= 1) {
            next++;
            prev = 1;
        } else if (pageNum >= allPage) // βҳ
        {
            next = allPage;
            prev--;
        }
        // �����еķ�ҳ�������浽������
        req.setAttribute("allCount", allCount);
        req.setAttribute("allPage", allPage);
        req.setAttribute("next", next);
        req.setAttribute("prev", prev);
        req.setAttribute("newsList", newsList);
        req.setAttribute("pageNum", pageNum);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);

    }
}
// todo: ���沼�ֵĻ�����web ǰ������