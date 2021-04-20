<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/board_view.css">
</head>
<body>
	<section id="articleForm">
		<h1>글 내용 상세보기</h1>
		<section id="basicInfoArea">
			<table>
				<tr>
					<td>제목</td>
					<th>${article.board_subject }</th>
				</tr>
				<tr>
					<td>작성자</td>
					<th>${article.board_name }</th>
				</tr>
				<tr>
					<td>작성날자</td>
					<th>${article.board_date }</th>
				</tr>
				<tr>
					<td>조회수</td>
					<th>${article.board_readcount }</th>
				</tr>
				<tr>
					<td><span id="attach"> 첨부파일</td>
					<th><c:if test="${article.board_file ne null }">
							<a href="file_down?downFile=${article.board_file }">${article.board_file }</a>
						</c:if> </span></th>
				</tr>
		</section>
		<tr>
			<td colspan="2" class="content" cols="40" rows="15">
				<section id="articleContentArea">${article.board_content }
				</section>
			</td>
		</tr>
	</section>
	<tr>
		<td colspan="2" class="icon">
			<section id="commandList">
				<a
					href="boardReplyForm.do?board_num=${article.board_num }&page=${page }">[답변]</a>&nbsp;
				<a href="boardModifyForm.do?board_num=${article.board_num }">[수정]</a>&nbsp;
				<a
					href="boardDeleteForm.do?board_num=${article.board_num }&page=${page }">[삭제]</a>&nbsp;
				<a href="boardList.do?page=${page}">[목록]</a>&nbsp;
			</section>
		</td>
	</tr>
	</table>
</body>
</html>