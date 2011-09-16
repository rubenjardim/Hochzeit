<%@include file="../../_header.jsp" %>

<h1 id="title">Excluir Cliente</h1>
<hr/>

<form action="ClienteServlet" method="post">
	<input type="hidden" name="comando" value="excluir" />
	<input type="hidden" name="id" value="<c:out value='${cliente.id}' />"/> <br />
	<br />
	
	
	Nome: <c:out value="${cliente.nome}" />
	<br />
	
	Sexo: <c:out value="${cliente.sexo}" />
	<br />
	       
    Cidade: <c:out value="${cliente.cidade.nome}" />
	<br /><br />
	
	<input type="submit" value="Excluir" onclick="return confirm('Confirma a exclusão?')"/>

</form>

<%@include file="../../_footer.jsp" %>




