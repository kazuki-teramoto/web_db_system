<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>検索結果</title>
</head>
<body>
    <h2>検索結果</h2>
    <p>全${web_db_count}件見つかりました。</p>
    <table border="1">
        <tbody>
            <tr>
                <th>曲ID</th>
                <th>曲名</th>
                <th>コメント</th>
                <th>アーティスト番号</th>
                <th>曲調番号</th>
                <th>作曲年月日</th>
                <th>シリーズ番号</th>
            </tr>
            <c:forEach var="web_db" items="${web_dbs}" varStatus="status">
                    <tr class="row${status.count % 2}">
                        <td><c:out value="${web_db.song_id}" /></td>
                        <td><c:out value="${web_db.song_title}" /></td>
                        <td><c:out value="${web_db.comment}" /></td>
                        <td><c:out value="${web_db.artist_num}" /></td>
                        <td><c:out value="${web_db.tune_num}" /></td>
                        <td><c:out value="${web_db.composition_ymd}" /></td>
                        <td><c:out value="${web_db.series_num}" /></td>
                    </tr>
                </c:forEach>
        </tbody>
    </table>
</body>
</html>