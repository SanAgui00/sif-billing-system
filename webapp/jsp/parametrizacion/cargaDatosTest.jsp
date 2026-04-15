<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
<%-- 	<div class="row"> --%>
<%-- 	<div class="card-header"> --%>
<%-- 								<a class="float-right text-secondary" href="<c:url value='/home/param/carga/crud'/>" role="button">Regresar</a> --%>
<%-- 							</div> --%>
<%-- 		<div class="col-sm-12"> --%>
<%-- 			<div class="card mt-1">${resultado}</div> --%>
<%-- 		</div> --%>
<%-- 		${idRegla} --%>
<%-- 	</div> --%>
	
	<div class="row">
					<div class="col-sm-12">
						<div class="card mt-1">
							<div class="card-header">
								<span class="title" id="menu-toggle">Resultado Sentencia SQL </span> 
							</div>
							<div id="mainMenu" class="collapse show card-body">
								<div class="row">
									<div class="col-sm-12 col-md-12  text-center">
										<h5 class="card-title">
											<div class="card mt-1">${resultado}</div>
											<sf:form action="${pageContext.request.contextPath}/home/param/carga/crud" method="POST" name="crud" class="text-center">
												<input name="id_reglas_carga" type="hidden" value="${idRegla}" />
												<input name="event" type="hidden" value="${event}" />
												<button type="submit" class="btn btn-secondary text-white btn-sm  btn-table ">
													Regresar
												</button>
											</sf:form>
										</h5>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
</div>
<%@ include file="../layout/footer.jsp"%>
