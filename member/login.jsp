<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ログイン画面</title>

<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="main">
			<h1>ログイン画面</h1>
			<form action="login" method="post">
				<div class="field">
					<label for="email">Email</label>
					<input type="text" id="email" name="email">
				</div>
				<div class="field">
					<label for="Password">password</label>
					<input type="text" id="password" name="password">
				</div>
				<div>
					<input type="submit">
				</div>
			</form>
		</div>
	</body>
</html>