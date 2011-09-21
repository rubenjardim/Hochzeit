<%@include file="../../_header.jsp" %>

<h1 id="title">${param.tituloPagina}</h1>
<hr/>

<c:if test="${param.mensagem != null}">
	<h2><c:out value="${param.mensagem}" /></h2>
</c:if>

<%@include file="../../_footer.jsp" %>








