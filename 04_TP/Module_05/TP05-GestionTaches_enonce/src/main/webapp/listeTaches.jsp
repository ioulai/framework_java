<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="js/commun.js"></script>
<link rel="stylesheet" href="css/commun.css">

<style type="text/css">
.centre {
	text-align: center;
}

img {
	vertical-align: bottom;
}
</style>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
		        <a  href="index.jsp" class="navbar-brand active">
		        <span class="glyphicon glyphicon-tasks"></span> 
		        <span class="glyphicon glyphicon-tasks"></span> 
		        </a>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.jsp">Accueil</a></li>
					<li class="active"><a href="listerTache">Taches</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>		
	<div class="container">
		<h1 class="bleu">Gestion des taches</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th>id</th>
				<th>Libelle </th>
				<th>Importance </th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${listeT}" var="t" varStatus="bStatus">
				<form action="modifTache" method="Post">
					<tr>
						<input type="hidden" name="id" value="${t.id}" />
						<td>${t.id}</td>
						<td><input type="text" name="libelle" value="${t.libelle}" /></td>
						<td><input type="text" name="importance" value="${t.importance}" /></td>
						<td class="centre">
							<button type="submit" class="glyphicon glyphicon-edit vert"></button>

						</td>
						<td class="centre">
							<a href="supprimerTache?index=${t.id}">
								<span class="glyphicon glyphicon-remove rouge"></span>
							</a>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br><br><br>
		<h2 class="bleu">Nouvelle tache :</h2>
		<div>
			<form action="ajouterTache" method="POST" class="form-horizontal" >
				<div class="form-group">
					<div class="col-xs-7">
						<input name="libelle" placeholder="Libellé de la tache ..."
							class="form-control"  />
					</div>
					<div class="col-xs-3">
						<input name="importance" placeholder="Importance [1..10] ..."
							class="form-control"  />
					</div>
					<div class="col-xs-2">
						<button type="submit" class="btn btn-primary pull-right">Envoyer</button>			
					</div>
				</div>
				
			</form>
		</div>

	</div>
	<jsp:include page="footer.jsp" />

</body>
</html>