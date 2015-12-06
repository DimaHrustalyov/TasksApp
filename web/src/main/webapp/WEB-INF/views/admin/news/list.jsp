<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>News: List</title>

<div class="page-header">
	<h4 class="text-info">News:</h4>
</div>


<c:if test="${empty newsForm.newsList}">
	<sf:url value="/admin/news/add" var="add"/>
	<p class="lead">No News! Please add new News.
		<a class="pull-right" href="${add}">
			New
		</a>
	</p>
</c:if>

<c:if test="${not empty newsForm.newsList}">
	<p class="lead">List of News:
		<sf:url value="/admin/news/add" var="add"/>
		<a class="pull-right" href="${add}">
			New
		</a>
	</p>
	<table class="table table-striped table-bordered table-condensed table-hover">
		<tr class="text-info">
			<th>Title</th>
			<th>Brief</th>
			<th>Description</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${newsForm.newsList}" var="news">
			<tr>
				<td>
						${news.title}
				</td>
				<td>
						${news.brief}
				</td>
				<td>
						${news.description}
				</td>
				<td class="text-center">
					<sf:url value="/admin/news/edit" var="edit">
						<sf:param name="id" value="${news.id}"/>
					</sf:url>
					<a href="${edit}">
						Edit
					</a>
				</td>
				<td class="text-center">
					<sf:url value="/admin/news/delete" var="delete">
						<sf:param name="id" value="${news.id}"/>
					</sf:url>
					<a href="${delete}">
						Delete
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	<p class="lead">

		<sf:url value="/admin/news/json" var="json"/>
		<a class="pull-right" href="${json}">
			Generate JSON
		</a>
	</p>

</c:if>



