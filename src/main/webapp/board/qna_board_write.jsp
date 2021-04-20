<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판 글쓰기</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/board_write.css">
</head>
<body>
	<h2>게시판 글 등록</h2>
	<!-- 게시판 등록 -->
	<section id="writeForm">
		<table>
			<form action="boardWritePro.do" method="post"
				enctype="multipart/form-data" name="boardform">

				<tr>
					<td><label for="BOARD_NAME">글쓴이</label></td>
					<th><input type="text" name="BOARD_NAME" id="BOARD_NAME"
						required="required" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_PASS">비밀번호</label></td>
					<th><input type="password" name="BOARD_PASS" id="BOARD_PASS"
						required="required" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_SUBJECT">제목</label></td>
					<th><input type="text" name="BOARD_SUBJECT" id="BOARD_SUBJECT"
						required="required" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_CONTENT">내용</label></td>
					<th><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15" required="required"></textarea></th>
				</tr>
				<tr>
					<td><label for="BOARD_FILE">파일 첨부</label></td>
					<th><input type="file" name="BOARD_FILE" id="BOARD_FILE"
						required="required" /></th>
				</tr>
				<tr>
					<td colspan="2">
						<section>
							<input type="submit" value="등록">&nbsp;&nbsp; <input
								type="reset" value="다시 쓰기">
						</section>
					</td>
				</tr>

			</form>
		</table>
	</section>
	<!-- 게시판 등록 -->
</body>
</html>