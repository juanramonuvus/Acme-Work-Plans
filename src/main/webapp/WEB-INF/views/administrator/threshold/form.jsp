<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="administrator.spamconfig.threshold.label" path="threshold"/>
	<acme:form-submit code="administrator.spamconfig.threshold.label.update" action="/administrator/threshold/update"/>
</acme:form>