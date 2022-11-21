<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%	pageContext.setAttribute("newline", "\n");%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="${pageContext.request.contextPath}/board/add" method="post">
					<input type="text" id="kwd" name="kwd" value=""> 
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" var="vo" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td style="text-align:left; padding-left:${0*20}px">
								<c:if test="${BoardVo.depth !=0 }">
								
								
								<c:forEach  begin="0" end="${BoardVo.depth-1 }" step="1">
								<img src='${pageContext.request.contextPath }/assets/images/reply.png' />
								</c:forEach>
								
								</c:if>															
								<a href="${pageContext.request.contextPath }/board?a=view&no=${BoardVo.no }">
									${BoardVo.title } 
								</a>
							</td>
							<td>${vo.name }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							<td>
								<a href="${pageContext.request.contextPath }/board?a=delete&na=${BoardVo.no }" class="del">삭제</a>
							</td>
						</tr>
					</c:forEach>
						
				</table>

				<!-- pager 추가 -->
				
				
				<c:if test="${authUser != null}">
				
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board?a=writeform" id="new-book">글쓰기</a>
				</div>	
				</c:if>
			</div>
		</div>
	</div>
	<c:import url="/WEB-INF/views/includes/navigation.jsp" />
	<c:import url="/WEB-INF/views/includes/footer.jsp" />
</body>
</html>