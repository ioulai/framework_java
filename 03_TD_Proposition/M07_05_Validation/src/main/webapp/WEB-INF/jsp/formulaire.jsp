<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>

<!-- importer le NameSpace -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.erreur {
	color: red;
}
</style>
</head>
<body>
	<h1>Authentification</h1>

	<div>
		<!--  Construction d'un formulaire springframework:form -->
		<form:form action="formulaire" method="POST" commandName="pers">
			<div>
				<form:label path="nom">Nom</form:label>
				<form:input path="nom" />
				<form:errors path="nom" cssClass="erreur"></form:errors>
			</div>
			<div>
				<form:label path="email">Email</form:label>
				<form:input path="email" />
				<form:errors path="email" cssClass="erreur"></form:errors>
			</div>
			<div>
				<form:label path="codePostal">Code postal</form:label>
				<form:input path="codePostal" />
				<form:errors path="codePostal" cssClass="erreur"></form:errors>
			</div>
			<div>
				<form:label path="age">Age</form:label>
				<form:input path="age" />
				<form:errors path="age" cssClass="erreur"></form:errors>
			</div>
			<div>
				<input type="submit" value="Go !" />
			</div>
		</form:form>

	</div>
</body>
</html>