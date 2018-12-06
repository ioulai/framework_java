<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF8"%>

<!-- importer le NameSpace -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajouter une personne</h1>

	<div>
		<!--  Construction d'un formulaire springframework:form -->
		<form:form action="ajout" method="POST">
			<div>
				<form:label path="nom">Nom</form:label>
				<form:input path="nom" />
			</div>
			<div>
				<form:label path="prenom">Prénom</form:label>
				<form:input path="prenom" />
			</div>
			<div>
				<form:label path="adresse.codePostal">Code postal</form:label>
				<form:input path="adresse.codePostal" />
			</div>
			<div>
				<form:label path="adresse.ville">Ville</form:label>
				<form:input path="adresse.ville" />
			</div>
			<div>
				<input type="submit" value="Go !" />
			</div>
		</form:form>

		<!--  Demo sur les dates et heure -->
		<p>Date et heure : ${heure}</p>
		<p>Date et heure de connexion :${heureSession}</p>
		<p>Date et heure du context : ${heureContext}</p>

	</div>
</body>
</html>