<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<h3><acme:message code="administrator.taskstatistics.show.title"/></h3>
<acme:form readonly="true">
	<acme:form-textbox code="administrator.taskstatistics.show.label.numberOfPublicTasks" path="numberOfPublicTasks"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.numberOfPrivateTasks" path="numberOfPrivateTasks"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.numberOfFinishedTasks" path="numberOfFinishedTasks"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.numberOfNonFinishedTasks" path="numberOfNonFinishedTasks"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.avarageWorkloads" path="avarageWorkloads"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.minimumWorkloads" path="minimumWorkloads"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.maximumWorkloads" path="maximumWorkloads"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.deviationWorkload" path="deviationWorkload"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.avarageExecPeriod" path="avarageExecPeriod"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.minimumExecPeriod" path="minimumExecPeriod"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.maximumExecPeriod" path="maximumExecPeriod"/>
	<acme:form-textbox code="administrator.taskstatistics.show.label.deviationExecPeriod" path="deviationExecPeriod"/>
</acme:form>
