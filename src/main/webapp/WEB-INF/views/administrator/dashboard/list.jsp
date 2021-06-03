<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<h2>
	<acme:message code="administrator.taskstatistics.show.title"/>
</h2>

<h3>
	<acme:message code="administrator.taskstatistics.show.tasksdashboard"/>
</h3>
<h5><acme:message code="administrator.taskstatistics.list.label.numberOfPublicTasks"/></h5>
<acme:print value="${numberOfPublicTasks}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.numberOfPrivateTasks"/></h5>
<acme:print value="${numberOfPrivateTasks}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.numberOfFinishedTasks"/></h5>
<acme:print value="${numberOfFinishedTasks}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.numberOfNonFinishedTasks"/></h5>
<acme:print value="${numberOfNonFinishedTasks}"/>
<br><br><br><br>

<h3>
	<acme:message code="administrator.taskstatistics.show.workloaddashboard"/>
</h3>
<h5><acme:message code="administrator.taskstatistics.list.label.avarageWorkloads"/></h5>
<acme:print value="${avarageWorkloads}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.minimumWorkloads"/></h5>
<acme:print value="${minimumWorkloads}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.maximumWorkloads"/></h5>
<acme:print value="${maximumWorkloads}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.deviationWorkload"/></h5>
<acme:print value="${deviationWorkload}"/>
<br><br><br><br>

<h3>
	<acme:message code="administrator.taskstatistics.show.excperioddashboard"/>
</h3>
<h5><acme:message code="administrator.taskstatistics.list.label.avarageExecPeriod"/></h5>
<acme:print value="${avarageExecPeriod}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.minimumExecPeriod"/></h5>
<acme:print value="${minimumExecPeriod}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.maximumExecPeriod"/></h5>
<acme:print value="${maximumExecPeriod}"/>
<br><br>
<h5><acme:message code="administrator.taskstatistics.list.label.deviationExecPeriod"/></h5>
<acme:print value="${deviationExecPeriod}"/>
<br><br><br><br>