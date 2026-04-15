<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
    <div class="col-md-10 ml-sm-auto col-lg-10 text-center h-100 w-100 p-0">
        <div class="background-home h-100 w-100 reveal">
            <div class="container center-vertical  h-100  justify-content-center reveal">
                <div class="row">
                    <div class="col text-left">
                        <h6> 
						<span class="text-secondary ml-5 font-weight-light">BIENVENIDO A SILFAC,</span> 
					</h6>
                        <h1> 
						<span class="text-secondary ml-5 font-weight-bold text-uppercase"><c:out value="${pageContext.request.userPrincipal.name}" /></span> 
					</h1>
                    </div>
                    <div class="col">
                       
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@ include file="../layout/footer.jsp"%>