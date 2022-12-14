<%@ page language="java" contentType="text/html; charset=UTF-8"	
pageEncoding="UTF-8"%>
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
								<c:if test="${vo.depth !=0 }">
								
								
								<c:forEach  begin="0" end="${vo.depth-1 }" step="1">
								<img src='${pageContext.request.contextPath }/assets/images/reply.png' />
								</c:forEach>
								
								</c:if>															
								<a href="${pageContext.request.contextPath }/board/view/${vo.no }">
									${vo.title } 
								</a>
							</td>
							<td>${vo.name }</td>
							<td>${vo.hit }</td>
							<td>${vo.regDate }</td>
							
							<c:if test="${authUser.no == vo.userNo }">
							<td>
								<img src='${pageContext.request.contextPath }/assets/images/recycle.png'  style="width:20px"/>
								<a href="${pageContext.request.contextPath }/board/delete/${vo.no }" class="del">삭제</a>
							</td>
							</c:if>
							
						</tr>
					</c:forEach>
						
				</table>
				<!-- pager 추가 -->
				<div class="pager">
					<ul>
						<li><a href="">◀</a></li>
						<li><a href="">1</a></li>
						<li class="selected">2</li>
						<li><a href="">3</a></li>
						<li>4</li>
						<li>5</li>
						<li><a href="">▶</a></li>
					</ul>
				</div>					
				<!-- pager 추가 -->
				
				
				<c:if test="${authUser != null}">
				
				<div class="bottom">
					<a href="${pageContext.request.contextPath }/board/write" id="new-book">글쓰기</a>
				</div>	
				</c:if>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>