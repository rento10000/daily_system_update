<%@ page language="jav送信a" contentType="text/html; charset=UTF-8"
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

        <label for="content">メッセージ</label><br />
<input type="text" name="content" value="${report.message}" />
<br /><br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">送信</button>
        <p>
            <a href="<c:url value='/employees/index' />">一覧に戻る</a>
        </p>

</body>
</html>