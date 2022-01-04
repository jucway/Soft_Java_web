<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html; charset=utf-8"%>
<jsp:include page="index-elements/index_top.jsp" />

<link href="CSS/read.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkComment() {
	var cauthor = document.getElementById("cauthor");
	var content = document.getElementById("ccontent");
	if (cauthor.value == "") {
		alert("用户名不能为空！！");
		return false;
	} else if (content.value == "") {
		alert("评论内容不能为空！！");
		return false;
	}
	return true;
}
</script>


<div id="container">
	<jsp:include page="index-elements/index_sidebar.jsp"></jsp:include>
	<div class="main">
		<div class="class_type">
			<img src="Images/class_type.gif" alt="新闻中心" />
		</div>
		<div class="content">
			<ul class="classlist">
				<table width="80%" align="center">

					<tr width="100%">
						<td colspan="2" align="center">
							<!-- news title -->
							${news.ntitle}
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr />
						</td>
					</tr>
					<tr>
						<td align="center">
							作者: &nbsp;&nbsp;${news.nauthor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							类型：
							<a href="web/index.jsp?tid=1">${news.tname}<!-- tname --></a>
						</td>
						<td align="left">
							发布时间:${news.ncreatedate} <!-- ncreatedate -->
						</td>
					</tr>
					<tr>
						<td align="right">
<%--							摘要：${news.nsummary}<!-- nsummary -->--%>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="center"></td>
					</tr>
					<tr>
						<td colspan="2">
							<!-- ncontent -->
							${news.ncontent}
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<hr />
						</td>
					</tr>
				</table>

			</ul>
			<ul class="classlist">
				<table width="80%" align="center">
					
					<!--  暂无评论！ -->
					<c:if test="${fn:length(commentList)==0}">
						<td colspan="6">
							暂无评论！
						</td>
						<tr>
							<td colspan="6">
								<hr />
							</td>
						</tr>
					</c:if>
						<!--  -->
					<!-- 有评论 -->
					<c:if test="${fn:length(commentList)!=0}">
						<!-- 遍历评论列表 -->
						<c:forEach var="comment" items="${commentList}">

							<tr>
								<td>
									留言人：
								</td>
								<td>
									${comment.cauthor}
								</td>
								<td>
									IP：
								</td>
								<td>
										${comment.cip}
								</td>
								<td>
									留言时间：
								</td>
								<td>
										${comment.cdate}
								</td>
							</tr>
							<tr>
								<td colspan="6">
										${comment.ccontent}
								</td>
							</tr>
							<tr>
								<td colspan="6">
									<hr />
								</td>
							</tr>
						</c:forEach>
						<!-- 遍历评论列表 -->
					</c:if>>
					<!-- 有评论 -->
				</table>
			</ul>
			<ul class="classlist">
				<form action="${pageContext.request.contextPath}/news?action=newComment"
					method="post" onSubmit="return checkComment()">
					<input type="hidden" name="nid" value="${news.nid}">
					<table width="80%" align="center">
						<tr>
							<td>
								评 论
							</td>
						</tr>
						<tr>
							<td>
								用户名：
							</td>
							<td>
								<input id="cauthor" name="cauthor" value="这家伙很懒什么也没留下" />
								IP：
<%--								<input name="cip" value="cip" readonly="readonly" />--%>
								<input name="cip" value="cip" />
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<textarea name="ccontent" cols="70" rows="10"></textarea>
							</td>
						</tr>
						<td>
							<input name="submit" value="发  表" type="submit" />
						</td>
					</table>
				</form>
			</ul>
		</div>
	</div>
</div>
<%
	request.removeAttribute("news_view");
	request.removeAttribute("comments_view");
%>
<jsp:include page="index-elements/index_bottom.html" />
