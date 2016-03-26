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
		

<title>Emily: Dostavka</title>

<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">

</head>
<body class="adminBody">
<div class="PageAdmin">

<div class="main-navLogin1 clearfix1">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="index">EMILY</a>
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
           
           
            <li><a href="personalAccount" class="linear">Адміністрування</a></li>
            <li><a href="index" class="linear">Головна сторінка</a></li>
             <li><a href="logout" class="linear">Вихід</a></li>
            </ul>
        
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>
	
<div class="dostavaka clearfix">
<div class="dostavkaPage">

<div class="tableshowdostavka">
<h2>Список перевізників</h2>
<table class="bordered">

		<thead>
			<tr>
				<th> id</th>
				<th>Перевізник</th>
				<th>Ціна доставки (на склад)</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${allTransporter}" var="transport">
				<tr>
					<td>${transport.idTransporter}</td>
					<td>${transport.nameTransporter}</td>
					<td>${transport.costOfDelivery} грн</td>
					
					<td class="editdel"><a href="dostavka/${transport.idTransporter}">видалити</a></td>
					<%-- 
					<td><a href="editTransporter/${transport.idTransporter}">edit</a></td>
					 --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
	<p></p>
	
	


<hr/>
<div class="newTransporter">
		<form action="newTransporter" method="POST">
		<h2>Додати перевізника</h2>
		<p>
		<label>Назва </label>
		<input type="text" name="nameTrans" required>
		<label>Вартість доставки</label>
			 <input	type="number" name="cost" required min="0"><br/>
			<button type="submit">Зберегти перевізника</button>
		</form>
</div>		
<hr/>

<div class="editTransporter">
 <h2>Внести зміни до перевізника</h2>
	<h6>Для зміни назви та/або ціни виберіть ID перевізника, введіть його назву (нову, або вже існуючу) та ціну.</h6>
	<form action="editTransporter" method="POST">
		
		<p>
			id: <select name = "idTrans">
    <c:forEach items="${allTransporter}" var="transport">
        <option  value="${transport.idTransporter}"><c:out value="${transport.idTransporter}" /></option>    
    </c:forEach>
		</select> 
		<label>Нова назва: </label>
			<input type="text" name="newName"
				maxlength="30" required/> 
				<label>Нова ціна: </label>
			<input type="number" name="newCost" required min="0"/>
			<button type="submit">Внести зміни</button>
	</form> 
	</div>
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
			<li><a href="" class="socIcon color-primary linear"><i class="fa fa-twitter fa-2x"></i></a></li>
			<li><a href="" class="socIcon color-primary linear"><i class="fa fa-dribbble fa-2x"></i></a></li>
			</ul>
		
			</div>
        </div>
      </div>
    </footer>
    <!-- /Footer -->
    
   
</div>
</body>
</html>