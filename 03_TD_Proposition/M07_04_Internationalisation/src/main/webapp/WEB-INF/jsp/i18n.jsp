<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Internationalisation</h1>
	<h2>
		<spring:message code="index.bonjour" />
	</h2>
	<p>
		<spring:message code="index.bienvenue" />
	</p>
	<p>
		<spring:message code="hello" arguments="${prenom};${nom}" htmlEscape="true" argumentSeparator=";" />
	</p>
</body>
</html>