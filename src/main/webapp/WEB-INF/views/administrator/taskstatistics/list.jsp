<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<h2>
	<acme:message code="administrator.taskstatistics.show.title"/>
</h2>


<acme:list readonly="true">
	<acme:list-column code="administrator.taskstatistics.list.label.numberOfPublicTasks" path="numberOfPublicTasks" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.numberOfPrivateTasks" path="numberOfPrivateTasks" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.numberOfFinishedTasks" path="numberOfFinishedTasks" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.numberOfNonFinishedTasks" path="numberOfNonFinishedTasks" width="20%"/>
	
	<acme:list-column code="administrator.taskstatistics.list.label.avarageWorkloads" path="avarageWorkloads" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.minimumWorkloads" path="minimumWorkloads" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.maximumWorkloads" path="maximumWorkloads" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.deviationWorkload" path="deviationWorkload" width="20%"/>
	
	<acme:list-column code="administrator.taskstatistics.list.label.avarageExecPeriod" path="avarageExecPeriod" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.minimumExecPeriod" path="minimumExecPeriod" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.maximumExecPeriod" path="maximumExecPeriod" width="20%"/>
	<acme:list-column code="administrator.taskstatistics.list.label.deviationExecPeriod" path="deviationExecPeriod" width="20%"/>
</acme:list>