<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Bienvenue dans ma ${mediatheque.type.nom}</h1>
	<h2>Liste des ${mediatheque.type.media}s</h2>
	<table>
		<tr>
			<th>Nom</th>
			<th>Titre</th>
		</tr>
		<c:forEach var="media" items="${mediatheque.collection}">
			<tr>
				<td>${media.nom}</td>
				<td>${media.titre}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="/TP04-Mediatheque_proposition/ajout.jsp">Ajout d'un ${mediatheque.type.media}</a>
</body>
</html>