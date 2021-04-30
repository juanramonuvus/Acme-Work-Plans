<%@page language="java"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<c:if test="${command == 'show'}">
	<acme:form readonly="true">
		<acme:form-textbox code="administrator.spamconfig.blacklist.label.word" path="word"/>
		<acme:form-submit test="${command == 'show'}" code="administrator.spamconfig.blacklist.label.delete" action="/administrator/spamconfig/delete"/>
		<acme:form-return code="administrator.spamconfig.form.button.return"/>
	</acme:form>
</c:if>
<c:if test="${command == 'create'}">
	<acme:form>
		<acme:form-textbox code="administrator.spamconfig.blacklist.label.word" path="word"/>
		<acme:form-submit test="${command == 'create'}" code="administrator.spamconfig.blacklist.label.create" action="/administrator/spamconfig/create"/>
		<acme:form-return code="administrator.spamconfig.form.button.return"/>
	</acme:form>
</c:if>