<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- Add custom CSS here -->
	<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
     <link href="<c:url value="/resources/css/ekko-lightbox.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/flexslider.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
	
<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">

<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.maskedinput.js'/>"></script>
	
	
<title>Emily: Users</title>
</head>
<body class="adminBody">
<div class="PageAdmin">
<div class="main-navLogin1 clearfix1">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="${pageContext.request.contextPath}/index">EMILY</a>
        </div>
        
        <div class="login loginAdmin" >
        	<p>
        	<sec:authorize access="hasRole('User') or hasRole('Admin')">
        	<p>Привіт <sec:authentication property="name"/></p>
			
			</sec:authorize>
		
			</p>
			
        </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
         <ul class="nav navbar-nav navbar-right">
           
            <li class="current"><a href="#about" class="linear">Користувачі</a></li>
            <li><a href="${pageContext.request.contextPath}/personalAccount" class="linear">Адміністрування</a></li>
            <li><a href="${pageContext.request.contextPath}/index" class="linear">Головна сторінка</a></li>
             <li><a href="${pageContext.request.contextPath}/logout" class="linear">Вихід</a></li>
            </ul>
        
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>

<div class="users clearfix">
<div class="usersPage">

<div class="listUser">


<h3>Список користувачів</h3>

<c:if test="${'wrong' eq param.reg}">
		<h1 style="color: red">You have not made any changes </h1>
	</c:if>
<table class="tableUsers">
		<thead>
			<tr>
				<th> ID</th>
				<th>Name</th>
				<th>City</th>
				<th>Adress</th>
				<th>Telephone</th>
				<th>e-Mail</th>
				<th>Roles</th>
				<th>Password</th>
				<th></th>
				<th></th>
				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${allUsers}" var="forUsers">
				<tr>
					<td>${forUsers.idUsers} </td>
					<td>${forUsers.nameUsers}</td>
					<td>${forUsers.cityUsers}</td>
					<td>${forUsers.adressUsers}</td>
					<td>${forUsers.telephoneNumberUsers}</td>
					<td>${forUsers.emailUsers}</td>
					<td>${forUsers.roles.roles}</td>
					<td>${forUsers.passwordUsers}</td>
					
					<td class="editdel"><a href="usersList/${forUsers.idUsers}">Видалити</a></td>
					
					<td class="editdel"><a href="editUsers/${forUsers.idUsers}">Змінити</a></td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="roles">
<h5>Роли</h5>
<table class="rolesTable">
		<thead>
			<tr>
				<th> ID</th>
				<th>Role</th>
				
			</tr>
		</thead>
		
		<tbody>
			
			<c:forEach items="${allRoles}" var="roles">
				<tr>
					<td>${roles.idRoles} </td>
					<td>${roles.roles}</td>
										
				</tr>
			</c:forEach>
		</tbody>
	</table>


<hr/>
	<form action="newRole" method="POST">
		<h3>Додати роль</h3>
		<p>
		<label>Role </label>
		 <input type="text" name="nameRole" required>
				<br/>	
			
			<button type="submit">Зберегти</button>
		</form>

</div>

<div class="adminNewUser">
<hr/>
		<form action="newUsers" method="POST">
		<h2>Додати користувача</h2>
		<span id="valid" ></span>
		<br/>
		<p>
		<label>Name </label>
			<input type="text" name="nameUser" placeholder="enter your name" required>
			<label>City </label>
			 <input	type="text" name="cityUser" placeholder="enter your city">
			<label>Adress </label>
			<input	type="text" name="adressUser" placeholder="enter your adress"><br/>
			<label>Telephone </label>
			<input	type="tel" name="telephoneUser" id="phoneNumberUser"
			placeholder="enter your name" required>
			<label>e-Mail </label>
			<input	type="email" name="emailUser"
			placeholder="em@site.ua" required id="email"/>
			<label>Password </label>
			<input	type="text" name="passwordUser" placeholder="your password"
			required/><br/>
			<label>Role </label>
			<select name = "idRole" class="forselects">
		   	 <c:forEach items="${allRoles}" var="roles">
		        <option   value="${roles.idRoles}"><c:out value="${roles.roles}" /></option>    
		   	 </c:forEach>
			</select> <br/>
			
			
			<button type="submit">Зберегти користувача</button>
		</form>
		
</div>
<script type="text/javascript">
    $(document).ready(function() {
        $('#email').blur(function() {
            if($(this).val() != '') {
                var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                if(pattern.test($(this).val())){
                    $(this).css({'border' : '1px solid #569b44'});
                    $('#valid').css({'color': 'green'}).text(' (Поле email Верно)');
                } else {
                    $(this).css({'border' : '1px solid #ff0000'});
                    $('#valid').css({'color': 'red'}).text(' (Поле email Не верно) ');
                }
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
                $('#valid').css({'color': 'red'}).text(' (Поле email не должно быть пустым) ');
            }
        });
    });

		jQuery(function($) {
			$("#phoneNumberUser").mask("(099) 999-99-99");
		});
	</script>
<hr/>
<div class="editUsersform">
<form action="edit/${user.idUsers}" method="POST">
<span id="valid2" ></span>
		<h2>Змінити користувача</h2>
		<h6>*Натисніть ""змінити" навпроти користувача, після чого можна проводити зміни</h6>
		<br/>
		<p>
			<h4>Користувач ID ${user.idUsers}</h4>
			<label>Name </label>
			<input type="text" name="nameUser" value="${user.nameUsers}">
			<label>City </label>
			<input	type="text" name="cityUser" value="${user.cityUsers}">
			<label>Adress </label>
			<input	type="text" name="adressUser" value="${user.adressUsers}"><br/>
			<label>Telephone </label>
			<input	type="tel" name="telephoneUser" value="${user.telephoneNumberUsers}" id="phoneNumberUser2"/>
			<label>e-Mail </label>
			<input	type="email" name="emailUser" value="${user.emailUsers}"  id="email2"/>
			<label>Password </label>
			<input	type="text" name="passwordUser" value="${user.passwordUsers}"><br/>
			<label>Role </label>
			<select name = "idRole" class="forselects">
		   	 <c:forEach items="${allRoles}" var="roles">
		        <option  value="${roles.idRoles}"><c:out value="${roles.roles}" /></option>    
		   	 </c:forEach>
			</select> 
			<br/>
			
			<button type="submit">Зберегти зміни</button>
			
		</form>
		</div>
		
		<hr/>
<script type="text/javascript">
    $(document).ready(function() {
        $('#email2').blur(function() {
            if($(this).val() != '') {
                var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                if(pattern.test($(this).val())){
                    $(this).css({'border' : '1px solid #569b44'});
                    $('#valid2').css({'color': 'green'}).text(' (Поле email Верно)');
                } else {
                    $(this).css({'border' : '1px solid #ff0000'});
                    $('#valid2').css({'color': 'red'}).text(' (Поле email Не верно) ');
                }
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
                $('#valid').css({'color': 'red'}).text(' (Поле email не должно быть пустым) ');
            }
        });
    });

		jQuery(function($) {
			$("#phoneNumberUser2").mask("(099) 999-99-99");
		});
	</script>

 </div>
 </div>

 <!-- Footer -->
    <footer class="bg-black">
      <div class="container">
        <div class="row">
			<div class="col-md-6 ">
				<div class="cp-right">
					<p>&copy; 2015 <a href="#" class="color-primary linear">@Rost@</a>.Reserved. </p>
				</div><!-- end build -->
			</div><!-- end col -->
			
			<div class="col-md-6 text-right">
		
			<ul class="list-inline">
			<li><a href="http://vk.com/id289852074" target="_blank" class="socIcon color-primary linear"><i class="fa fa-vk fa-2x"></i></a></li>
			<li><a href="#" class="socIcon color-primary linear"><i class="fa fa-twitter fa-2x"></i></a></li>
			<li><a href="#" class="socIcon color-primary linear"><i class="fa fa-dribbble fa-2x"></i></a></li>
			</ul>
		
			</div>
        </div>
      </div>
    </footer>
    <!-- /Footer -->

</div>
</body>
</html>