<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Submit Purchase Order</title>
<script type="text/javascript" src="/IMS/resources/js/submitpo.js"></script>
</head>
<body>
	<div>
		<form>
			<label for="supplier">Supplier</label>
			<select name="supplier">

			</select> 
			<label for="retailer">Retailer</label> 
			<select name="retailer">

			</select> <br>

			<ol id="polines">

			</ol>
			<div align="right">
				<button type="button" id="additem">+</button>
				<br>
			</div>
			<div align="left">
				<button type="button" id="submit" class="controlbutton">Submit</button>
				<button type="button" id="save" class="controlbutton">Save for Later</button>
				<button type="button" id="cancel" class="controlbutton">Cancel</button>
			</div>

		</form>
	</div>
</body>
</html>