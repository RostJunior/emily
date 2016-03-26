<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="refresh" content="1" /> -->
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
	
<title>Emily: Редагування товару</title>
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
           
           	<li><a href="${pageContext.request.contextPath}/showProductList" class="linear">Список товару</a></li>
            <li><a href="${pageContext.request.contextPath}/personalAccount" class="linear">Адміністрування</a></li>
            <li><a href="${pageContext.request.contextPath}/logout" class="linear">Вихід</a></li>
          
            
            </ul>
        
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>

<div class="users clearfix">

<div class="add-Product-form">
<div class="edit-Products">
<h3 class="for-id">ID ${editProduct.idProduct}</h3>
<h2>Редагувати товар</h2> 

<form action="${editProduct.idProduct}" method="POST" enctype = "multipart/form-data" >
		
		<div class="edit-Photo-Product">
			
		<img src="<c:url value="/resources/img/portfolio/${editProduct.namePhoto}"/>" alt="${editProduct.namePhoto}" title="${editProduct.namePhoto}"/>
					
		</div>
		
		<div class="description-Product">
			<label>Опис:</label><br>
			<textarea class="text-descript" rows="5" cols="38" name="newdescription" placeholder="add Description">${editProduct.description}</textarea>
		</div>
		
		
		<div class="upload-to-edit" id="uploadFile">
			
				<input type="file" title="Upload picture" name="pictureArrays"
					accept="image/jpeg,image/jpg,image/gif,image/png">
				<div class="fontMax">
				<h6>Maximum 1Mb</h6>
				</div>
			</div>
		
		
		
		<div class="enter-Product-One">
		<label>Name </label><br>
			<input type="text" name="newNameProduct" value="${editProduct.nameProduct}" placeholder="new Name" required><br>
			
			<label>Price </label><br>
			 <input	type="number" name="newPriceProduct" value="${editProduct.priceProduct}" required><br>
		</div>
		
			
			<div class="for-selects">
			<label>Type </label> 
			
			<select class="for-select" name = "newIdType">
			
		   	 <c:forEach items="${allTyps}" var="type">
		        <option  value="${type.idType}"><c:out value="${type.nameType}" /></option>    
		   	 </c:forEach>	
			</select> 
			</div>
			<br/>
			<p>
			<button type="submit">Зберегти зміни</button>
			</p>
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