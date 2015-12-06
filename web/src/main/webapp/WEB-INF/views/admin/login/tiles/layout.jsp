<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>

	<sf:url value="/static/css/bootstrap.css" var="bootstrap"/>
	<sf:url value="/static/css/bootstrap.min.css" var="bootstrap_min"/>
	<sf:url value="/static/css/bootstrap-theme.css" var="bootstrap_theme"/>
	<sf:url value="/static/css/bootstrap-theme.min.css" var="bootstrap_theme_min"/>

	<sf:url value="/static/js/bootstrap.js" var="bootstrap_js"/>
	<sf:url value="/static/js/bootstrap.min.js" var="bootstrap_min_js"/>

	<link rel="stylesheet" type="text/css" href="${bootstrap}"/>
	<link rel="stylesheet" type="text/css" href="${bootstrap_min}"/>
	<link rel="stylesheet" type="text/css" href="${bootstrap_theme}"/>
	<link rel="stylesheet" type="text/css" href="${bootstrap_theme_min}"/>

	<style type="text/css">body {
		padding-top: 40px;
		padding-bottom: 40px;
		background-color: #f5f5f5;
	}

	.form-signin {
		max-width: 300px;
		padding: 19px 29px 29px;
		margin: 0 auto 20px;
		background-color: #fff;
		border: 1px solid #e5e5e5;
		-webkit-border-radius: 5px;
		-moz-border-radius: 5px;
		border-radius: 5px;
		-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
		-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
		box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	}

	.form-signin .form-signin-heading, .form-signin .checkbox {
		margin-bottom: 10px;
	}

	.form-signin input[type="text"], .form-signin input[type="password"] {
		font-size: 16px;
		height: auto;
		margin-bottom: 15px;
		padding: 7px 9px;
	}</style>

</head>

<body>

<div class="container">

	<sf:url var="authUrl" value="/static/j_spring_security_check"/>
	<form class="form-signin" action="${authUrl}" method="post">
		<h4 class="form-signin-heading">Please sign in:</h4>
		<hr>

		<input type="text" class="form-control" placeholder="login" name="j_username" required="required"
			   autofocus="">
		<input type="password" class="form-control" placeholder="password" name="j_password" required="required">

		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
	</form>

</div>

</body>
</html>