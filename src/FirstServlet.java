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
//        String name=req.getParameter("name"); //收到请求参数name
//        String html="<h1 style='color:red'>hi,"+name+"!</h1><hr/>"; //准备返回给浏览器的响应数据
//        System.out.println("返回给浏览器的响应数据为:"+html);
//        PrintWriter out= resp.getWriter();  //响应的输出流方法
//        out.println(html);  //打印出来

        resp.setContentType("text/html,charset=utf8");

        try {
            UserDao userDao = new UserDao();
            List<entry.Users> list = userDao.findAllUsers();
            System.out.println(list);;
            //用户列表保存到作用域中
            req.setAttribute("userList",list);
            // 跳转到.jsp
            req.getRequestDispatcher("userList.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
