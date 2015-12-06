<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags" %>

<div class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<sf:url value="/admin/home"/>"><span class="glyphicon glyphicon-user"></span>
				- [<%=request.getUserPrincipal().getName()%>]</a>
		</div>
		<div class="collapse navbar-collapse pull-right">
			<ul class="nav navbar-nav">
				<li><a href="<sf:url value="/admin/news/list"/>">News</a></li>
				<li><a href="<sf:url value="/static/j_spring_security_check"/>"><span
						class="glyphicon glyphicon-log-out"></span> Log out</a></li>
			</ul>
		</div>

	</div>
</div>

