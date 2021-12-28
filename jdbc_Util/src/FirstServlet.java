import main.java.UserDao;
import main.java.entry;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class FirstServlet extends HttpServlet {
//    @Override
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name=req.getParameter("name"); //�յ��������name
//        String html="<h1 style='color:red'>hi,"+name+"!</h1><hr/>"; //׼�����ظ����������Ӧ����
//        System.out.println("���ظ����������Ӧ����Ϊ:"+html);
//        PrintWriter out= resp.getWriter();  //��Ӧ�����������
//        out.println(html);  //��ӡ����

        resp.setContentType("text/html,charset=utf8");

        try {
            UserDao userDao = new UserDao();
            List<entry.Users> list = userDao.findAllUsers();
            System.out.println(list);;
            //�û��б��浽��������
            req.setAttribute("userList",list);
            // ��ת��.jsp
            req.getRequestDispatcher("userList.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
