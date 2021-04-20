<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
</head>
<body>
	<section id = "passForm">
		<form name="deleteForm" action="boardDelete.do">
		<input type="hidden" name="board_num" value="${board_num }" />
		<input type="hidden" name="page" value="${page }" />
		<table>
			<tr>
				<td><label>글 비밀번호</label><td><input name="board_pass" type="password" size="20" id="pass" autofocus required></td>
			</tr>
			<tr>
				<td><input type="submit" value="삭제" />&nbsp;&nbsp;<input type="button" value="돌아가기" onclick="javascript:history.go(-1)" />
			</tr>
		</table>		
		</form>
	</section>
</body>
</html>