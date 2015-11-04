<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width-device-width, initial-scale=1.0">
<title>SUST Archives</title>
<link href="<c:url value="/resources/css/topbar.css" />"
	rel="stylesheet" type="text/css" />
	
	<link href="<c:url value="/resources/css/reset.css" />"
	rel="stylesheet" type="text/css" />
	
	<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet" type="text/css" />
	
	<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet" type="text/css" />

<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />"
	rel="stylesheet" type="text/css" />

<script
	src="<c:url value="/resources/javascript/jquery-1.11.3.min.js" />"
	type="text/javascript"></script>
<script src="<c:url value="/resources/javascript/bootstrap.min.js" />"
	type="text/javascript"></script>


</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="row topbar">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div
			class="
                 col-sm-4 col-sm-offset-1
                 col-xs-12">
			<a class="navbar-brand" href="/greatweb">SUST Archives<sup>beta</sup></a>
		</div>
	</div>
	</nav>
	</div>
	</nav>
<!--  
	<form action="checklogin" method="post">
<<<<<<< HEAD
		<p id="login_status_message"><c:out value ='${message}'/></p>
<<<<<<< HEAD
		  User name:<br>
		<input id="username" name="username"></input>
		  <br>Password:<br> 
		<input id="password"name="password" type="password"></input> 
		<br> <br>
		<input type="submit"
			value="Log in"></input>
<!--  	<table border="0" cellpadding="0" cellspacing="0">
		<tr>
			<th>Username:</th>
			<td><form:input type="text" id="username" name="username" /></td>
		</tr>
		<tr>
			<th>Password:</th>
			<td><form:input type="password" id="password" value="************"  onfocus="this.value=''"  name="password"/></td>
		</tr>
		<tr>
			<th></th>
			<td valign="top"><input type="checkbox" class="checkbox-size" id="login-check" /><label for="login-check">Remember me</label></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="submit" class="submit-login" value="Log In" "  /></td>
		</tr>
	</table>-->
=======
		<input id="username" name="username"></input> <input id="password"
			name="password" type="password"></input> <input type="submit"
			value="Log in"></input>
>>>>>>> d0a811f7acc061096af66a4689905074b2df21fb
	</form>
=======
		<p id="login_status_message">
			<c:out value='${message}' />
		</p>
		<input id="username" name="user_name"></input> 
		<input id="password"name="password" type="password"></input> 
		<input type="submit" value="Log in"></input>
	</form>  -->
	

     <div id="container">
		
		<form action="checklogin" method="post">
		
		<label for="name">Username:</label>
		
		<input type="name" id="username" name="user_name">
		
		<label for="username">Password:</label>
		
		
		
		<input id="password"name="password" type="password">
		
		<div id="lower">
		
		
		
		<input type="submit" value="Login">
		
		<p id="login_status_message">
			<c:out value='${message}' />
		</p>
		
		</div>
		
		</form>
		
	</div>
	
>>>>>>> fbcb89ffc8092d9ea7194463b4bb938039645baf
</body>
</html>