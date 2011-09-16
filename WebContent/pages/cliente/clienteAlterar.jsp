<%@include file="../../_header.jsp" %>

<h1 id="title">Alterar Cliente</h1>
<hr/>

<form action="ClienteServlet" method="post">
	<input type="hidden" name="comando" value="alterar" />
	<input type="hidden" name="id" value="<c:out value='${cliente.id}' />"/> <br />
	<input type="hidden" name="nomeCidade" value="<c:out value='${cliente.cidade.nome}' />"/>
	<br />
	
	<c:if test="${mensagem != null}">
		<h2><c:out value="${mensagem}" /></h2>
	</c:if>
	
	Nome: <input type="text" name="nome" value="<c:out value='${cliente.nome}' />"/> <br />
	<br />
	
	Sexo: <input type="radio" name="sexo" value="M" <c:if test="${cliente.sexo == 'M'}"> checked="checked" </c:if> /> Masculino
		  <input type="radio" name="sexo" value="F" <c:if test="${cliente.sexo == 'F'}"> checked="checked" </c:if> /> Feminino  <br />
	<br />
	
	       
    Cidade: <select name="cidade" width="20">
              <c:forEach var="item" items="${listaCidades}">
                <option  value="<c:out value='${item.codCidade}'/>"  <c:if test="${cliente.cidade.codCidade == item.codCidade}"> selected="selected" </c:if> >
                  <c:out value="${item.nome}" />
                </option>
              </c:forEach>
            </select>
	<br /><br />
	
	
	
	
	<input type="submit" value="Alterar" />
</form>

<%@include file="../../_footer.jsp" %>




