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

    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/login.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/background.css" rel="stylesheet"/>
    <link type="text/css" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath() %>/resources/css/popup.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath() %>/resources/css/bootstrap-datetimepicker.css" rel="stylesheet"/>
<link type="text/css" href="<%=request.getContextPath() %>/resources/css/font-awesome.min.css" rel="stylesheet"/>

    <script src="<%=request.getContextPath() %>/resources/js/jquery-1.8.3.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/css/bootstrap/js/bootstrap.min.js"></script>
      <script src="<%=request.getContextPath() %>/resources/js/jquery-ui-1.9.2.custom.min.js"></script>

        <script src="<%=request.getContextPath() %>/resources/js/bootstrap-datetimepicker.js"></script>



    <script src="<%=request.getContextPath() %>/resources/js/welcome.js"></script>

    <script src="<%=request.getContextPath() %>/resources/js/jquery.min.js"></script>
    <script src="<%=request.getContextPath() %>/resources/js/popup.js"></script>


    </head>

<body>

<c:set var="contextPath" value="verification_team"/>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
      <li><a href="#">Home</a></li>
      <li><a href="/${contextPath}/adminprofile/${main_user_name}">Profile</a></li>
    </ul>
     <ul class="nav navbar-nav navbar-right">
      <li><a href="/${contextPath}/notification/${main_user_name}"><span class="glyphicon glyphicon-log-in"></span> Notification</a></li>
        <li><a href="/${contextPath}/logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
    </ul>

  </div>
</nav>
	<h1> Welcome to the Verification Portal</h1>
	<br />
	<h2>Total CAS APPLICANTS hours</h2>

  <div class="alert alert-warning">
      <a href="#" class="close" data-dismiss="alert">&times;</a>
      <strong>Warning!</strong>       Please enter data and get the results.
  </div>
	<table class="table">
  <thead class="thead-inverse">
    <tr>
      <th>CAS  ID </th>
      <th>Date</th>
      <th>START TIME</th>
      <th>END TIME</th>
      <th>APPLICANT STATUS </th>
      <th>No of Transcripts </th>
      <th>Portal Name </th>
      <th>Edit/Delete</th>
    </tr>
  </thead>
  <tbody>

  <c:forEach items="${verification_data}" var="emp">
    <tr>
      <td class="table-active">${emp.cas_id}</td>
      <td class="table-success">9/06/2017 </td>
      <td class="table-danger">${emp.start_date}</td>
      <td class="table-success">${emp.end_date}</td>
      <td class="table-warning">${emp.applicant_status}</td>
      <td class="table-warning">${emp.no_of_transcripts}</td>
      <td class="table-warning">${emp.portal_name}</td>
      <td class="table-warning"> <a href="edit_data/${emp.cas_id}" class="btn btn-primary a-btn-slide-text">
        <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
        <span><strong>Edit</strong></span>
    </a>/<a href="delete_data/${emp.cas_id}" class="btn btn-primary a-btn-slide-text">
       <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        <span><strong>Delete</strong></span>
    </a></tr>
     </c:forEach>

  </tbody>
</table>

<br />

    <a href="download_excel_data/${main_user_name}"><button class="btn btn-danger navbar-btn" id="archive_user">Download Excel</button></a>

<div >
	    <buton type="button" class="btn btn-info btn-lg" id="myBtn">
          <span class="glyphicon glyphicon-plus"></span> ADD  CAS APPLICANT
        </button>
</div>
<br />
<form id="Applicant_submit" method="post" action="submit_my_data" role="form">

    <div class="messages"></div>
<input type="show" value="${main_user_name}" name="username" readonly="true">
    <div class="controls">

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_name">CAS ID </label>
                    <input id="form_name" type="text" name="cas_id" class="form-control" placeholder="Please	 enter your CAS_ID" required="required" data-error="Please enter the CAS_ID">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_lastname">Start Time </label>
                    <input id="form_lastname" type="text" name="start_date" class="form-control" placeholder="Please enter your start date *">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_email">End Time</label>
                    <input id="form_email" name="end_date" class="form-control" placeholder="Please enter your end date *">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                <label for="form_status">Applicant Status</label>
                    <select name="applicant_status">
					  <option value="verified">verified</option>
					  <option value="not verified">Not verified</option>
					</select>
					<div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="submit" class="btn btn-success btn-send" value="Submit Applicant">
            </div>
        </div>
       </div>

</form>


  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><strong><b>CAS VRIFICATION APPLICANT</b></strong></h4>
        </div>
        <div class="modal-body">
          <form id="Applicant_submit" method="post" action="submit_my_data" role="form">

    <div class="messages"></div>
<input type="hidden" value="${main_user_name}" name="username" readonly="true">
    <div class="controls">

        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_name">CAS ID </label>
                    <input id="form_name" type="text" name="cas_id" class="form-control" placeholder="Please	 enter your CAS_ID" required="required" data-error="Please enter the CAS_ID">
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_lastname">Start Time </label> <span class="glyphicon glyphicon-time"></span>
                    <input id="form_lastname" type="text" name="start_date" class="form-control" placeholder="Please enter your start date *" >
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_email">End TIme <span class="glyphicon glyphicon-time"></span></label>
                    <input id="form_email" name="end_date" class="form-control" placeholder="Please enter your end date *" >
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                <label for="form_status">Applicant Status</label>
                    <select name="applicant_status">
					  <option value="verified">verified</option>
					  <option value="not verified">Un-Delivered</option>
					</select>
					<div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
         <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label for="form_email">No of Transcripts
                    <input id="form_email" name="no_of_transcripts" class="form-control" placeholder="Please enter your Number Of transcripts *" >
                    <div class="help-block with-errors"></div>
                </div>
            </div>
			<div class="col-md-6">
                <div class="form-group">
                    <label for="form_email">Portal Name
                    <input id="form_email" name="portal_name" class="form-control" placeholder="Please enter your Portal Name *" >
                    <div class="help-block with-errors"></div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <input type="submit" class="btn btn-success btn-send" value="Submit Applicant">
            </div>
        </div>
       </div>

</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>

    </div>
  </div>

</div>



<script>
$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
    $(function () {
        $('#datetimepicker3').datetimepicker({
            format: 'LT'
        });
    });
});
</script>
</body>
</html>
