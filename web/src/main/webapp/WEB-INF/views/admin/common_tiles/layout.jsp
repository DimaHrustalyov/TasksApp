<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<script src="${bootstrap_js}"></script>
	<script src="${bootstrap_min_js}"></script>

	<style>
		html,
		body {
			height: 100%;
		}

		#wrap {
			min-height: 100%;
			height: auto;
			margin: 0 auto -60px;
			padding: 0 0 60px;
		}

		#footer {
			height: 60px;
			background-color: #f5f5f5;
		}

		#wrap > .container {
			padding: 60px 15px 0;
		}

		.container .credit {
			margin: 20px 0;
		}

		#footer > .container {
			padding-left: 15px;
			padding-right: 15px;
		}

		code {
			font-size: 80%;
		}
	</style>
</head>

<body>

<div id="wrap">

	<tiles:insertAttribute name="header"/>

	<div class="container">
		<tiles:insertAttribute name="content"/>
	</div>
</div>


<tiles:insertAttribute name="footer"/>

</body>
</html>

