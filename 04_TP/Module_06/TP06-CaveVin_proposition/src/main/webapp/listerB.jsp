<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
		        <a  href="index.jsp" class="navbar-brand active"><img class="bottle" src="img/Bottle32x32.png"/><img class="bottle" src="img/Bottle32x32.png"/> </a>
		         <span id="dh"></span>
		          <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		    </div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li ><a href="index.jsp">Accueil</a></li>
					<li class="active"><a href="#">Liste des bouteilles</a></li>
					<li><a href="ajouter">Ajouter une bouteille</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	<div class="container">
	<h1 class="bleu">Liste des bouteilles<span class="badge btn-primary gros pull-right">${ fn:length(listeB)}</span></h1>
	<br>
	<form action="lister" method="GET" class="form-horizontal">
		<div class="form-group" id="blocFiltre">			
			<label id="labelFiltre" for="filtre" class="col-xs-2 control-label">Filtre :</label>
			<div class="col-xs-10">
				<div class="input-group">
			      <input name="filtre"  placeholder="Filtre sur le nom du vin ..."  class="form-control" /> 
			      <span class="input-group-btn">
			        <button class="btn btn-info" type="submit">Envoyer</button>
			      </span>
			    </div><!-- /input-group -->
			    
			</div>
		</div>
	</form>
	<br>
	<table class="table table-hover table-striped">
		<tr>
			<th><a href="trier?par=dA"><span class="glyphicon glyphicon-menu-down"></span></a> Nom <a
				href="trier?par=dD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=mA"><span class="glyphicon glyphicon-menu-down"></span></a> Millesime <a
				href="trier?par=mD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=cA"><span class="glyphicon glyphicon-menu-down"></span></a> Petillant <a
				href="trier?par=cD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=nA"><span class="glyphicon glyphicon-menu-down"></span></a> Quantite <a
				href="trier?par=nD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=coA"><span class="glyphicon glyphicon-menu-down"></span></a> Couleur <a
				href="trier?par=coD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=rA"><span class="glyphicon glyphicon-menu-down"></span></a> Region <a
				href="trier?par=rD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th></th>
			<th></th>
		</tr>
	
		<c:forEach items="${listeB}" var="b" varStatus="bStatus">
			<tr>
				<td><a href="afficher?index=${b.id}">${b.nom}</a></td>
				<td>${b.millesime}</td>
<%-- 				<td><c:if test="${b.petillant}">Oui</c:if><c:if test="${!b.petillant}">Non</c:if></td> --%>
				<td>${b.petillant?"Oui":"Non"}</td>
				<td>${b.quantite}</td>
				<td>${b.couleur.nom}</td>
				<td>${b.region.nom}</td>
				<td class="centre">
					<span class="modif glyphicon glyphicon-edit vert"  id="m${b.id}"></span>
				</td>
				<td class="centre">
					<span class="glyphicon glyphicon-remove rouge supp"  id="s${b.id}"></span>
				</td>
			</tr>
		</c:forEach>
		

	</table>


	</div>
	<jsp:include page="footer.jsp" />	

</body>
</html>