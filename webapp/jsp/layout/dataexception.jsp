<%@ include file="../layout/header.jsp"%>
<div class="col-md-12 col-lg-12 col-sm-12">
	<div class="row align-items-center h-100">
		<div class="col-md-12 text-center">
			<p>
			<h2>Oops !</h2>
			</p>
			<p>
				<span>Lo sentimos, tenemos problemas para conectar con la base de datos. Comprueba tu conexión a internet.</span>
			</p>
			<p>
				<a class="btn bg-danger text-white btn-sm " href="<c:url value='/'/>" role="button">Regresar al inicio.</a>
			</p>
		</div>
	</div>
</div>
<%@ include file="../layout/footer.jsp"%>
