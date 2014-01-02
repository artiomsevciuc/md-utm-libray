<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<h2>Register user</h2>
<s:form action="createUserAction">
	<s:textfield name="name" label="Name" value="" />
	<s:textfield name="surname" label="Surname" value="" />
	<s:textfield name="email" label="email" value="" />
	<s:password name="password" label="Password" value="" />
	<s:submit />
</s:form>

<s:include value="../footer.jsp" />