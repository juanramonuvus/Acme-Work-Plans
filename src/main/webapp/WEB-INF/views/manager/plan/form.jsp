<%--
- form.jsp
-
- Copyright (C) 2012-2021 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<acme:form readonly="true">
	<acme:form-textbox code="manager.plan.form.label.id" path="id"/>
	<acme:form-textbox code="manager.plan.form.label.executionStart" path="executionStart"/>	
	<acme:form-textbox code="manager.plan.form.label.executionEnd" path="executionEnd"/>
	<acme:form-textbox code="manager.plan.form.label.isPublic" path="isPublic"/>
	<acme:form-textbox code="manager.plan.form.label.manager" path="manager.userAccount.username"/>
	
	<h5><spring:message code="manager.plan.form.label.tasks"/></h5>
	<table id="list" class="table table-striped table-condensed table-hover nowrap w-100">
	    <thead>
	    	<tr>
			    <th>
			    	<spring:message code="manager.plan.form.label.title"/>
			    </th>
			     <th>
			    	<spring:message code="manager.plan.form.label.executionStart"/>
			    </th>
			     <th>
			    	<spring:message code="manager.plan.form.label.executionEnd"/>
			    </th>
	    	</tr>
	    </thead>
	    <tbody>
		    <c:forEach items="${tasks}" var="task">
		        <tr>
			        <td>
			        	<c:out value="${task.title}"/>
			        </td>
			        <td>
			        	<c:out value="${task.executionStart}"/>
			        </td>
			        <td>
			        	<c:out value="${task.executionEnd}"/>
			        </td>
		        </tr>
		    </c:forEach>
	    </tbody>
	</table>

	<acme:form-return code="manager.plan.form.label.return"/>
</acme:form>