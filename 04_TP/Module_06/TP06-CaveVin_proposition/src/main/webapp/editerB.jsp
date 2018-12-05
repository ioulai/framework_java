    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="lister">Liste des bouteilles</a></li>
					<li><a href="ajouter">Ajouter une bouteille</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>	
	
<div class="container">	
	<h1 class="bleu">Edition de la fiche du vin</h1>
	<br><br>
		<div>
	<form action="editer" method="POST" class="form-horizontal">
				<div class="form-group">			
					<label for="id" class="col-xs-2 control-label">Id :</label>
					<div class="col-xs-10">
						<input name="id" readonly="readonly"  class="form-control" value="${bout.id}"/> 
					</div>
				</div>
				<div class="form-group">			
					<label for="nom" class="col-xs-2 control-label">Nom :</label>
					<div class="col-xs-10">
						<input name="nom"  placeholder="Nom du vin ..."  class="form-control"  value="${bout.nom}"/> 
					</div>
				</div>
				<div class="form-group">			
					<label for="millesime" class="col-xs-2 control-label">Millesime :</label>
					<div class="col-xs-10">
						<input name="millesime"  placeholder="Millesime du vin ..."  class="form-control"  value="${bout.millesime}"/> 
					</div>
				</div>
				<div class="form-group">			
					<label for="petillant" class="col-xs-2 control-label">Pétillant :</label>
					<div class="col-xs-10">
						<select name="petillant" class="form-control">
							<option value="true" <c:if test="${bout.petillant}">selected</c:if>>Oui</option>
							<option value="false" <c:if test="${!bout.petillant}">selected</c:if>>Non</option>
						</select>					
					</div>
				</div>

				<div class="form-group">			
					<label for="quantite" class="col-xs-2 control-label">Quantité :</label>
					<div class="col-xs-10">
						<input name="quantite"  placeholder="Quantité de bouteilles ..."  class="form-control"  value="${bout.quantite}"/> 
					</div>
				</div>
				<div class="form-group">			
					<label for="couleurId" class="col-xs-2 control-label">Couleur :</label>
					<div class="col-xs-10">
						<select name="couleurId" class="form-control">
							<c:forEach items="${listeCoul}" var="coul">
								<option value="${coul.id }" <c:if test="${coul.id == bout.couleur.id}">selected</c:if>>${coul.nom }</option>
							</c:forEach>							
						</select>					
					</div>
				</div>

				<div class="form-group">			
					<label for="regionId" class="col-xs-2 control-label">Région :</label>
					<div class="col-xs-10">
					
					
					
						<select name="regionId" class="form-control">
							<c:forEach items="${listeRegion}" var="reg">
								<option value="${reg.id }" <c:if test="${reg.id == bout.region.id}">selected</c:if>>${reg.nom }</option>
							</c:forEach>							
						</select>					
					</div>
				</div>
				<div class="form-group" >
					<div class="col-xs-offset-2 col-xs-10">
						<button type="submit" class="btn btn-primary">Modifier</button>			
					</div>
				</div>	

	
			
	</form>
	</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>