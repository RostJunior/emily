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

<title>Emily: Відправити листа</title>

<script type="text/javascript"
	src="<c:url value='/resources/js/jquery-1.11.3.min.js'/>"></script>
<script type="text/javascript"
	src="<c:url value='/resources/js/jquery.maskedinput.js'/>"></script>
	
</head>
<body class="email">

<div class="newUser">
   
   	  <div class="main-navLogin1 clearfix1">
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
           
            <li class="current"><a href="#about" class="linear">Зворотній зв'язок</a></li>
            <li><a href="index" class="linear">Головна</a></li>
            <li><a href="loginPage" class="linear">Вхід</a></li>
            </ul>
        
         
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>
	
	
	
<div class="emailPage clearfix">
	<c:if test="${'success' eq param.sendmail}">
		<h2 style="color: green">Your message was sent! You can send
			another one.</h2>
	</c:if>
		<h3>Написати листа</h3>
	<div id="emailsend">
		
		<form action="sendMail" method="post" enctype="multipart/form-data">
			<p>
				<label>Your name:</label><br> 
				<input type="text" title="enter name" name="customerName" value="${aloha.nameUsers}" required>
			</p>
			<p>
				<label>Your phone number:</label><br>
				 <input type="text" id="phoneNumberUser" title="enter numbers only" name="phoneNumber" value="${aloha.telephoneNumberUsers}"
					onkeyup="this.value=this.value.replace(/[^\d]/,'')"
					placeholder="numbers only" required>
			</p>
			<p>
				<label>Your e-mail:</label><br>
				<span id="valid"></span> 
				<input type="email" id="email" title="e-mail" name="email" placeholder="example@mail.com" value="${aloha.emailUsers}" required>
			</p>
			<p>
				<label>Additional info:</label><br>
				<textarea rows="5" cols="35" name="question"></textarea>
			</p>
			<div id="uploadImg">
			<p>
				<input type="file" title="Upload picture" name="pictureArray"
					accept="image/jpeg,image/jpg,image/gif,image/png"><br>
				<!-- This parameter can be set in servlet-context.xml -->
				<font size="2em" color="grey">Maximum image size 1Mb</font>
				<p>
			</div>
			<p>
			<button type="submit">Send</button>
			<button type="reset" value="Clear">Clear</button>
			</p>
		</form>
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
   
    <!--contact-->
    
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
