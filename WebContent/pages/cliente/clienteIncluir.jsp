<%@include file="../../_header.jsp"%>
<script>

	function validaFormulario(){
		with (document.forms[0]) {
			if(nome.value == '')
				alert('Preencha os campos obrigatórios!')
			else
				submit();
		}
		
	}

</script>
<h1 id="title">Inserir Cliente</h1>
<hr />

<form action="ClienteServlet" method="post"><input type="hidden"
	name="comando" value="incluir" /> <!-- Id: <input type="text" name="id" /> <br />  -->
* Nome: <input type="text" name="nome" /> <br />
<br />

* Sexo: <input type="radio" name="sexo" value="M" /> Masculino <input
	type="radio" name="sexo" value="F" /> Feminino<br />
<br />


* Cidade: <select name="cidade" width="20">
	<c:forEach var="item" items="${listaCidades}">
		<option value="<c:out value='${item.codCidade}'/>"><c:out
			value="${item.nome}"/></option>
	</c:forEach>
</select> <br />
<br />
<font size="1"><i>* campos obrigatórios</i></font> <br />
<br />
<input type="button" value="Inserir" onclick="validaFormulario()" /> <br />


</form>

<%@include file="../../_footer.jsp"%>








