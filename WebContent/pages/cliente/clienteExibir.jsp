<%@include file="../../_header.jsp" %>

<h1 id="title">Detalhes do Cliente</h1>
<hr/>

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	
	Nome: <c:out value="${cliente.nome}" />
	<br />
	
	Sexo: <c:out value="${cliente.sexo}" />
	<br />
	       
    Cidade: <c:out value="${cliente.cidade.nome}" />
	<br />
	

<%@include file="../../_footer.jsp" %>








