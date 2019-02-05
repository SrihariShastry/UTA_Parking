<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<input name="errMsg" value="<c:out value='${errorMsgs.errorMsg}'/>" type="text" style ="background-color: white; color: red; border: none; width:800px" disabled="disabled">
<table>
 <tr>
 <td>
 <form name="employeeForm" action="/company_management/EmployeeController" method="post">
 <table>
 <tr>
 <td> Employee ID (*): </td>
 <td>
 <input name="idemployee" value="<c:out value='${employee.idemployee}'/>" type="text" maxlength="16"> 
 	<td> <input name="employeeIDerror" value="<c:out value='${errorMsgs.employeeIDerror}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
 </tr>
 <tr>
 <td> First Name (*): </td>
 <td>
 <input name="name" value="<c:out value='${employee.name}'/>" type="text" maxlength="45"> 
 	<td> <input name="firstNameError" value="<c:out value='${errorMsgs.firstNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
 </tr>
 <tr>
 <td> Last Name (*): </td>
 <td>
 <input name="surname" value="<c:out value='${employee.surname}'/>" type="text" maxlength="45"> 
 	<td> <input name="lastNameError" value="<c:out value='${errorMsgs.lastNameError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
 </tr>
 <tr>
 <td> Company Badge (*): </td>
 <td>
 <input name="badge" value="<c:out value='${employee.badge}'/>" type="text" maxlength="5"> 
 	<td> <input name="companyBadgeError" value="<c:out value='${errorMsgs.companyBadgeError}'/>" type="text" style ="background-color: white; color: red; border: none; width: 800px" disabled="disabled" maxlength="60"> </td>
 </tr>
 <tr>
 <td colspan="2">(*) Mandatory field</td>
 </tr>
 </table>
 <input name="action" value="insertEmployee" type="hidden">
	<input name="insertEmpbutton" type="submit" value="insertEmployee">
	<input name="doneButton" type="submit" value="Done">
				</form>
</td>
</tr>
</table>
</body>
</html>