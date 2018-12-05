<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="css/commun.css">
	<script src="js/commun.js"></script>
	

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
					<li class="active"><a href="#">Accueil</a></li>
					<li><a href="lister">Liste des bouteilles</a></li>
					<li><a href="ajouter">Ajouter une bouteille</a></li>
					<li><a href="geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>		
	
	<div class="container">
		<div class="jumbotron">
	 			 <h1>Bienvenue <small>dans notre application de cave à vin</small></h1>
	 			 <p>Vous allez pouvoir visualiser vos plus merveilleuses bouteilles, mais aussi ajouter, modifier ou supprimer ces excellents breuvages.</p>
	 			 <p>Expérience enrichissante garantie.</p>
	 			 <p><a class="btn btn-primary btn-lg" role="button" href="geo.jsp">En savoir plus ...</a></p>
		</div>
	</div>
	
	<jsp:include page="footer.jsp" />	


</body>
</html>