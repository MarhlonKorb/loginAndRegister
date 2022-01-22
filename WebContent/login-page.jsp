<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login-page</title>
</head>
<body>
	<header>
		<h1 align="center"> Login </h1>
		<tr>
		<td>${mensagem}</td>
		</tr>
			<form action="loginServlet" method="post">
					<p style="font-size:17px;height: 22px;"><label>Email </label><input type="text" name="email" required="required field"></p>
						<p style="font-size:17px;">Senha <input type="password" name="senha" required="required field"></p>
					<button name="enter" type="submit" style="border-radius: 5px; position: relative;	align-self: center;">
					Entrar
				</button>
			</form>
	</header>
</body>
</html>