<%@include file="../../_header.jsp" %>


<h1 id="title">Listagem de Clientes</h1>
<hr/>


<c:forEach items="${listaClientes}" var="cliente">
	Nome: <c:out value="${cliente.nome}" /> <br/>
	Cidade: <c:out value="${cliente.cidade.nome}" /> <br/>
	Sexo: <c:out value="${cliente.sexoFormatado}" /> <br/><br/>
</c:forEach>

<%@include file="../../_footer.jsp" %>




