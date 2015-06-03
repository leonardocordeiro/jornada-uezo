<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
						<input type="button" id="cadastrarButton" name="cadastrarButton" class="btn btn-primary btn-lg" value="Cadastrar">
					</div>
				</form>
			