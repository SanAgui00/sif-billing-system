<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login | Silfac</title>
<link rel="icon" type="image/svg+xml" href="<c:url value='/imagenes/favicon.svg'/>">
<script src="<c:url value='/js/jquery-3.1.1.min.js' />"></script>
<script src="<c:url value='/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/js/scrollreveal.min.js' />"></script>
<script src="<c:url value='/js/typed.min.js' />"></script>
<script src="<c:url value='/js/app.js' />"></script>
<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
<link rel="stylesheet" href="<c:url value='/css/theme.css' />">
</head>
<body class="body-login">
	<nav class="navbar fixed-top">
		<a class="navbar-brand" href="#"> <img src="<c:url value='/imagenes/logo.svg' />" class="d-inline-block align-top logo" alt="">
		</a>
	</nav>
	<div class="container-fluid h-100">
		<div class="row h-100">
			<div class="col-lg-5 col-md-5 col-sm-5 col-xs-5 text-center reveal-delay" style="background-color: #f7f7f7;">
				<div class="container col-lg-6 center-vertical h-100  justify-content-center">
					<form class="form" role="form" autocomplete="off" id="formLogin" name='f' action="login" method="POST">
						<div class="form-group">
							<label for="uname1" class="float-left pt-3"><b>Usuario</b></label> <input type="text" class="form-control form-control-sm border-line " name='username' maxlength="20" required> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</div>
						<div class="form-group">
							<label class="float-left pt-3"><b>Contraseña</b></label> <input type="password" class="form-control form-control-sm border-line " name='password' id="pwd1" maxlength="20" required>
						</div>
						<c:if test="${not empty mensaje}">
							<div class="form-group">
								<div class="alert alert-danger alert-dismissible fade show" role="alert">
									<strong><c:out value="${mensaje}"></c:out></strong>
									<button type="button" class="close" data-dismiss="alert" aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
							</div>
						</c:if>
						<button type="submit" class="btn bg-danger text-white btn-sm rounded btn-block mt-3">Iniciar sesión</button>
					</form>
				</div>
			</div>
			<div class="col-lg-7 col-md-7 col-sm-7 col-xs-7 text-center background-login h-100 reveal" style="background-color: #f7f7f7;">
				<div class="center-vertical h-100  justify-content-center text-left">
					<h1>
						<span class="bienvenido"></span>
					</h1>
					<h5>
						<span class="bienvenido-sub reveal-maxdelay">Inicia sesión para acceder a tu cuenta. </span>
					</h5>
				</div>
			</div>
		</div>
	</div>
</body>
</html>