<%@page import="board_Proj.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/index.css">
</head>
<body>
<a href="boardWriteForm.do"><button>게시판 글쓰기</button></a>
<a href = "boardList.do"><button>글 목록</button></a>
</body>
</html>