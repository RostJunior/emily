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
		
<!-- End custom CSS here -->

<!-- For icon page -->
<link rel="icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" type="image/x-icon">
<!--/icon  -->
<title>Emily: Реєстрація нового користувача</title>
<!--For library jQuery -->
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.maskedinput.js'/>"></script>
	
</head>
<body class="Body__________">

<div class="Page__________">
 
 <!-- ****************************** MENU up ********************************************-->  
   	  <div class="main-navLogin1 clearfix1">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="index">EMILY</a>
        </div>
        <!--*******************LOGIN name  secured **********************  -->
        <div class="login">
        	<p>
        	<sec:authorize access="hasRole('User') or hasRole('Admin')">
        	Ваш e-Mail: <sec:authentication property="name"/>
			<a href="logout">Вихід</a>
			</sec:authorize>
			
			</p>
			
        </div>
         <!--*******************END LOGIN name**********************  -->
        
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
         <ul class="nav navbar-nav navbar-right">
           
            <li class="current"><a href="#about" class="linear">Реєстрація</a></li>
            <li><a href="index" class="linear">Головна</a></li>
            <li><a href="loginPage" class="linear">Вхід</a></li>
            </ul>
        
         
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>
    <!-- ****************************END MENU************************** -->
    
    <!-- *******************************FOR PAGE *******************************-->
     <div class="newUserPage clearfix">
     <!-- ******************** FOR FORM******************************* -->
    <div class="formNewUser">
    	<h1>Реєстрація нового користувача</h1>
    <!--****************Error/Message/Other***********************  -->	
    	<c:if test="${'wrongpass' eq param.reg}">
		<h1 style="color: red">Password mismatch</h1>
	</c:if>
	<c:if test="${'userduplicate' eq param.reg}">
		<h1 style="color: pink">Username already exists!</h1>
	</c:if>
	<!--****************END Error/Message/Other***********************  -->	
	<h2>Будь-ласка заповніть поля:</h2>
	<h5>* - обов'язкові поля!</h5>
	<!-- ************************FORMA********************************* -->
	<form action="${pageContext.request.contextPath}/newUser" method="POST">
		<label>Ім'я*:</label><br>
		<input type="text" name="nameUsers"
			placeholder="enter your name" required/><br> 
		
		<label>Email*:</label><span id="valid"></span><br> 
		<input type="text" name="emailUser"
			placeholder="em@site.ua" required id="email"/><br> 
		
		<label>Місто:</label><br>
		<input type="text" name="cityUsers"
			placeholder="enter your city"/><br> 	
			
			<label>Адресса:</label><br>
		<input type="text" name="adressUsers"
			placeholder="enter your adress"/><br> 
			
			<label>Телефон:</label><br>
		<input type="text" name="telephoneNumberUsers" id="phoneNumberUser"
			placeholder="enter your name" required/><br> 
			
			
			<label>Password*:</label><br>
		<input type="password" name="passwordUsers" placeholder="your password"
			required/><br>
			
			<label>Password Repeat*:</label><br>
		<input type="password" name="passwordUserRepeat" placeholder="your password repeat"
			required/><br>
			<br/>
	<button type="submit">Реєстрація</button>
	</form>
	
	<!-- ************************FORMA********************************* -->
    </div>
    </div>
       <!-- *******************************END PAGE *******************************-->
       
       
       <!-- **********************---javaScript for Form: ---**********************  -->
    <script type="text/javascript">
    $(document).ready(function() {
        $('#email').blur(function() {
            if($(this).val() != '') {
                var pattern = /^([a-z0-9_\.-])+@[a-z0-9-]+\.([a-z]{2,4}\.)?[a-z]{2,4}$/i;
                if(pattern.test($(this).val())){
                    $(this).css({'border' : '1px solid #569b44'});
                    $('#valid').text(' (Верно)');
                } else {
                    $(this).css({'border' : '1px solid #ff0000'});
                    $('#valid').text(' (Не верно) ');
                }
            } else {
                $(this).css({'border' : '1px solid #ff0000'});
                $('#valid').text(' (Поле email не должно быть пустым) ');
            }
        });
    });

		jQuery(function($) {
			$("#phoneNumberUser").mask("(099) 999-99-99");
		});
	</script>
    
    
         <!--contact-->
   
    <!--contact-->
    
    <!-- ********************************Footer************************************** -->
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
    <!-- ********************/Footer ****************************-->



  </div>
    
  

</body>
</html>