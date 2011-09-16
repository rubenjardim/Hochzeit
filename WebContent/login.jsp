<html>

<head>
	<link rel="stylesheet" href="include/estilo.css" />
	<title>Trabalho 2 (PS-SGBD 2010)</title>
</head>

<body>

<p>
	<img src="include/common/unirio.gif" width="300" height="300" />
</p>

<form action="login" method="post">
	Usu&aacute;rio: <input type="text" name="username" size="20" /><br/>
	Senha: <input type="password" name="password" size="20" /><br/>

	<br/>

	<input type="submit" value="Entrar"/>
</form>

<%
	String erro = request.getParameter("action");

	if (erro != null)
	{
		if (erro.equals("login"))
			out.print("<font color=white>Área restrita. Entre com usu&aacute;rio e senha</font>");
	}
%>

</body>
</html>







