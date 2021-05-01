<%@page language="java"%>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>



<acme:form>
	<acme:form-textbox code="administrator.spamconfig.blacklist.label.word" path="word"/>
	<acme:form-submit test="${command == 'show' || command == 'update'}" code="administrator.spamconfig.blacklist.label.update" action="/administrator/spamconfig/update"/>
	<acme:form-submit test="${command == 'show' || command == 'update'}" code="administrator.spamconfig.blacklist.label.delete" action="/administrator/spamconfig/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.spamconfig.blacklist.label.create" action="/administrator/spamconfig/create"/>
	<acme:form-return code="administrator.spamconfig.form.button.return"/>
</acme:form>
