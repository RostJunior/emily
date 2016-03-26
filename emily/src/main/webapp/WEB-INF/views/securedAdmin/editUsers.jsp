<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Emily: EditUser</title>
</head>
<body>

<a href="personalAccount">Admin Panel</a>
<hr/>
<h3>List Users</h3>
<table>
		<thead>
			<tr>
				<th height="35px" width="140px"> ID</th>
				<th height="35px" width="140px">Name</th>
				<th height="35px" width="140px">City</th>
				<th height="35px" width="140px">Adress</th>
				<th height="35px" width="140px">Telephone</th>
				<th height="35px" width="140px">e-Mail</th>
				<th height="35px" width="140px">Roles</th>
				<th height="35px" width="140px">Password</th>
				
			</tr>
		</thead>
		<tbody>
		
			
				<tr>
					<td width="140px" align="center">${user.idUsers} </td>
					<td width="140px" align="center">${user.nameUsers}</td>
					<td width="140px" align="center">${user.cityUsers}</td>
					<td width="140px" align="center">${user.adressUsers}</td>
					<td width="140px" align="center">${user.telephoneNumberUsers}</td>
					<td width="140px" align="center">${user.emailUsers}</td>
					<td width="140px" align="center">${user.roles.roles}</td>
					<td width="140px" align="center">${user.passwordUsers}</td>
					
										
				</tr>
			
		</tbody>
	</table>

<hr/>



<form action="${user.idUsers}" method="POST">
		<h2>edit User</h2>
		<p>
			<p>ID ${user.idUsers}</p>
			Name <input type="text" name="nameUser" value="${user.nameUsers}">
			City <input	type="text" name="cityUser" value="${user.cityUsers}">
			Adress <input	type="text" name="adressUser" value="${user.adressUsers}">
			Telephone <input	type="tel" name="telephoneUser" value="${user.telephoneNumberUsers}">
			e-Mail <input	type="email" name="emailUser" value="${user.emailUsers}">
			Password <input	type="text" name="passwordUser" value="${user.passwordUsers}">
			Role <select name = "idRole">
		   	 <c:forEach items="${allRoles}" var="roles">
		        <option  value="${roles.idRoles}"><c:out value="${roles.roles}" /></option>    
		   	 </c:forEach>
			</select> 
			
			
			<button type="submit">editUser</button>
		</form>


</body>
</html>