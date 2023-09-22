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
		<div id="main">
			<h1>詳細画面</h1>
			<form action="update" method="post">
			<c:forEach var="customer" items="${customerList}">
					<label for="email">Email</label>
					<input type="text" id="email=" name="email" value ="${customer.email}">
					<label for="password">Passowrd</label>
					<input type="text" id="password" name="password" value ="${customer.password}">
					<label for="name">氏名</label>
					<input type="text" id="name=" name="name" value="${customer.name}">
					<label for="gender">性別</label>
					<c:if test="${customer.gender == 0}">
						<input type="radio" name="gender" value="0" checked=checked>男
						<input type="radio" name="gender" value="1">女
					</c:if>
					<c:if test="${customer.gender == 1}">
						<input type="radio" name="gender" value="0">男
						<input type="radio" name="gender" value="1" checked=checked>女
					</c:if>
					<label for="blood">血液型</label>
					<select name="blood">
						<option value="${customer.blood}">${customer.blood}型</option>
						<option value="A">A型</option>
						<option value="B">B型</option>
						<option value="O">O型</option>
						<option value="AB">AB型</option>
					</select>
					<label for="memo">メモ</label>
					<textarea name="memo" rows="4" cols="41" maxlength="100">${customer.memo}</textarea>
					<input type="hidden" name="id" value="${customer.id}">
					<input type="submit" value="更新">
					</c:forEach>
			</form>
			<form action="delete" method="post">
				<c:forEach var="customer" items="${customerList}">
					<input type="hidden" name="id" value="${customer.id}">
					<input type="submit" value="削除">
				</c:forEach>
			</form>
		</div>
	</body>
</html>