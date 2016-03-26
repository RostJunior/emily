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
	
<title>Emily: Products</title>
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
           
            <li class="current"><a href="#about" class="linear">Додати товар</a></li>
            <li><a href="personalAccount" class="linear">Адміністрування</a></li>
            <li><a href="index" class="linear">Головна сторінка</a></li>
             <li><a href="logout" class="linear">Вихід</a></li>
            </ul>
        
        </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
	  
	</div>

<div class="users clearfix">

<div class="add-Product-form">
<div class="newProducts">

<h2>Додати товар</h2>

<form action="newProduct" method="POST" enctype = "multipart/form-data" >
		<div class="enterProductOne">
		<label>Name </label><br>
			<input type="text" name="nameProduct" value="name" placeholder="new Name" required><br>
			
			<label>Price </label><br>
			 <input	type="number" name="priceProduct" value="0" required min="0"><br>
		</div>
		<div class="descriptionProduct">
			<label>Додати опис:</label><br>
			<textarea class="text-descript" rows="5" cols="38" name="description" placeholder="add Description"></textarea>
		</div>
			<div class="upload" id="uploadFile">
			
				<input type="file" title="Upload picture" name="pictureArray"
					accept="image/jpeg,image/jpg,image/gif,image/png"><br>
				<div class="fontMax">
				<p>Maximum image size 1Mb</p>
				</div>
			</div>
			<div >
			<label>Type </label> 
			
			<select class="forselects" name = "idType">
			
		   	 <c:forEach items="${allTypes}" var="type">
		        <option  value="${type.idType}"><c:out value="${type.nameType}" /></option>    
		   	 </c:forEach>
			</select> 
			</div>
			<br/>
			<p>
			<button type="submit">Додати товар</button>
			</p>
		</form>
		
		
		
		</div>
		
<div class="typsforProduct">
		<h3>Типи товара</h3>
<div>	
	<table class="typsTable">
		<thead>
			<tr>
				<th height="35px" width="140px"> ID</th>
				<th height="35px" width="140px">Type</th>
				<th height="35px" width="140px"></th>
			</tr>
		</thead>
		
		<tbody>
				
			<c:forEach items="${allTypes}" var="typelist">
				<tr>
					<td width="140px" align="center">${typelist.idType} </td>
					<td width="140px" align="center">${typelist.nameType}</td>
					<td><a href="deleteType/${typelist.idType}">delete</a></td>
										
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>	
	<br/>	
	<div>
	<h5>Додати тип</h5>	
	<form action="newType" method="POST">	
		<label>Назва</label><br>
			<input type="text" name="nameType" value="type" placeholder="new Type" required><br>
			<p><button type="submit">Зберегти</button></p>
	
	</form>
</div>

</div>

</div>

<div class="addProuctLink">
<a href="showProductList">Показати всі продукти</a>
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