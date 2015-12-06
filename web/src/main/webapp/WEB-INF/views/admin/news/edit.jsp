<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="stags" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form" %>
<title>News: Add/Edit</title>

<div class="page-header">
	<h4 class="text-info">News:</h4>
</div>

<p class="lead">Add/Edit new News.</p>

<stags:url value="/admin/news/save" var="save"/>
<sform:form method="POST" action="${save}" commandName="news" class="form-horizontal" role="form">
	<input name="id" type="hidden" value="${news.id}">

	<div class="form-group">
		<label for="inputTitle" class="col-sm-3 control-label">Title</label>

		<div class="col-sm-6">
			<input name="title" type="text" class="form-control" id="inputTitle" placeholder="title"
				   required="required"
				   value="${news.title}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputBrief" class="col-sm-3 control-label">Brief</label>

		<div class="col-sm-6">
			<input name="brief" type="text" class="form-control" id="inputBrief" placeholder="brief"
				   required="required"
				   value="${news.brief}">
		</div>
	</div>
	<div class="form-group">
		<label for="inputDescription" class="col-sm-3 control-label">Description</label>

		<div class="col-sm-6">
			<input name="description" type="text" class="form-control" id="inputDescription" placeholder="description"
				   required="required"
				   value="${news.description}">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-6">
			<button type="submit" class="btn btn-info pull-right">Save</button>
		</div>
	</div>


	<ul class="pager">
		<stags:url value="/admin/news/list" var="list"/>
		<li class="previous btn-default">
			<a href="${list}">Back</a>
		</li>
	</ul>

</sform:form>



