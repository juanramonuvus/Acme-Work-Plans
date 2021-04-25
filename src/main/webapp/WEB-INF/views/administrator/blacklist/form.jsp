<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:form>
	<acme:form-textbox code="administrator.spamconfig.blacklist.label.word" path="word"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.spamconfig.blacklist.laberl.delete" action="/administrator/spamconfig/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.spamconfig.blacklist.label.create" action="/administrator/spamconfig/create"/>
</acme:form>