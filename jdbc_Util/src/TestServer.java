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
        // ������Ӧ�ı���
        resp.setContentType("text/html,charset=utf8");

//��ҳ�������
        PrintWriter out = resp.getWriter();
        out.print("���ǵ�һ������");
        out.flush();
        out.close();
    }
}
