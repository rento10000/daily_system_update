<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>コメント</title>
</head>
<body>
    <h1>コメント</h1>
    <form method="POST" action="/employees/index/">

        <label for="content">内容</label><br />
        <textarea name="content" rows="10" cols="50">${report.content}</textarea>
        <br />
        <br />

        response.sendRedirect(request.getContent());
        <button type="submit">送信</button>
    </form>
</body>
</html>