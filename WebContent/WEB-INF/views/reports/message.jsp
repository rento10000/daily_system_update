<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>メッセージ</title>
</head>
<body>
     <form method="POST" action="<c:url value='/reports/show' />">
        <label for="message">メッセージ</label><br />
        <textarea rows="5" cols="25" name="message"></textarea>
        <br />
        <br />
        <input type="hidden" name="id" value="${id}" />
        <input type="hidden" name="_token" value="${_token}" />
        <button type="submit">送信</button>
        <p>
            <a href="<c:url value='/employees/index' />">一覧に戻る</a>
        </p>
        </form>
</body>
</html>