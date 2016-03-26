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
	
     <link href="<c:url value="/resources/css/ekko-lightbox.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/flexslider.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/animate.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
		



<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">

<title>Emily: Вхід</title>
</head>
<body  class="loginPage">

<div id="loginWrapp">
   
   	  <div class="main-navLogin clearfix">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="index">EMILY</a>
        </div>
        
        <div class="login">
        	<p>
        	<sec:authorize access="hasRole('User') or hasRole('Admin')">
        	Hello, ${aloha.nameUsers}
			<a href="logout">Вихід</a>
			</sec:authorize>
			</p>
			
			
        </div>
        
        
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
         <ul class="nav navbar-nav navbar-right">
           
            <li class="current"><a href="#about" class="linear">Вхід</a></li>
            <li><a href="index" class="linear">Головна</a></li>
            </ul>
        
         
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>
    
    <div class="enterLogin">
    <div class="formEnterLogin">
    
    <c:if test="${'success' eq param.reg}">
		<h2 style="color: green">You have created a new user. Now you can
			login!</h2>
	</c:if>
	
    	<h1>Вхід до сайту Emily</h1>
    	
    	<c:if test="${'fail' eq param.auth}">
		<h2 style="color: red">Wrong username or password</h2>
		</c:if>
	
	<h2>Будь-ласка введіть Ваш Email та пароль.</h2>

	<form action="login" method="POST">
		<label>Login:</label><br> 
		<input type="text" name="emailUser"
			placeholder="enter your email" required><br> 
			<label>Password:</label><br>
		<input type="password" name="passwordUser" placeholder="your password"
			required><br>
			<br/>
			
		<button type="submit">Вхід</button>
	</form>
	<br>
	<a href="newUser">Зареєструвати нового користувача</a>
    </div>
    </div>
    
    <div class="newFooter">
    
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
    
  </div>
    
<div class="myfooter">
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
    </div>
    <!-- /Footer -->
</div>
</body>
</html>