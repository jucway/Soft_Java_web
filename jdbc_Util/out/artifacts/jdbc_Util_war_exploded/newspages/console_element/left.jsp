<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 <div id="opt_list">
  <ul>
    <li><a href="${pageContext.request.contextPath}/newspages/news_add.jsp">添加新闻</a></li>
    <li><a href="${pageContext.request.contextPath}/AdminServlet?action=adminIndex">编辑新闻</a></li>
    <li><a href="${pageContext.request.contextPath}/newspages/topic_add.jsp">添加主题</a></li>
    <li><a href="../topic_list.jsp">编辑主题</a></li>
  </ul>
</div>
