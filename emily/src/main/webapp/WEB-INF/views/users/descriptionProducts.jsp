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
          
          <a class="navbar-brand bg-primary" href="${pageContext.request.contextPath}/index">EMILY</a>
        </div>
        
        
         <div class="shopping">
        <a href="${pageContext.request.contextPath}/ordering">
        	<img alt="Корзина" src="<c:url value="/resources/img/basket.gif"/>" title="кошик">
        </a>
        </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
         <ul class="nav navbar-nav navbar-right">
           
             
             <li><a href="${pageContext.request.contextPath}/index" class="linear">Головна сторінка</a></li>
            <li><a href="${pageContext.request.contextPath}/loginPage" class="linear">Вхід</a></li>
            <sec:authorize access="hasRole('User') or hasRole('Admin')">
            <li><a href="${pageContext.request.contextPath}/logout" class="linear">Вихід</a></li>
            </sec:authorize>
            </ul>
        
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>

<div class="users clearfix">

<c:if test="${'addCart' eq param.cart}">
		<h1 style="color: green">Товар додано до кошика</h1>
</c:if>
<c:if test="${'null' eq param.cart}">
		<h1 style="color: violet">Ви вибрали кількість "0"</h1>
</c:if>

<div class="descr-Product-form">
<div class="descr-Products">
<h3 class="for-name">${product.nameProduct}</h3>
  

	<form action="${product.idProduct}" method="POST" enctype = "multipart/form-data" >
		
		<div class="descr-Photo-Product">
			
		<img src="<c:url value="/resources/img/portfolio/${product.namePhoto}"/>" alt="${product.namePhoto}" title="${product.namePhoto}"/>
					
		</div>
		
		<div class="ordering">
		<div class="price-Product">
		<h3>Ціна:  ${product.priceProduct} грн.</h3>
		
		</div>
		<div class="count-Product">
		<label>Кількість </label>
		<input	type="number" name="count" value="1" required max="10" min="0">
		</div>	
		
			<button type="submit">Додати до замовлення</button>
		</div>
		
		
			<div class="for-text-descr">
			<h4>Опыс</h4>
			<div class="text-Description">
			${product.description}
			</div>
			</div>
		
		
				
			
		</form>
		
		
		
		</div>
		

</div>



</div>

 
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
					<a href="${pageContext.request.contextPath}/emailsender"><span class="fa fa-envelope"></span></a>
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