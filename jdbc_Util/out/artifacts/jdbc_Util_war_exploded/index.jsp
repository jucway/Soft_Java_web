<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: HP--%>
<%--  Date: 2021/12/28--%>
<%--  Time: 11:07--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--  <head>--%>
<%--    <title>Jucw's Home</title>--%>
<%--&lt;%&ndash;    t索引页面需要修改&ndash;%&gt;--%>
<%--  </head>--%>
<%--  <body>--%>
<%--  </body>--%>
<%--</html>--%>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%--<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="function" %>
<jsp:include page="./index-elements/index_top.jsp"></jsp:include>
<div id="container">
  <jsp:include page="./index-elements/index_sidebar.jsp" />
  <div class="main">
    <div class="class_type">
      <img src="./Images/class_type.gif" alt="新闻中心" />
    </div>
    <div class="content">
      <ul class="class_date">
        <!--遍历 显示topic list -->
        <li id='class_month'><a href="index.jsp?tid=1"><b></b> </a> <!--遍历 显示topic list -->
      </ul>

      <ul class="classlist">

        <!-- 遍历显示 news list  -->
        <c:forEach var="news" items="${newsList}">
          <li><a href="${pageContext.request.contextPath}/news?action=detail&nid=${news.nid}">${news.ntitle}</a> <span>${news.ncreatedate}</span></li>

          <%--          <li><a href="news_read.jsp?nid=1">${news.ntitle}</a> <span>${news.ncreatedate}</span></li>--%>
        </c:forEach>>
        <!-- 遍历显示 news list  -->

        <!-- 分页显示 -->
        <p align="right">
          当前页数:[   ${pageNum}/${allPage} ]&nbsp;&nbsp;&nbsp;总记录数${allCount} &nbsp; <a
                href="${pageContext.request.contextPath}//news?action=newsList&pageNum=1">首页</a><a
                href="${pageContext.request.contextPath}//news?action=newsList&pageNum=${prev}">&nbsp;&nbsp;上一页</a><a
                href="${pageContext.request.contextPath}//news?action=newsList&pageNum=${next}">&nbsp;&nbsp;下一页</a> <a
                href="${pageContext.request.contextPath}//news?action=newsList&pageNum=${allPage}">&nbsp;&nbsp;末页</a>
        </p>

      </ul>
    </div>
    <jsp:include page="./index-elements/index_rightbar.html" />
  </div>
</div>

<jsp:include page="./index-elements/index_bottom.html" />
