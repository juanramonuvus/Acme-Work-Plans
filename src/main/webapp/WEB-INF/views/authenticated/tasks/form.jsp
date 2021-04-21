<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>
 
<acme:form>
	<acme:form-textbox code="authenticated.task.list.label.title" path="title"/>
	<acme:form-moment code="authenticated.task.list.label.executionStart" path="executionStart"/>
	<acme:form-moment code="authenticated.task.list.label.executionEnd" path="executionEnd"/>	
	<acme:form-double code="authenticated.task.list.label.workload" path="workload"/>
	<acme:form-textarea code="authenticated.task.list.label.description" path="description"/>
	<acme:form-url code="authenticated.task.list.label.link" path="link"/>
	
	<acme:form-return code="authenticated.task.form.button.return"/>	
</acme:form>
