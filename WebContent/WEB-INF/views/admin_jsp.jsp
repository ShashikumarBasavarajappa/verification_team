<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    <!--
    <spring:url value="/resources/bootstrap/css/bootstrap.min" var="crunchifyCSS" />
        <spring:url value="/resources/bootstrap/js/bootstrap.min" var="crunchifyJS" />
    -->
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
     
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap/js/bootstrap.min.js" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/admin_css.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/background.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet"/>

    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js"></script>
      <script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/login.js"></script>

    </head>


<body>
 <link type="text/css" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet"/>
 
<c:set var="contextPath" value="verification_team"/>
<div id="top-nav" class="navbar navbar-inverse navbar-static-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Dashboard</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" role="button" data-toggle="dropdown" href="#"><i class="fa fa-user-circle"></i> Admin <span class="caret"></span></a>
                    <ul id="g-account-menu" class="dropdown-menu" role="menu">
                        <li><a href="#"><i class="fa fa-user-secret"></i> My Profile</a></li>
                    </ul>
                </li>
                <li><a href="/${contextPath}/logout"><i class="fa fa-sign-out"></i> Logout</a></li>
            </ul>
        </div>
    </div>
    <!-- /container -->
</div>

<!-- /Header -->

<!-- Main -->

<div class="col-lg-2 col-md-2 col-sm-3 col-xs-12">

    <ul class="nav nav-pills nav-stacked" style="border-right:1px solid black">
        <!--<li class="nav-header"></li>-->
        <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
        <li><a href="#"><i class="fa fa-tags"></i> Profile</a></li>
        <li><a href="#"><i class="fa fa-history"></i> Privious Data History</a></li>
        <li><a href="#"><i class="fa fa-lock"></i> Change Password</a></li>

    </ul>
</div><!-- /span-3 -->
<div class="col-lg-10 col-md-10 col-sm-9 col-xs-12">
    <!-- Right -->

    <a href="#"><strong><span class="fa fa-dashboard"></span> My Dashboard</strong></a>
    <hr>
    
</div>
	<div class="container">
		<buton type="button" class="btn btn-info btn-lg" id="myBtn">
          <span class="glyphicon glyphicon-download"></span> Download Todays Data
        </button>
	</div>
</body>
</html>