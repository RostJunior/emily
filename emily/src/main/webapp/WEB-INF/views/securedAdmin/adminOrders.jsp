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
	
<title>Emily: Звіти</title>
</head>
<body class="adminBody">
<div class="PageAdmin">
<div class="main-navLogin1 clearfix1 nav-order">
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

<div class="order-List clearfix">
<div class="order-page">

<div class="order-list">

<table class="table-show-order">
		<thead>
			<tr>
				<th> №</th>
				<th>Дата<br/> замовлення</th>
				<th>Им'я клієнта</th>
				<th>e-Mail</th>
				<th>Телефон</th>
				<th>Місто</th>
				<th>Адреса</th>
				<th>Доставка</th>
				<th>Назва</th>
				<th>Фото</th>
				<th>Кількість</th>
				<th>Ціна</th>
				<th>Сума<br/>(с доставкой)</th>
				
							
				<th></th>
				
			</tr>
		</thead>
		<tbody>
		
			<c:forEach items="${allOrders}" var="order">
				<tr>
					<td>${order.idPurchase}</td>
					<td>${order.datePurchase}</td>
					<td>${order.client.nameUsers}</td>
					<td>${order.client.emailUsers}</td>
					<td>${order.client.telephoneNumberUsers}</td>
					<td>${order.client.cityUsers}</td>
					<td>${order.client.emailUsers}</td>
					<td>${order.dostavka.nameTransporter}</td>
				
					<td>${order.cart.product.nameProduct}</td>
					<td class="photoTable">
					
					<img src="<c:url value="/resources/img/portfolio/${order.cart.product.namePhoto}"/>" 
					alt="${order.cart.product.namePhoto}" title="${order.cart.product.namePhoto}"/>
					</td>
					
					
					<td>${order.cart.countProduct}</td>
					<td>${order.cart.product.priceProduct}</td>
					<td>${order.totalAmount}</td>
										
					<td><a href="deleteOrder/${order.idPurchase}">X</a></td>
					
					
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

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