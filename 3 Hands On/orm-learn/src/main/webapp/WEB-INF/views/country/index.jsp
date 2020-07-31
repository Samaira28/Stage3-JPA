<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Auto Complete with Spring MVC</title>
<%-- <script
	src="${pageContext.request.contextPath }/resources/js/jquery-1.4.2.js"></script> --%>
<script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
  <script
  src="https://code.jquery.com/jquery-1.12.4.min.js"
  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
  crossorigin="anonymous"></script>
<%-- <script
	src="${pageContext.request.contextPath }/resources/js/jquery-ui-1.8.2.custom.js"></script> --%>
<link
	href="${pageContext.request.contextPath }/resources/css/themes/base/jquery.ui.all.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript">
	$(document).ready(function() {
		$('#countryName').autocomplete({
			source : '${pageContext.request.contextPath }/country/search'
		});
	});
</script>
</head>
<body>
	Search Product
	<input type="text" id="countryName">
</body>
</html>