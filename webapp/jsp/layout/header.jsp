<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%
	// 	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//HTTP 1.1
	// 	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	// 	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Prosa | Silfac</title>
<link rel="icon" type="image/svg+xml"
	href="<c:url value='/imagenes/favicon.svg'/>">
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/css/theme.css' />">
<link rel="stylesheet" href="<c:url value='/css/alertify.min.css' />">
<link rel="stylesheet" href="<c:url value='/css/fonts/style.css' />">
</head>
<body>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<%--<c:out value="${pageContext.request.userPrincipal.name}" /> --%>