<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${article }
<h2>게시판 글 수정</h2>
<form action = "boardModifyPro.do" method="post" name="modifyform">
<input type = "hidden" name="board_num" value="${board_num }" />
	<table>
				<tr>
					<td><label for="BOARD_NAME">글쓴이</label></td>
					<th><input type="text" name="BOARD_NAME" id="BOARD_NAME"
						required="required" readonly value="${board_name }" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_PASS">비밀번호</label></td>
					<th><input type="password" name="BOARD_PASS" id="BOARD_PASS"
						required="required" value="${board_pass }" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_SUBJECT">제목</label></td>
					<th><input type="text" name="BOARD_SUBJECT" id="BOARD_SUBJECT"
						required="required" value="${board_subject }" /></th>
				</tr>
				<tr>
					<td><label for="BOARD_CONTENT">내용</label></td>
					<th><textarea id="BOARD_CONTENT" name="BOARD_CONTENT"
							cols="40" rows="15" required="required" value="${board_content }" ></textarea></th>
				</tr>
				<tr>
					<td colspan="2">
						<section>
							<a href = "javascript:modifyboard()">[수정]</a>
							<a href = "javascript:history.go(-1)">[뒤로]</a>
						</section>
					</td>
				</tr>
	</table>
</form>
</body>
</html>