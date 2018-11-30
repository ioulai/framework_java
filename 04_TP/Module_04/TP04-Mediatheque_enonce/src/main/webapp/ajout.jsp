<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mediatheque</title>
</head>
<body>
	<!--  utilisation d'un obj java dans le vue JSP -->
	<h1>Bienvenue dans ma ${mediatheque.type.nom}</h1>
	<h2>Ajout d'un ${mediatheque.type.media}</h2>
	
	<form action = "ajouter" method="post">
		Nom : <input type = "text" name ="nom"> <br>
		Titre : <input type = "text" name ="titre"> <br>
		<input type = "submit" name ="ajout"> <br>
	</form>
	
	<br>
	<!-- Une vue en Java est très souvent au format JSP = Framework officel -->
	<a href="affiche.jsp">Retour</a>
</body>
</html>