<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アーティスト名検索用フォーム</title>
</head>
<body>
    <p>アーティスト名</p>
        <form action="http://localhost:8080/web_kadai/m_serch" method="post">
        <select name="music_result">
            <c:forEach var="web_db" items="${web_dbs}" varStatus="status">
                <option value="${web_db.artist_name}">
                    <c:out value="${web_db.artist_name}" />
                </option>
            </c:forEach>
        </select>
    <input type="submit" value="Serch">
        </form>
</body>
</html>