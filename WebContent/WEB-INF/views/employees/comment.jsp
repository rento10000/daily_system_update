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
    <form method="POST" action="/daily_report_system/reports/show">
        <label for="message">内容</label><br />
        <textarea name="message" rows="10" cols="50">${report.message}</textarea>
        <br />
        <br />
        <button type="submit">送信</button>
        <p>
            <a href="<c:url value='/employees/index' />">一覧に戻る</a>
        </p>
    </form>
</body>
</html>