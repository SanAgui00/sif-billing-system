<%@ include file="../layout/header.jsp"%>
<%@ include file="../layout/menu.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-md-10 ml-sm-auto col-lg-10 pb-4">
    <%-- etiquetas unicas --%>
    <%-- EDIT --%>
    <c:if test="${'edit'=='edit'}">
        <sf:form
            action="${pageContext.request.contextPath}/home/registro/mantener/save"
            method="POST">
            <c:forEach items="${consulta}" var="consulta">
                <input name="id_poliza" type="hidden" value="${consulta.id_poliza}" />
                
                <input name="descripcion1" type="hidden" value="${descripcion}" />
                <input name="fecha" type="hidden" value="${fecha}" />
                <input name="id_generado_gl" type="hidden" value="${id_generado}" />
                <div class="row">
                    <div class="col-sm-12">
                        <div class="card mt-1">
                            <div class="card-header">
                                <span class="title" id="menu-toggle">Editando a <c:out
                                        value="${consulta.id_poliza}"></c:out></span>
                                <%-- menus --%>
                                <%-- menus --%>
                                <%-- menus --%>
                                <ul class="nav d-inline-block">
                                    <li class="nav-item d-inline-block"><a
                                        class="nav-link text-secondary p-0 mr-3 ml-5  tab-link active"
                                        id="tab-1" data-toggle="tab" href="#tab1" role="tab"
                                        aria-controls="tab1" aria-selected="true">Datos Registros
                                            Contables</a></li>
                                    <li class="nav-item d-inline-block"><a
                                        class="nav-link text-secondary p-0 mr-3  tab-link ${ estatus eq 'ENV' ? 'disabled' : ''}" id="tab-2"
                                        data-toggle="tab" href="#tab2" role="tab" aria-controls="tab2"
                                        aria-selected="false">Agregar Registro</a></li>

                                </ul>
                                <%-- menus --%>
                                <%-- menus --%>
                                <%-- menus --%>
                                <a class="float-right text-secondary"
                                    href="<c:url value='/home/registro/mantener'/>"
                                    role="button">Regresar</a><span
                                    class="float-right text-secondary mr-3" id="btn-ocultar">Ocultar</span>
                            </div>
                            <div class="tab-content" id="mainMenu">
                                <div class="tab-pane  show active" id="tab1" role="tabpanel"
                                    aria-labelledby="tab-1">
                                    <%-- menu 1--%>
                                    <%-- menu 1--%>
                                    <%-- menu 1--%>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-6 col-md-6 mt-2">
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Clave de
                                                        Poliza</label>
                                                    <div class="col-sm-8">
                                                        <label class="col-form-label">${descripcion}</label>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Fecha de Generacion</label>
                                                    <div class="col-sm-8">
                                                        <label class="col-form-label">${fecha}</label>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Tipo de Cambio</label>
                                                    <div class="col-sm-8">
                                                        <label class="col-form-label">${consulta.tipo_cambio}</label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-md-6 mt-2">
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Descripcion
                                                        de Poliza </label>
                                                    <div class="col-sm-8">
                                                        <label class="col-form-label">${descripcion}</label>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">ID de Silfac</label>
                                                    <div class="col-sm-8">
                                                        <label class="col-form-label">${id_generado}</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <%-- menu 1--%>
                                    <%-- menu 1--%>
                                    <%-- menu 1--%>
                                </div>
                                <div class="tab-pane" id="tab2" role="tabpanel"
                                    aria-labelledby="tab-2">
                                    <%-- menu 2 --%>
                                    <%-- menu 2 --%>
                                    <%-- menu 2 --%>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-sm-6 col-md-6 mt-2">
                                                <input type="hidden" id="path"
                                        value="${pageContext.request.contextPath}" />
                                    

												<div class="form-group row">
													<label class="col-sm-4 col-form-label">
														Cliente</label>
													<div class="col-sm-8">
														<select class="form-control form-control-sm "
															id="listaDeClientes" name="id_cliente">
															<option value="">Selecciona una opcion</option>
															<c:forEach items="${listaClientes}" var="lista">
																<option
																	value="<c:out value="${lista.id_cliente}||${lista.clave_cliente}||${lista.nombre_corto}"> </c:out>"
																	${ lista.id_cliente==cliente ? 'selected="selected"' : ''}>
																	<c:out value="${lista.clave_cliente}"></c:out> -
																	<c:out value="${lista.nombre_corto}"></c:out></option>
															</c:forEach>
														</select>
													</div>
												</div>
                                    <div class="form-group row">
                                        <label class="col-sm-4 col-form-label">Proceso</label>
                                        <div class="col-sm-8">
                                            <select class=" form-control form-control-sm"
                                                name="proceso" id="proceso" >
                                                <option value="">Selecciona una opcion</option>
                                                <c:forEach items="${listaProceso}" var="listaProceso">
                                                    <option
                                                        value="<c:out value="${listaProceso.id_proceso}||${listaProceso.clave_proceso}||${listaProceso.descripcion}"> </c:out>"
                                                        ${ listaProceso.id_proceso==proceso ? 'selected="selected"' : ''}>
                                                        <c:out value="${listaProceso.clave_proceso}"></c:out>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>




                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Empresa</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm " id="empresa"
                                                            name="empresa" id="empresa">
                                                            <option value="">Selecciona una opcion</option>
                                                            <c:forEach items="${listaEmpresas}" var="lista">
                                                                <option
                                                                    value="<c:out value="${lista.razon_social}||${lista.id_empresa}"> </c:out>">
                                                                    <c:out value="${lista.clave_empresa}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                            
                                                 <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Tipo de
                                                        Movimiento</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm" name="tipo"
                                                            id="tipo">
                                                            <option value="" selected="selected">selecciona
                                                                una opcion</option>
                                                            <option value="CARGO,C" class="texto">Cuenta de
                                                                Cargo</option>
                                                            <option value="ABONO,A" class="texto">Cuenta de
                                                                Abono</option>



                                                        </select>
                                                    </div>
                                                </div>
                                            
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Proyecto</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" value="0000" name="proyecto" id="proyecto" 
                                                            class="text-right form-control form-control-sm"
                                                             />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Temporal</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="text-right form-control form-control-sm"
                                                            name="temporal" id="temporal" maxlength="3"/>
                                                    </div>
                                                </div>
                                               
                                            </div>
                                            <div class="col-sm-6 col-md-6 mt-2">
												<div class="form-group row">
                                    <label class="col-sm-4 col-form-label">Negocio</label>
                                    <div class="col-sm-8">
                                        <select class="form-control form-control-sm" name="id_negocio"
                                            id="id_negocio" >
                                            <option value="">Selecciona una opcion</option>
                                            <c:forEach items="${listaNegocios}" var="lista">
                                                <option
                                                    value="<c:out value="${lista.id_negocio}||${lista.clave}||${lista.descripcion}"> </c:out>"
                                                    ${ lista.id_negocio==negocio ? 'selected="selected"' : ''}>
                                                    <c:out value="${lista.clave}"></c:out>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>




                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Cuenta
                                                        Contable</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="form-control form-control-sm"
                                                            name="cuentacontable" id="cuentacontable"/>
                                                    </div>
                                                </div>
                                                
                                                <div class="form-poliza-cha form-group row">
                                                    <label class="col-sm-4 col-form-label">Descripcion
                                                        Costos</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm "
                                                            id="listaDeCentro" name="id_centro">
                                                            <option value="">Selecciona una opcion</option>
                                                            <c:forEach items="${listaCentroCosto}" var="lista">
                                                                <option
                                                                    value="<c:out value="${lista.id_centro_costos}"> </c:out>"
                                                                    ${ lista.id_centro_costos==centro_costos ? 'selected="selected"' : ''}>
                                                                    <c:out value="${lista.clave_centro_costos}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Tipo de Producto</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm form-producto"
                                                            name="producto" id="producto">
                                                            <option value="" selected="selected">selecciona
                                                                una opcion</option>
                                                            <option value="00000" class="texto">00000</option>
                                                            <option value="FUENTE" class="texto">Fuente</option>
                                                            <option value="SER" class="texto">Servicio</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                 <div class="form-fuente-cha form-group row d-none">
                                                    <label class="col-sm-4 col-form-label">Descripcion
                                                        Fuente</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm "
                                                            id="listaDeFuentes" name="id_fuete">
                                                            <option value="">Selecciona una opcion</option>
                                                            <c:forEach items="${listaFuentes}" var="lista">
                                                                <option
                                                                    value="<c:out value="${lista.id_fuente}"> </c:out>"
                                                                    ${ lista.id_fuente==fuente ? 'selected="selected"' : ''}>
                                                                    <c:out value="${lista.clave}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                </div>


                                                 <div class="form-servicio-cha form-group row d-none">
                                                    <label class="col-sm-4 col-form-label">Descripcion
                                                        Servicio</label>
                                                    <div class="col-sm-8">
                                                        <select class="form-control form-control-sm "
                                                            id="listaDeServicios" name="id_servicio">
                                                            <option value="">Selecciona una opcion</option>
                                                            <c:forEach items="${listaServicio}" var="lista">
                                                                <option
                                                                    value="<c:out value="${lista.id_servicios}"> </c:out>"
                                                                    ${ lista.id_servicios==servicio ? 'selected="selected"' : ''}>
                                                                    <c:out value="${lista.clave}"></c:out></option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>

                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Descripcion</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="text-right form-control form-control-sm"
                                                            name="descripcion" id="descripcion" />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Importe</label>
                                                    <div class="col-sm-8">
                                                        <input type="text" class="text-right form-control form-control-sm"
                                                            name="importe" id="importe" />
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <div class="form-group col-md-12 d-flex flex-row-reverse ">
                                                        <input type="hidden" id="clave_r" name="clave" />
                                                        <button id="agregarTableRegistro" type="button"
                                                            class="btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto">Agregar
                                                            Modelo</button>
                                                        <button id="compro" type="submit"
                                                            class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
                                                        <button id="llenarMandar" type="button"
                                                            class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
                                                        <button id="Mandar" type="submit"
                                                            class="btn btn-secondary text-white btn-sm float-right d-none ml-3  mb-1 mt-auto"></button>
                                                        
                                                    </div>
                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                    <%-- menu 2 --%>
                                    <%-- menu 2 --%>
                                    <%-- menu 2 --%>
                                </div>

                            </div>
                            <%-- submit --%>
                            <%-- submit --%>
                            <div class="col-md-12 mb-2">

                                <div class="card mt-2">
                                    <div class="table-responsive">
                                        <table
                                            class="table table-scroll table-striped table-bordered table-hover">
                                            <thead>
                                                <tr>
                                                    <th>No. de Registro Contable</th>
                                                    <th>Clave Proceso</th>
                                                    <th>Descripcion Proceso</th>
                                                    <th>Clave Negocio</th>
                                                    <th>Descripcion Negocio</th>
                                                    <th>Clave Cliente</th>
                                                    <th>Descripcion Cliente</th>
                                                    <th>Empresa</th>
                                                    <th>Cuenta Contable</th>
                                                    <th>Centro de Costos</th>
                                                    <th>Tipo de Movimiento</th>
                                                    <th>Proyecto</th>
                                                    <th>Producto</th>
                                                    <th>Temporal</th>
                                                    <th>Descripcion</th>
                                                    <th>Importe</th>
                                                    <th>Marcar</th>
                                                </tr>
                                            </thead>
                                            <tbody id="tableBody">
                                            	<c:set var="total" value="${0}"></c:set>
                                                <c:forEach items="${consultaRegistros}" var="lista">
                                                    <c:set var="total" value="${total+1}"></c:set>
                                                    <tr id="idTable${total}">
                                                        <td><c:out value="${lista.id_registro}"></c:out></td>
                                                        <td><c:out value="${lista.clave_proceso}"></c:out></td>
                                                        <td><c:out value="${lista.descripcion_proceso}"></c:out></td>
                                                        <td><c:out value="${lista.clave}"></c:out></td>
                                                        <td><c:out value="${lista.descripcion_negocio}"></c:out></td>
                                                        <td><c:out value="${lista.clave_cliente}"></c:out></td>
                                                        <td><c:out value="${lista.nombre_corto}"></c:out></td>
                                                        <td><c:out value="${lista.razon_social}"></c:out></td>
                                                        <td><c:out value="${lista.numero_cuenta_contable}"></c:out></td>
                                                        <td><c:out value="${lista.codigo_centro_costos}"></c:out></td>
                                                        <td>${ lista.tipo_movimiento eq 'C' ? 'CARGO' : 'ABONO'}</td>
                                                        <td><c:out value="${lista.proyecto}"></c:out></td>
                                                        <td><c:out value="${lista.producto}"></c:out></td>
                                                        <td><c:out value="${lista.temporal}"></c:out></td>
                                                        <td><c:out value="${lista.descripcion_registro}"></c:out></td>
                                                        <td id="tableimporte"><input id="inputimporte" type="text" class="d-none" value="${lista.importe}||${lista.tipo_movimiento}">
                                                        <input type="text" id="inputidTable${total}"  ${ estatus eq 'ENV' ? 'readonly="readonly"' : ''} name="idTable${total}" class="sif-width-150 form-importe text-center form-control form-control-sm" 
                                                        value="<fmt:formatNumber type = "number" maxFractionDigits = "4" value = "${lista.importe}" />">
                                                        </td>
                                                        <td><div class="form-check">
													<input class="form-check-input form-check-input-lleno llenos position-static"
														type="checkbox" 
														value="si,idTable${total},${lista.id_registro},${lista.id_proceso},${lista.id_negocio},${lista.id_cliente},${lista.id_empresa},${lista.numero_cuenta_contable},${lista.codigo_centro_costos},${lista.tipo_movimiento},${lista.proyecto},${lista.producto},${lista.temporal},${lista.descripcion_registro},${lista.importe}">
												</div></td>
                                                    </tr>
                                                </c:forEach>


                                            </tbody>
                                        </table>
                                    </div>
                                </div>


                                <div class="card-body">
                                        <div class="row">
                                                <label class="col-sm-12 col-form-label">Tabla de Totales</label>
                                            <div class="col-sm-6 col-md-6 mt-2">
                                                
                                                
                                                    
                                                
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Total de Cargo</label>
                                                    <div class="col-sm-8">
                                                        <label id="cargosum" class="col-form-label"></label>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Diferencia</label>
                                                    <div class="col-sm-8">
                                                        <label id="dif" class="col-form-label"></label>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-sm-6 col-md-6 mt-2">
                                                <div class="form-group row">
                                                    <label class="col-sm-4 col-form-label">Total de Abono </label>
                                                    <div class="col-sm-8">
                                                        <label id="abonosum" class="col-form-label"></label>
                                                    </div>
                                                </div>
                                                
                                            </div>
                                        </div>
                                    </div>

                            


                            </div>

                            <div class="col-md-12">
                                <button name="act" type="button"
                                    class="btnacteli btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto ${ estatus eq 'ENV' ? 'd-none' : ''}">Actualizar</button>
                                <button name="eli" type="button"
                                    class="btnacteli btn btn-secondary text-white btn-sm float-right ml-3  mb-1 mt-auto ${ estatus eq 'ENV' ? 'd-none' : ''}">Eliminar</button>
                                <input type="hidden" id="checkval" name="checkval" />
                                <input id=evento name="evento" type="hidden" />
                                <button id="Mandar" type="submit"
                                    class="btn btn-secondary text-white btn-sm float-right ml-3 d-none mb-1 mt-auto"></button>
                            </div>
                            <%-- submit --%>
                            <%-- submit --%>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </sf:form>
    </c:if>
    <%-- EDIT --%>
    <%-- etiquetas unicas --%>
</div>
<%@ include file="../layout/footer.jsp"%>