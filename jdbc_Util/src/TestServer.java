import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//
//@WebServlet("/Servlet/TestServer")
public class TestServer extends HttpServlet {

    protected void server(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应的编码
        resp.setContentType("text/html,charset=utf8");

//网页的输出流
        PrintWriter out = resp.getWriter();
        out.print("这是第一个程序");
        out.flush();
        out.close();
    }
}
