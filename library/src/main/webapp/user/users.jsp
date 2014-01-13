<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<s:if test="userList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
			<th>Customer Id</th>
			<th>Name</th>
			<th>Surname</th>
			<th>Email</th>
			<th>Created Date</th>
			<th>Is Administrator</th>
		</tr>
		<s:iterator value="userList" status="userStatus">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="name" /></td>
				<td><s:property value="surname" /></td>
				<td><s:property value="email" /></td>
				<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				<td><s:property value="admin"/></td>
			</tr>
		</s:iterator>
	</table>
</s:if>

<s:include value="../footer.jsp" />
