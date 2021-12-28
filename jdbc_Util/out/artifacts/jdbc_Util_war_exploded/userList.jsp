<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2021/12/28
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>>>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<%
    //完成格式化输出当前日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String time = sdf.format(new Date());
%>
<font size="13" color="#7fffd4">当前时间：<%=time%></font>
<table width="50%" border="1px">

    <c:forEach var="user" items="${userList}">
        <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        </tr>
    </c:forEach>
<%--    todo:将表单数据返回后，下一步是将数据进行美化界面--%>
</table>
</body>
</html>
