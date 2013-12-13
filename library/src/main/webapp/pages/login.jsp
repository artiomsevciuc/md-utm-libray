<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp"/>


	<s:form action="loginauth" theme="simple">
		<center>
			<table width="200">
				<tr height="30">
					<td width="200" colspan="2"><s:if test="hasActionErrors()">
							<div class="errors">
								<s:actionerror  />
							</div>
						</s:if></td>
				</tr>
				<tr>
					<td colspan="2" width="200" align="left" style="background: #eee">Login
						Here</td>
				</tr>
				<tr>
					<td align="left">User ID:</td>
					<td align="left"><s:textfield name="userId" /></td>
				</tr>
				<tr>
					<td align="left">Password:</td>
					<td align="left"><s:password type="text" name="password" /></td>
				</tr>
				<tr>
					<td align="left"></td>
					<td align="left"><input type="submit" name="login"
						value="Login"></td>
				</tr>
			</table>
		</center>
	</s:form>
	
<s:include value="../footer.jsp"/>