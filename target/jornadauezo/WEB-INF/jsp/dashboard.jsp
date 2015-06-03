<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<! DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"></meta>
	<title>Jornada de Ciência e Tecnologia | UEZO</title>
	<link rel="stylesheet" href="resources/css/bootstrap.min.css" />
	<link rel="stylesheet" href="resources/css/base-style.css" />
</head>

<body>
	<div class="jumbotron">
		<div class="container">
			<h2>IV Jornada de Ciência e Tecnologia</h2>
			<p>Sistema de inscrição</p>
		</div>
	</div>
	<nav class="navbar navbar-default" role="navigation">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Home</a>
		</div>
		<div>
		  	<ul class="nav navbar-nav">
		    	<li><a href="cadastro.html">Cadastro</a></li>
		    	<li><a href="index.html">Meu carrinho</a></li>
		    	<li><a href="index.html">${sessionScope.usuarioLogado.email}</a></li>
		   	</ul>
		</div>
	</nav>
	<div class="container">
		
	</div>
</body>
</html>