<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head lang="ua">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Emily Украшения для волос в стиле канзаши: Обручи, резинки, брошки, заколки, повъязки.">
    <meta name="Keywords" content="канзаши, Обручи, резинки, брошки, заколки, повъязки, канзаші, emily, emili">
	<meta name="author" content="">
	


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
	
	
	<title>Emily | Прикраси для волосся</title>
</head>
<body>
  <div id="boxWrapp">
    <div class="main-nav clearfix">
	  <!-- navbar -->
	<nav class="navbar navbar-inverse" role="navigation">
        <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          
          <a class="navbar-brand bg-primary" href="loginPage">ВХІД</a>
        </div>
        
        <div class="login">
        	<p>
        	<sec:authorize access="hasRole('User') or hasRole('Admin')">
        	Hello, ${aloha.nameUsers}
			
			<a href="logout">Вихід</a>
			</sec:authorize>
			
			<sec:authorize access="hasRole('anonymousUser')">
			Hello, guest
			</sec:authorize>
			
			</p>
			
			
        </div>
        <sec:authorize access="hasRole('Admin')">
        <div class="toAdmin">
        
        <a href="personalAccount">
        AdminAccount
        </a>
        </div>
        </sec:authorize>
        
        <div class="shopping">
        <a href="ordering">
        	<img alt="Корзина" src="<c:url value="/resources/img/basket.gif"/>" title="кошик">
        </a>
        </div>
        
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="NavCol">
        
         <ul class="nav navbar-nav navbar-right">
           	<li class="current"><a href="#about" class="linear">Головна</a></li>
            <li><a href="#aboutMore" class="linear">Інфо</a></li>
            <li><a href="#work" class="linear">Мої вироби</a></li>
            <li><a href="#contact" class="linear">Контакти</a></li>
           
           
            
          </ul>
        
         
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>
    <!-- Full Page Image Header Area -->
    <div id="about" class="header">

	<div class="maskHeader"></div>
	<div class="main-caption">
		<div class="logo">
			<img src="<c:url value="/resources/img/jk.png"/>" alt="logo" />
		</div>
			<!-- slider -->
	<div id="flex-head" class="flexslider">
		<ul class="slides">
			<li>
				<h1>Прикраси для волосся в стилі канзаші</h1>	
				
			</li>
			<li>
				<h1>Прикраси для волосся в стилі канзаші</h1>	
				
			</li>
			<li>
				<h1>Прикраси для волосся в стилі канзаші</h1>	
					
			</li>
		</ul>
	</div> 
    <!-- end slider --> 
		<a href="#aboutMore" class="btn btnAbout btn-clear border-color color-primary btn-lg linear">ДЕТАЛЬНІШЕ</a>
	</div><!--  end main caption -->
			
    </div>
	<!-- end header -->
    <!-- /Full Page Image Header Area -->

    
    <!-- content -->
    <div id="aboutMore" class="page">
      <div class="container">
		<div class="row">
          <div class="col-md-10  col-md-offset-1">
		    <div class="build title-page">
				<h2 class="text-center">Доброго дня!</h2>	
				<div class="line-title bg-primary"></div>
			</div>
		   </div><!-- end col -->
		</div><!-- end row -->
		
        <div class="row">
           <div class="col-md-6">
			   <div class="build main-about">
				   <div class="row">
				       
				       <div class="col-md-9">
				            <div class="about-content">
						<p> Мене звати Лілія. Виготовляю канзаші-прикраси з квітами з атласних стрічок та тканини. 
						Створю для Вас красиву неповторну прикрасу.
						Можлива робота за Вашими ескізами, пропонуйте свої варіанти, або з мотивів моїх робіт.
						Із задоволенням виконаю щось незвичайне і нове, з стрічок в техніці Канзаші, і Ви будете неповторні.
						Обручі, резиночки, шпильки, брошки, стріли, краби, пов’язки – замовлення може бути на цих основах.
						Вартість залежить від складності роботи. Звертайтесь по телефону або <a href="http://vk.com/id289852074" target="_blank" title="Лилия Канзаши">Вконтакте</a></p>
						<a href="#contact" class="btn btn-clear btn-lg border-color linear hire">Контакти</a>
					</div>
				       </div>
				   </div>
				  
					
				</div>
            </div>
			<!-- end col -->
		 
       
			
        </div>
		
		<!-- end row -->
      </div>
      </div>
    
    <!-- /Intro -->   

    <!-- Portfolio -->
    <div id="work" class="page clearfix">
      <div class="container">
		<div class="row">
          <div class="col-md-10  col-md-offset-1">
		    <div class="build title-page">
				<h2 class="text-center">Мої Вироби</h2>	
				<div class="line-title bg-primary"></div>
			</div>
		   </div><!-- end col -->
		</div><!-- end row -->
		   <div class="col-md-12">
                
                <ul id="filterOptions" class="clearfix">
                    <li class="cur"><a class="btn btn-link linear" href="#" data-group="all">Всі</a></li>
                <c:forEach items="${allType}" var="type">   
                    <li><span>/</span></li>
                    <li class="cur"><a class="btn btn-link linear" href="#" data-group="${type.nameType}">${type.nameType}</a></li>
				</c:forEach>	
                </ul>
               
            </div><!--end-col-->
		  <div class="col-md-12">
		  <div class="folio-content clearfix">
		   <div class="row">
		   <div class="container_folio clearfix gallery" id="grid">
		   <!-- start -->
		   
		   <c:forEach items="${allProducts}" var="product">
			<div class="col-xs-12 col-sm-4 col-md-4 box" data-groups='["all", "${product.type.nameType}"]'>
			<div class="folio-img">
				<div class="portfolio-item ">
					<div class="thumbnail">
					   <div class="thumb-img">
					  
					  <div class="link-attr">
						    <a href="<c:url value="/resources/img/portfolio/${product.namePhoto}"/>" data-gallery="global-gallery" data-parent="" data-toggle="lightbox" data-title="${product.nameProduct}" class="link-search animated linear"><i class="fa fa-search"></i></a>
						   <a href="description/${product.idProduct}" class="link-chain animated linear"><i class="fa  fa-chain"></i></a>
					   </div>
						
					  	<img class="linear img-portfolio img-responsive" src="<c:url value="/resources/img/portfolio/${product.namePhoto}"/>" alt="${product.namePhoto}" title="${product.namePhoto}"/>
					   
					   <div class="folio-caption">
					   <i class="fa fa-caret-up"></i>
					       <p>Ціна ${product.priceProduct} грн.</p>
					      
					   </div>
					   </div>
					</div>
				
				</div>
			</div>
			</div>
			</c:forEach>	
			
		<!-- end -->	
		   </div>
		  
		   </div>
		  </div><!-- end folio content -->
		  </div><!-- end col -->
      </div><!--end container-->
	 
	 
    </div>
    <!-- /Portfolio -->
    
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

    <!-- JavaScript -->
    <script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.sticky.js"/>"></script>
	 <script src="<c:url value="/resources/js/jquery.nav.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.scrollTo.js"/>"></script>
    <script src="<c:url value="/resources/js/jquery.flexslider.js"/>"></script>
   <script type="text/javascript" src="<c:url value="/resources/js/ekko-lightbox.js"/>"></script>
   <script src="<c:url value="/resources/js/jquery.easing.1.3.js"/>"></script>
   <script src="<c:url value="/resources/js/jquery.shuffle.js"/>"></script>
    <script src="<c:url value="/resources/js/script.js"/>"></script>

    <!-- Custom JavaScript for the Side Menu and Smooth Scrolling -->

  </div>
  
  
  </body>

</html>
