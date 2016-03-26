<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html">
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
	
<title>Emily: Опис товару</title>
</head>
<body class="adminBody">
<div class="PageAdmin">

 <div class="main-navLogin1 clearfix1">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="loginPage">ВХІД</a>
        </div>
        
        <div class="login loginAdmin">
        	<p>
        	<sec:authorize access="hasRole('User') or hasRole('Admin')">
        	Hello, ${aloha.nameUsers}
			
			</sec:authorize>
			
			<sec:authorize access="hasRole('anonymousUser')">
			Hello, guest
			</sec:authorize>
			
			</p>
			
			
        </div>
        <sec:authorize access="hasRole('Admin')">
        <div class="toAdmin">
        
        <a href="personalAccount"> AdminAccount </a>
        </div>
        </sec:authorize>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
         <ul class="nav navbar-nav navbar-right">
          	 <li><a href="#aboutMore" class="linear">Кошик</a></li>
            <li><a href="index" class="linear">Головна сторінка</a></li>
             <li><a href="#contact" class="linear">Контакти</a></li>
             <sec:authorize access="hasRole('User') or hasRole('Admin')">
           	<li><a href="/logout" class="linear">Вихід</a></li>
            </sec:authorize>
          </ul>
        
         
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>

<div class="users clearfix">
<c:if test="${'error' eq param.pasword}">
		<h1 style="color: pink">ERROR PASSWORD</h1>
	</c:if>
	
	<c:if test="${'error' eq param.sendMail}">
		<h1 style="color: pink">ERROR SEND</h1>
	</c:if>
	
	<c:if test="${'noUser' eq param.password}">
		<h1 style="color: pink">ERROR PASSWORD FOR USER(CLIENT)</h1>
	</c:if>

<div class="ordering-page">

<div class="ordering-page-form">
<form action="${pageContext.request.contextPath}/orderNew" method="POST">
 <div class="order-cart">
	<table class="order-table">
	<thead>
			<tr>
				<th>Фото</th>
				<th>Продукт</th>
				<th>Тип</th>
				<th>Кількість</th>
				<th>Ціна/шт</th>
				<th>Вартість</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
				
			<c:forEach items="${carts}" var="cart">
				<tr>
					<td>
					<img src="<c:url value="/resources/img/portfolio/${cart.product.namePhoto}"/>" alt="${cart.product.namePhoto}" title="${cart.product.namePhoto}"/>
					</td>
					<td>${cart.product.nameProduct} </td>
					<td>${cart.product.type.nameType}</td>
					<td>${cart.countProduct}</td>
					<td>${cart.product.priceProduct}</td>
					<td>${cart.totalPrice}</td>
					<td><a href="deleteCart/${cart.idCart}">X</a></td>
										
				</tr>
				
			</c:forEach>
			
			
		</tbody>
   
   </table>
   <div>${cartNull}</div>
   </div>
   
   
 
   
  <div class="order-enter-userform">
	<div class="title-table">
	<h3>Контактні данні:</h3>
	<span id="valid"></span>
	<h5>* - обов'язкові поля!</h5>
	</div>
	
		<label>Ім'я*:</label>
		<input type="text" name="nameUsers"
			placeholder="enter your name" required value="${aloha.nameUsers}" ><br> 
		
		<label>Email*:</label>
		<input type="text" name="emailUser"
			placeholder="em@site.ua" value="${aloha.emailUsers}" required id="email" /><br> 
		
		<label>Місто:</label>
		<input type="text" name="cityUsers"
			placeholder="enter your city" value="${aloha.cityUsers}" /><br> 	
			
			<label>Адресса:</label>
		<input type="text" name="adressUsers"
			placeholder="enter your adress" value="${aloha.adressUsers}"/><br> 
			
			<label>Телефон:*</label>
		<input type="text" name="telephoneNumberUsers" id="phoneNumberUser" value="${aloha.telephoneNumberUsers}"
			placeholder="enter your telephone" required/><br> 
			
			
			<label>Password*:</label>
		<input type="password" name="passwordUsers" placeholder="your password"
			required/><br>
			
			<label>Password Repeat*:</label>
		<input type="password" name="passwordUserRepeat" placeholder="your password repeat"
			required/><br>
			<br/>
	
		
	</div> 	
	  <div class="order-dostavka">
   		<h4>Виберіть вид доставки</h4>
   		<select name = "idTrans">
    <c:forEach items="${allTransporter}" var="transport">
        <option  value="${transport.idTransporter}"><c:out value="${transport.nameTransporter}" /></option>    
    </c:forEach>
		</select>
   
   </div>
			<div class="for-button">
			
			<button type="submit">Зробити замовлення</button>
			
			</div>
			
			</form>
			</div>
		</div>
		

</div>
 <script type="text/javascript">
    $(document).ready(function() {
        $('#email').blur(function() {
            if($(this).val() != '') {
                var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                if(pattern.test($(this).val())){
                    $(this).css({'border' : '1px solid #569b44'});
                    $('#valid').text(' (e-mail заповнено вірно)');
                } else {
                    $(this).css({'border' : '1px solid #ff0000'});
                    $('#valid').text(' (Не вірний формат e-mail) ');
                }
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
                $('#valid').text(' (Поле email не повинно бути порожнім) ');
            }
        });
    });

		jQuery(function($) {
			$("#phoneNumberUser").mask("(099) 999-99-99");
		});
	</script>


    <!--contact-->
    <div id="contact" class="page page-bgcolor">
		<div class="container">
		<div class="row">
          <div class="col-md-10  col-md-offset-1">
		    <div class="build title-page">
				<h2 class="text-center">Контакти</h2>	
				<div class="line-title bg-primary"></div>
			</div>
		   </div><!-- end col -->
		</div><!-- end row -->
	  	<div class="row">
			<div class="col-md-4 ">
				<div class="build contact clearfix text-center">
					<span class="fa fa-map-marker"></span>
						<p>вул. Шевченка<br />м. Львів, Україна<p>
				</div>			
			</div><!-- end col -->
			<div class="col-md-4 ">
				<div class="build contact clearfix text-center">
					<span class="fa fa-phone"></span>
					
					<p>mob.<a href="tel:+3 8 097 738 46 52">+380977384652</a></p>
					
				</div>
			</div>
			<div class="col-md-4 ">
			
				<div class="build contact clearfix text-center">
					<a href="emailsender"><span class="fa fa-envelope"></span></a>
					<p>ros-gap601@yandex.ru</p>
					<p>liliya@emily.hol.es</p>
				</div>
				
			</div>
		</div><!-- end row -->
	
	  </div><!-- end container -->
	</div>
    <!--contact-->


<!-- Footer -->
    <footer class="bg-black">
      <div class="container">
        <div class="row">
			<div class="col-md-6 ">
				<div class="cp-right">
					<p>&copy; 2015 <a href="" class="color-primary linear">@Rost@</a>.Reserved. </p>
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