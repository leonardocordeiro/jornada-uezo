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

	<div class="container">
		<fieldset>
			<legend>Cadastro</legend>
		</fieldset>
		<div class="col-sm-4">
			<div class="col-sm-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<p class="panel-title">VIII Jornada de Ciência e Tecnologia</p>
					</div>
					
					<div class="panel-body">
						Seja bem vindo ao portal de inscrição a VIII Jornada de Ciência e Tecnologia da UEZO.
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-8">
			<div class="col-md-6">
				<form id="cadastro" action="usuario" method="post">
					<div class="form-group ${hasErrorInnome}">
						<label for="nome">Nome: <font color="red">*</font></label><br />
						<input name="nome" type="text" class="form-control" />	
						<spring:errors path="usuario.nome" cssStyle="color: red" />					
					</div>
					<div class="form-group ${hasErrorInsobrenome}">
						<label for="nome">Sobrenome: <font color="red">*</font></label><br />
						<input name="sobrenome" type="text" class="form-control" />	
						<spring:errors path="usuario.sobrenome" cssStyle="color: red" />					
					</div>
					<div class="form-group ${hasErrorInemail}">
						<label for="email">Email: <font color="red">*</font></label><br />
						<input name="email" type="text" class="form-control" />	
						<spring:errors path="usuario.email" cssStyle="color: red" />					
					</div>
					<div class="form-group ${hasErrorInsenha}">
						<label for="senha">Senha: <font color="red">*</font></label><br />
						<input name="senha" type="password" class="form-control" />	
						<spring:errors path="usuario.senha"  cssStyle="color: red" />				
					</div>
					<div class="form-group ${hasErrorInMatricula}">
						<label for="matricula">Matricula:</label><br />
						<input name="matricula" type="text" class="form-control" placeholder="Caso seja aluno, preencha aqui sua matrícula"/>	
						<c:if test="${matriculaInvalida}">
								<div><font color="red">A matrícula inserida é inválida!</font></div>
						</c:if>				
					</div>
					<br>
					<div class="form-group">
						<button name="cadastrarButton" class="btn btn-primary btn-lg">Cadastrar</button>
					</div>
				</form>
			</div>
			<br />
		<div class="col-sm-6">
		
			<form action="oauth" method="post">
				<div class="jumbotron">
					<div class="form-group">
						<label for="matricula">Entrar com:</label>
						<input type="hidden" name="s" value="FACEBOOK"> 
						<a href="#"><input type="submit" class="btn btn-primary form-control" value="Facebook"></a>
					</div>
				</div>
			</form>
		</div>
		<div class="col-sm-6">
		<fieldset>
			<legend>Ou entre com seu e-mail :)</legend>
		</fieldset>
		<form action="login">
			<div class="jumbotron">
				<div class="form-group">
					<label for="matricula">E-mail:</label>
					<input name="email" type="text" class="form-control" />		
				</div>
				<div class="form-group">
					<label for="curso">Senha:</label>
					<input name="senha" type="password" class="form-control" />				
				</div>
				<div class="form-group">
					<button class="btn btn-success">Login</button>
									
				</div>
			</div>
		</form>
		</div>
		</div>
		
	</div>
</body>
</html>