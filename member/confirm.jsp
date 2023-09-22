<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>マイページ</title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
	<h1>確認画面</h1>
		<form action="confirm" method="post">
			<p>Email:${customer.email}</p>
			<p>Password:${customer.password}</p>
			<p>氏名:${customer.name}</p>
			<p>年齢:${customer.old}</p>
			<c:if test="${customer.gender == 0}">
				<p>性別:男</p>
			</c:if>
			<c:if test="${customer.gender == 1}">
				<p>性別:女</p>
			</c:if>
			<p>血液型:${customer.blood}</p>
			<p>メモ:${customer.memo}</p>
			<input type="hidden" id="email=" name="email" value="${customer.email}" >
			<input type="hidden" id="password" name="password" value="${customer.password}">
			<input type="hidden"  id="name" name="name" value="${customer.name}">
			<input type="hidden"  id="gender" name="gender" value="${customer.gender}">
			<input type="hidden"  id="blood=" name="blood"value="${customer.blood}">
			<input type="hidden"  id="old" name="old" value="${customer.old}">
			<input type="hidden"  id="memo" name="memo" value="${customer.memo}">
			<input type="submit" value="登録">
		</form>
		<form action="insert" method="get">
				<input type="hidden" id="email=" name="email" value="${customer.email}">
				<input type="hidden" id="password" name="password" value="${customer.password}">
				<input type="hidden"  id="name" name="name" value="${customer.name}">
				<input type="hidden"  id="gender" name="gender" value="${customer.gender}">
				<input type="hidden"  id="blood=" name="blood"value="${customer.blood}">
				<input type="hidden"  id="old" name="old" value="${customer.old}">
				<input type="hidden"  id="memo" name="memo" value="${customer.memo}">
			<input type="submit" value="修正">
		</form>
	</body>
</html>