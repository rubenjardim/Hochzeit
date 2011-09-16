<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:choose>
	<c:when test="${sessionScope.username == null}">
		<% response.sendRedirect("login.jsp?action=login"); %>
	</c:when>
	<c:otherwise>
		<c:set var="USERNAME" value="${sessionScope.username}" scope="session" />
	</c:otherwise>
</c:choose>

<html>

<head>
	<link rel="stylesheet" href="/GerenciaCliente/include/estilo.css" />
	<title>UNIRIO - Site Trabalho 2</title>
</head>

<body>

<div id="container">
	<img class="logo" src="/GerenciaCliente/include/common/unirioLogo.gif" /> <h1 id="title">Trabalho 2 - Disciplina: PS-SGBD 2010</h1>
<div id="banner">
	<p align="right" id="unirio">Olá, <c:out value="${USERNAME}" /></p>
</div>

<div id="sidebar-a">
	<ul id="menu">
		<li>[<a href="/GerenciaCliente/index.jsp">Principal</a>]</li>
		<hr />
		<li>[<a href="/GerenciaCliente/pages/cliente/cliente.jsp">Clientes</a>]</li>
		<li>[<a href="#">OUTROS</a>]</li>
		<hr />
		<li>[<a href="/GerenciaCliente/logout">Logout</a>]</li>
	</ul>
</div>

<div id="content">

<br />