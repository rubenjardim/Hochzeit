<%@include file="../../_header.jsp" %>

<h1 id="title">Consultar Cliente</h1>
<hr/>

<form action="ClienteServlet" method="post">
	<input type="hidden" name="comando" value="<c:out value='${comando}' />" />
	Id: <input type="text" name="id" /> <br />
	<br />
	
	<input type="submit" value="Consultar" />
	
</form>

<%@include file="../../_footer.jsp" %>









