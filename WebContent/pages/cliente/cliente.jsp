<%@include file="../../_header.jsp" %>

<img class="cliente" src="../../include/forms/vendedor.gif" /><h1 id="title">Clientes</h1>

<p id="text">
	&nbsp;&nbsp;Neste módulo é possível administrar os dados
	dos clientes. Estão disponíveis as opções: incluir,
	excluir, alterar, consultar e listar.
</p>

	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>


<a href="ClienteServlet?comando=antesIncluir" class="option">Inserir</a><br />
<a href="ClienteServlet?comando=antesAlterar" class="option">Alterar</a><br />
<a href="ClienteServlet?comando=antesExcluir" class="option">Excluir</a><br />
<a href="ClienteServlet?comando=consultar" class="option">Consultar</a><br />
<a href="ClienteServlet?comando=listar" class="option">Listar Todos</a><br />

<%@include file="../../_footer.jsp" %>