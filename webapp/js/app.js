jQuery(document)
		.ready(
				function() {

					jQuery(".confirm").on("click", function() {
						return confirm("delete");
					});
					$(function() {
						$(".bienvenido").typed({
							strings : [ "Bienvenido a <b>SILFAC</b>." ],
							typeSpeed : 20,
							backDelay : 1000,
							loop : false,
							loopCount : true,
							startDelay : 900
						});
					});
					window.sr = ScrollReveal();
					var once = {
						delay : 50,
						origin : 'left',
						scale : 1,
						duration : 800
					};
					var delay = {
						delay : 150,
						origin : 'left',
						scale : 1,
						duration : 900
					};
					var maxdelay = {
						delay : 1800,
						origin : 'left',
						scale : 1,
						duration : 800
					};
					if (sr.isSupported()) {
						sr.reveal('.reveal', once);
						sr.reveal('.reveal-delay', delay);
						sr.reveal('.reveal-maxdelay', maxdelay);
					}
					;

					$('#menu-toggle').on('click', function() {
						$('.sidebar').toggleClass('active');
						if ($('.sidebar').hasClass('active')) {
							$('.ml-sm-auto').removeClass('col-lg-10');
							$('.ml-sm-auto').addClass('col-lg-12');
						} else {
							$('.ml-sm-auto').addClass('col-lg-10');
							$('.ml-sm-auto').removeClass('col-lg-12');
						}
					});

					$('#tabGenerales').collapse('show');
					if ($('#list_Fuentes').val() == '') {
						$('#list_Fuentes_r').addClass('d-none');
					}
					if ($('#list_Servicios').val() == '') {
						$('#list_Servicios_r').addClass('d-none');
					}
					if ($('#list_Grupo_Concepto').val() == '') {
						$('#list_Grupo_Concepto_r').addClass('d-none');
					}
					if ($('#list_Fuentes_Servicios').val() == '') {
						$('#list_Fuentes_Servicios_r').addClass('d-none');
					}
					if ($('#conv_entrada').is(':checked')) {

						$("#select_fuente").prop("disabled", false);
						$("#select_sistema").prop("disabled", true);
						$("#select_fuente").prop("required", true);
						$("#select_sistema").prop("required", false);

					}

					// PRIMERA OPCION DE SELECTS
					$('#list_Clientes_r')
							.append(
									':	<option value="0">Selecciona una opcion</option>');
					// DISABLE INPUTS
					if ($("#validate_envio").length) {
						var v_envio = $("#validate_envio").val();
					}
					if (v_envio == 'NO') {
						$("#validate_auto_envio").prop("disabled", true);
					} else {
						$("#validate_auto_envio").prop("disabled", false);
					}
					$("#validate_envio").change(function() {
						var v_envio = $("#validate_envio").val();
						if (v_envio == "NO") {
							$("#validate_auto_envio").prop("disabled", true);
						} else {
							$("#validate_auto_envio").prop("disabled", false);
						}
					});
					if ($("#validate_reg_cont").length) {
						var v_reg_cont = $("#validate_reg_cont").val();
					}
					if (v_reg_cont == 'NO') {
						$("#validate_auto_reg_cont").prop("disabled", true);
					} else {
						$("#validate_auto_reg_cont").prop("disabled", false);
					}
					$("#validate_reg_cont").change(
							function() {
								var v_reg_cont = $("#validate_reg_cont").val();
								if (v_reg_cont == "NO") {
									$("#validate_auto_reg_cont").prop(
											"disabled", true);
								} else {
									$("#validate_auto_reg_cont").prop(
											"disabled", false);
								}
							});
					if ($("#validate_periodicidad").length) {
						var v_periodicidad = $("#validate_periodicidad").val();
					}
					if (v_periodicidad !== 'EVE') {
						$("#validate_dias_habiles").prop("disabled", true);
					} else {
						$("#validate_dias_habiles").prop("disabled", false);
					}
					$("#validate_periodicidad")
							.change(
									function() {
										var v_periodicidad = $(
												"#validate_periodicidad").val();
										if (v_periodicidad !== 'EVE') {
											$("#validate_dias_habiles").prop(
													"disabled", true);
											var original = $(
													"#validate_dias_habiles")
													.attr('defaultValue');
											$("#validate_dias_habiles").val(
													original);
										} else {
											$("#validate_dias_habiles").prop(
													"disabled", false);
										}
									});

				});

var globalTimeout = null;
$(".ajax-form-negocio")
		.change(
				function() {
					var valor = this.value;
					var inputName = this.name;
					console.log(inputName);
					var requestParam = null;
					var subSelect = null;
					var mainSelect = "#" + inputName + "_r";
					if (globalTimeout != null) {
						clearTimeout(globalTimeout);
					}
					globalTimeout = setTimeout(
							function() {
								globalTimeout = null;
								switch (inputName) {
								case "proceso":
									requestParam = "/home/list/json/proceso";
									mainSelect = "#id_negocio";
									subSelect = "#id_negocio";
									break;
								default:
									break;
								}
								var path = $("#path").val();
								var lista = $("#" + inputName).val();
								var url = path + requestParam;
								$
										.ajax({
											url : url,
											data : {
												term : valor
											},
											success : function(data) {
												$(mainSelect).empty();
												$(mainSelect)
														.append(
																':	<option value="0">Selecciona una opcion</option>');
												$
														.each(
																data,
																function(index,
																		element) {
																	$(
																			mainSelect)
																			.append(
																					index,
																					':<option value="'
																							+ index
																							+ '">'
																							+ element
																							+ '</option>');
																});
											}
										});

							}, 400);

				});

$(".ajax-form")
		.keyup(
				function() {
					var inputName = this.name;
					var requestParam = null;
					var subSelect = null;
					var mainSelect = "#" + inputName + "_r";
					if (globalTimeout != null) {
						clearTimeout(globalTimeout);
					}
					globalTimeout = setTimeout(
							function() {
								globalTimeout = null;
								switch (inputName) {
								case "list_Clientes":
									requestParam = "/home/list/json/cliente";
									subSelect = "#listaDeClientes"
									break;
								case "list_Clientes_report":
									requestParam = "/home/list/json/cliente/report";
									subSelect = "#listaDeClientes";
									break;
								case "list_Fuentes":
									requestParam = "/home/list/json/fuentes";
									subSelect = "#listaDeFuentes";
									break;
								case "list_Servicios":
									requestParam = "/home/list/json/servicios";
									subSelect = "#listaDeServicios";
									break;
								case "list_Fuentes_Servicios":
									requestParam = "/home/list/json/fuentes";
									subSelect = "#listaDeFuentesServicios";
									break;
								case "list_Grupo_Concepto":
									requestParam = "/home/list/json/grupoConcepto";
									subSelect = "#listaDeGrupoConcepto";
									break;
								case "list_Polizas":
									requestParam = "/home/list/json/polizas";
									subSelect = "#listaDePolizas";
									break;
								case "list_Centro":
									requestParam = "/home/list/json/centro";
									subSelect = "#listaDeCentro";
									break;
								case "list_Negocios":
									requestParam = "/home/list/json/negocio";
									subSelect = "#listaDeNegocios";
									break;
								default:
									break;
								}
								var path = $("#path").val();
								var lista = $("#" + inputName).val();
								$("#" + inputName).val(
										$("#" + inputName).val().toUpperCase());
								if (lista.length < 1) {
									$(mainSelect).addClass('d-none');
									$(subSelect).removeClass('d-none');
									$(mainSelect).empty();
									$(mainSelect)
											.append(
													':	<option value="">Selecciona una opcion</option>');
								} else {
									console.log(mainSelect);
									$(mainSelect).removeClass('d-none');
									$(subSelect).addClass('d-none');
									var url = path + requestParam;
									$.ajax({
										url : url,
										data : {
											term : $("#" + inputName).val()
										},
										success : function(data) {
											$(mainSelect).empty();
											$.each(data, function(index,
													element) {
												$(mainSelect).append(
														index,
														':<option value="'
																+ index + '">'
																+ element
																+ '</option>');
											});
										}
									});
								}
							}, 400);
				});

$(".changelogic").change(function() {
	var inputName = this.name;
	var mainSelect = "#" + inputName + "_r";
	var mainSelect1 = "#" + inputName;
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		globalTimeout = null;
		switch (inputName) {
		case "clave":
			$(mainSelect).val($(mainSelect1).val());
			break;
		default:
			break;
		}

	}, 400);
});

$('#dir_nacional').click(function() {
	if ($('#dir_nacional').is(':checked')) {
		$("#dir_internacional").prop("checked", false);
		$("#dir_cp").prop("disabled", false);
		$("#dir_colonia").prop("disabled", false);
		$("#dir_estado").prop("disabled", false);
		$("#dir_delegacion").prop("disabled", false);

	} else {
		$("#dir_internacional").prop("checked", true);
		$("#dir_cp").prop("disabled", true);
		$("#dir_colonia").prop("disabled", true);
		$("#dir_estado").prop("disabled", true);
		$("#dir_delegacion").prop("disabled", true);
	}
});
$('#dir_internacional').click(function() {
	if ($('#dir_internacional').is(':checked')) {
		$("#dir_nacional").prop("checked", false);
		$("#dir_cp").prop("disabled", true);
		$("#dir_colonia").prop("disabled", true);
		$("#dir_estado").prop("disabled", true);
		$("#dir_delegacion").prop("disabled", true);
	} else {
		$("#dir_nacional").prop("checked", true);
		$("#dir_cp").prop("disabled", false);
		$("#dir_colonia").prop("disabled", false);
		$("#dir_estado").prop("disabled", false);
		$("#dir_delegacion").prop("disabled", false);
	}
});
$('#conv_entrada').click(function() {
	if ($('#conv_entrada').is(':checked')) {
		$("#conv_salida").prop("checked", false);
		$("#select_fuente").prop("disabled", false);
		$("#select_sistema").prop("disabled", true);
		$("#select_fuente").prop("required", true);
		$("#select_sistema").prop("required", false);
	} else {
		$("#conv_salida").prop("checked", true);
		$("#select_fuente").prop("disabled", true);
		$("#select_sistema").prop("disabled", false);
		$("#select_fuente").prop("required", false);
		$("#select_sistema").prop("required", true);
	}
});
$('#conv_salida').click(function() {
	if ($('#conv_salida').is(':checked')) {
		$("#conv_entrada").prop("checked", false);
		$("#select_fuente").prop("disabled", true);
		$("#select_sistema").prop("disabled", false);
		$("#select_fuente").prop("required", false);
		$("#select_sistema").prop("required", true);
	} else {
		$("#conv_entrada").prop("checked", true);
		$("#select_fuente").prop("disabled", false);
		$("#select_sistema").prop("disabled", true);
		$("#select_fuente").prop("required", true);
		$("#select_sistema").prop("required", false);
	}
});
$('#general').collapse('show');
$('.tab-link').click(function() {
	var tab = $(this).attr('aria-controls');
	$('.collapse').collapse('hide');

	if (!$('#mainMenu').is(':visible')) {
		$('#btn-ocultar').click();
	}
	$('#' + tab).on('shown.bs.collapse', function(e) {

		e.preventDefault();
	});

});

$(".just-number").keydown(function(event) {

	if ((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)
			|| (event.keyCode == 16)|| (event.keyCode == 8)|| (event.keyCode == 36)|| (event.keyCode == 35)
			|| (event.keyCode == 37)|| (event.keyCode == 39)) {
//cuando escriben del 0 al 9
	} else {

		if (event.keyCode < 48 || event.keyCode > 57) {
			event.preventDefault();
		}
	}
});

$(".select_cuentas_contables").change(function() {
	var id = $(this).children(":selected").attr("id");
	$('.input_numero_cuenta').val(id);
});

$(".descripcion_servicio").change(function() {
	var id = $(this).children(":selected").attr("id");
	$('.input_descripcion').val(id);
});

$('#btn-ocultar').click(function() {
	if ($('#mainMenu').is(':visible')) {
		$("#mainMenu").hide();
		$("#btn-ocultar").text('Mostrar');
	} else {
		$("#mainMenu").show();
		$("#btn-ocultar").text('Ocultar');
	}
});
var i = 1;
$('.btnAppendConceptos')
		.click(
				function(e) {

					var cantidad = $('#cantidad').val();
					var unidad = $('#unidad').val();
					var claveUnidad = $('#claveUnidad').val();
					var claveServicio = $('#claveServicio').val();
					var servPart = $('#servPart').val();
					var catIngreso = $('#catIngreso').val();
					var concepto = $('#concepto').val();
					var costoUnitario = $('#costoUnitario').val();
					var importe = $('#importe').val();
					var descuento = $('#descuento').val();
					var impuesto = $('#impuesto').val();
					var factor = $('#factor').val();
					var tasa = $('#tasa').val();
					$('#appendConceptos')
							.append(
									'<tr id="tr'
											+ i
											+ '"><input type="hidden"  class="arraySolicitar" value="'
											+ cantidad
											+ ','
											+ claveUnidad
											+ ','
											+ claveServicio
											+ ','
											+ servPart
											+ ','
											+ catIngreso
											+ ','
											+ concepto
											+ ','
											+ costoUnitario
											+ ','
											+ importe
											+ ','
											+ descuento
											+ ','
											+ impuesto
											+ ','
											+ factor
											+ ','
											+ tasa
											+ '"/>'
											+ '<td>'
											+ cantidad
											+ '</td>'
											+ '<td>'
											+ unidad
											+ '</td>'
											+ '<td>'
											+ claveUnidad
											+ '</td>'
											+ '<td>'
											+ claveServicio
											+ '</td>'
											+ '<td>'
											+ servPart
											+ '</td>'
											+ '<td>'
											+ catIngreso
											+ '</td>'
											+ '<td>'
											+ concepto
											+ '</td>'
											+ '<td>'
											+ costoUnitario
											+ '</td>'
											+ '<td>'
											+ importe
											+ '</td>'
											+ '<td>'
											+ descuento
											+ '</td>'
											+ '<td>'
											+ impuesto
											+ '</td>'
											+ '<td>'
											+ factor
											+ '</td>'
											+ '<td>'
											+ tasa
											+ '</td>'
											+ '<td><button type="button" class="btnRemoveConceptos" id="tr'
											+ i + '">Clic</button></td>'
											+ '</tr>');
					i++;

					var a = $(".arraySolicitar").map(function() {

						return $(this).val();
					}).get().join("||");
					$(".table-hide").removeClass("d-none");
					console.log(a);

				});

$(document).on('click', '.btnRemoveConceptos', function() {
	var td = $(this).attr('id');
	$("tr").remove("#" + td);
	var a = $(".arraySolicitar").map(function() {
		return $(this).val();
	}).get().join("||");

	if (a == "") {

		$(".table-hide").addClass("d-none");
	}
	console.log(a);
});
jQuery(".contenedor-menu").hover(function() {
	jQuery(".col-md-10").css('filter', 'blur(5px)');
}, function() {
	jQuery(".col-md-10").css('filter', 'blur(0px)');
});
$(document).on('click', '#llenarMandar', function() {
	var lista = $(".form-check-input:checked").map(function() {
		return this.value;
	}).get().join("||");
	$("#checkval").val(lista);
	setTimeout(function() {
		$('#Mandar').trigger('click');
	}, 1000);

});
jQuery(".btnEvento").on(
		"click",
		function() {
			$("#variables").val($(".form-check-input:checked").map(function() {
				return this.value;
			}).get().join("||"));
			$(".inputEvento").val($(this).attr("id"));
			alertify.confirm('Ejecutar Proceso', '¿Desea ejecutar el proceso?',
					function() {
						alertify.success('Ejecutando proceso');
						setTimeout(function() {
							$('#btnEjecutar').trigger('click');
						}, 400);
					}, function() {
						alertify.error('Proceso cancelado', 2);
					});
		});

jQuery(".btnSeleccionMultipleCheckBox").click(function(event) {
	console.log($(".form-check-input:checked").map(function() {
		return this.value;
	}).get().join("||")

	);
	$(".resultadoSeleccion").val($(".form-check-input:checked").map(function() {
		return this.value;
	}).get().join("||"));
	setTimeout(function() {
		$('.btn-hide').trigger('click');
	}, 500);
});

$(".btnAppendServicios").click(function(event) {
	var i = 0;
	var mensaje = "";
	$(".getColumn").each(function() {
		i++;
		var valColum = $(this).val();

		if (i == 9) {
			mensaje = mensaje + valColum + "||";
			i = 0

		} else {
			mensaje = mensaje + valColum + ",";
		}

		$(".sendTable").val(mensaje);
		setTimeout(function() {
			$('.btn-hide').trigger('click');
		}, 500);

	});

});


$(".btnCalendario").click(function() {
	var mensaje = "";
	$(".formCalendario").each(function() {
		if($(this).prop('checked')){
			mensaje=mensaje+"0||"
		}else{
			mensaje=mensaje+"1||"
		}
		$("#bandera").val(mensaje);
	});
});


$(".botonArray").click(function() {

	var variables = "";
	var fecha;
	variables += $("#id_moneda").val() + "#";
	var moneda = $("#id_moneda").val();
	var periodo = $("#id_periodo").val();
	$("table tbody tr").each(function(index) {

		$(this).children("td").each(function(index2) {
			switch (index2) {
			case 0:
				fecha = $(this).text();
				textoseparado = fecha.split("-");
				variables += textoseparado[0] + ",";
				break;
			case 1:
				variables += $(this).children("input").val() + "#";
				break;

			}

		});

	});
	var requestParam = "/home/cobranzadiaria/tiposcambio/guardar";
	var path = $("#path").val();
	var url = path + requestParam;
	$.ajax({
		url : url,
		data : {
			term : variables,
			peri : periodo,
			mone : moneda
		},
		success : function(data) {
			$('#btnDir').trigger('click');
		}
	});
});

$("#btnAsignar")
		.click(
				function(event) {
					var mensaje = "";
					$(".getColumn").each(function() {
						i++;
						var valColum = $(this).text();
						mensaje = mensaje + valColum + "||";
					});

					var texto = $("#list_Servicios_r option:selected").text();
					var valor = $("#list_Servicios_r option:selected").val();
					var textoCliente = $("#list_Clientes_r option:selected")
							.text();
					var valorCliente = $("#list_Clientes_r option:selected")
							.val();
					var listaUsuario = $("#listaUsuario").val().toUpperCase();
					var dividirString = texto.split('-');
					var dividirStringCliente = textoCliente.split('-');
					var fecha = new Date().toLocaleDateString();
					var clave = dividirString[0].toUpperCase();
					var claveCliente = dividirStringCliente[0].toUpperCase();
					var buscar = mensaje.toUpperCase();
					var buscarCliente = mensaje.toUpperCase();
					clave = clave.replace(/\s+/g, '');
					claveCliente = claveCliente.replace(/\s+/g, '');
					if (buscar.indexOf(clave) != -1) {
						console.log(clave + 'encontrada');
					} else {
						console.log(clave + '   ' + buscar);
						$('#tablaAsignacion')
								.append(
										':<tr><td class="getColumn">'
												+ dividirString[0]
												+ '</td><td>'
												+ dividirString[1]
												+ '</td><td>'
												+ fecha
												+ '</td><td>'
												+ listaUsuario
												+ '</td><td></td><td><div class="form-check"><input class="form-check-input form-check-input-incluir position-static" value="'
												+ valor
												+ '" type="checkbox" checked="checked"></div></td></tr>');
					}

					if (buscarCliente.indexOf(claveCliente) != -1) {
						console.log(claveCliente + 'encontrada');
					} else {
						console.log(claveCliente + '   ' + buscarCliente);
						$('#tablaAsignacion')
								.append(
										':<tr><td class="getColumn">'
												+ dividirStringCliente[0]
												+ '</td><td>'
												+ dividirStringCliente[1]
												+ '</td><td>'
												+ fecha
												+ '</td><td>'
												+ listaUsuario
												+ '</td><td></td><td><div class="form-check"><input class="form-check-input form-check-input-incluir position-static" value="'
												+ valorCliente
												+ '" type="checkbox" checked="checked"></div></td></tr>');
					}

				});

jQuery("#btnGuardarTodo").click(
		function(event) {
			$("#listaServiciosExluidos").val(
					$(".form-check-input-excluir:checked").map(function() {
						return this.value;
					}).get().join("||"));
			$("#listaServiciosIncluidos").val(
					$(".form-check-input-incluir:checked").map(function() {
						return this.value;
					}).get().join("||"));

			$("#listaBeneficiarios").val(
					$(".form-check-input-beneficiario:checked").map(function() {
						return this.value;
					}).get().join("||"));

			var contador = 0;
			var mensajeDistribucion = "";
			$(".getDistribucion").each(function() {
				if ($(this).val().length == 0) {
					$(this).val(0);
				}
			});
			$(".getDistribucion").each(
					function() {
						contador++;
						var valDistribucion = $(this).val();
						var idDistribucion = $(this).attr('id');
						if (contador == 1) {
							mensajeDistribucion = mensajeDistribucion
									+ valDistribucion + "," + idDistribucion
									+ "||";
							contador = 0

						}
					});
			$("#listaDistribucion").val(mensajeDistribucion);

			setTimeout(function() {
				$('#btnEjecutar').trigger('click');
			}, 1000);
		});

$("#btnAsignarLista")
		.click(
				function(event) {
					var mensaje = "";
					$(".getColumn").each(function() {
						i++;
						var valColum = $(this).text();
						mensaje = mensaje + valColum + "||";
					});

					var textoCliente = $("#list_Clientes_r option:selected")
							.text();
					var valorCliente = $("#list_Clientes_r option:selected")
							.val();
					var listaUsuario = $("#listaUsuario").val().toUpperCase();

					var dividirStringCliente = textoCliente.split('-');
					var fecha = new Date().toLocaleDateString();

					var claveCliente = dividirStringCliente[0].toUpperCase();

					var buscarCliente = mensaje.toUpperCase();

					claveCliente = claveCliente.replace(/\s+/g, '');

					if (buscarCliente.indexOf(claveCliente) != -1) {
						console.log(claveCliente + 'encontrada');
					} else {
						console.log(claveCliente + '   ' + buscarCliente);
						$('#tablaAsignacion')
								.append(
										':<tr><td class="getColumn">'
												+ dividirStringCliente[0]
												+ '</td><td>'
												+ dividirStringCliente[1]
												+ '</td><td>NO</td><td><input type="text" name="distribucion" class="getDistribucion" id="'
												+ valorCliente
												+ '" value="0"> </td><td>'
												+ fecha
												+ '</td><td><div class="form-check"><input class="form-check-input form-check-input-beneficiario position-static" value="'
												+ valorCliente
												+ '" type="checkbox"></div></td><td></td><td><div class="form-check"><input class="form-check-input form-check-input-incluir position-static" value="'
												+ valorCliente
												+ '" checked="checked" type="checkbox"></div></td></tr>');
					}

				});

$("#tipoPrecio").change(function() {
	var valor = $(this).children(":selected").val();
	if (valor == 0) {
		$(".inputClear").val('');
		$("#inputPrecio").prop('disabled', true);
		$("#inputVolumen").prop('disabled', true);
		$("#inputVolumenInicial").prop('disabled', true);
		$("#inputVolumenFinal").prop('disabled', true);
		$("#inputPrecioVolumen").prop('disabled', true);
		$("#btnAgregarPrecio").prop('disabled', true);

	}
	if (valor == 'FIJ' || valor == 'REN') {
		$(".inputClear").val('');
		$("#inputPrecio").prop('disabled', false);
		$("#inputVolumen").prop('disabled', true);
		$("#inputVolumenInicial").prop('disabled', true);
		$("#inputVolumenFinal").prop('disabled', true);
		$("#inputPrecioVolumen").prop('disabled', true);
		$("#btnAgregarPrecio").prop('disabled', true);

	}
	if (valor == 'VOL' || valor == 'ESC') {
		$(".inputClear").val('');
		$("#inputPrecio").prop('disabled', true);
		$("#inputVolumen").prop('disabled', true);
		$("#inputVolumenInicial").prop('disabled', false);
		$("#inputVolumenFinal").prop('disabled', false);
		$("#inputPrecioVolumen").prop('disabled', false);
		$("#btnAgregarPrecio").prop('disabled', false);
	}

	if (valor == 'PRO' || valor == 'MAX' || valor == 'MIN') {
		$(".inputClear").val('');
		$("#inputPrecio").prop('disabled', false);
		$("#inputVolumen").prop('disabled', false);
		$("#inputVolumenInicial").prop('disabled', false);
		$("#inputVolumenFinal").prop('disabled', false);
		$("#inputPrecioVolumen").prop('disabled', false);
		$("#btnAgregarPrecio").prop('disabled', false);
	}

});
if ($("#tipoPrecio").children(":selected").val() == 0) {
	$("#inputPrecio").prop('disabled', true);
	$("#inputVolumen").prop('disabled', true);
	$("#inputVolumenInicial").prop('disabled', true);
	$("#inputVolumenFinal").prop('disabled', true);
	$("#inputPrecioVolumen").prop('disabled', true);
	$("#btnAgregarPrecio").prop('disabled', true);
}

if ($("#tipoPrecio").children(":selected").val() == 'FIJ'
		|| $("#tipoPrecio").children(":selected").val() == 'REN') {
	$("#inputPrecio").prop('disabled', false);
	$("#inputVolumen").prop('disabled', true);
	$("#inputVolumenInicial").prop('disabled', true);
	$("#inputVolumenFinal").prop('disabled', true);
	$("#inputPrecioVolumen").prop('disabled', true);
	$("#btnAgregarPrecio").prop('disabled', true);

}
if ($("#tipoPrecio").children(":selected").val() == 'VOL'
		|| $("#tipoPrecio").children(":selected").val() == 'ESC') {
	$("#inputPrecio").prop('disabled', true);
	$("#inputVolumen").prop('disabled', true);
	$("#inputVolumenInicial").prop('disabled', false);
	$("#inputVolumenFinal").prop('disabled', false);
	$("#inputPrecioVolumen").prop('disabled', false);
	$("#btnAgregarPrecio").prop('disabled', false);
}

if ($("#tipoPrecio").children(":selected").val() == 'PRO'
		|| $("#tipoPrecio").children(":selected").val() == 'MAX'
		|| $("#tipoPrecio").children(":selected").val() == 'MIN') {
	$("#inputPrecio").prop('disabled', false);
	$("#inputVolumen").prop('disabled', false);
	$("#inputVolumenInicial").prop('disabled', false);
	$("#inputVolumenFinal").prop('disabled', false);
	$("#inputPrecioVolumen").prop('disabled', false);
	$("#btnAgregarPrecio").prop('disabled', false);
}

$("#btnDefinirPrecio").click(function(event) {
	setTimeout(function() {
		$('#btnHidden').trigger('click');
	}, 400);

});

$("#selectPrecioControlado").change(function() {
	var valor = $(this).children(":selected").val();
	if (valor == 0) {
		$("#btnDefinirPrecio").prop('disabled', true);
	}
	if (valor == 1) {
		$("#btnDefinirPrecio").prop('disabled', false);
	}
});
if ($("#selectPrecioControlado").children(":selected").val() == 0) {
	$("#btnDefinirPrecio").prop('disabled', true);

}

if ($("#selectPrecioControlado").children(":selected").val() == 1) {
	$("#btnDefinirPrecio").prop('disabled', false);
}

$("#btnProbar").click(function(event) {
	var valor = $("#sentencia").val();
	$("#nuevaSentencia").val(valor);

	setTimeout(function() {

		$('#enviarPrueba').trigger('click');
		console.log(lista);
	}, 400);
});

$("#btnVerificarPrecio").click(
		function(event) {
			var valor = $("#tipoPrecio").val();
			var inputPrecio = $("#inputPrecio").val();
			$("#listaPrecios").val(
					$(".form-check-input-precios:checked").map(function() {
						return this.value;
					}).get().join("||"));
			if (valor == 'FIJ' || valor == 'REN') {
				if (inputPrecio == '') {
					$("#inputPrecio").prop('required', true);
					$('#btnGuardarPrecio').trigger('click');
				} else {
					setTimeout(function() {
						$('#btnGuardarPrecio').trigger('click');
					}, 200);
				}

			}
			if (valor == 'VOL' || valor == 'ESC') {
				if ($("#listaPrecios").val() == '') {
					console.log("lista vacia");
				} else {
					setTimeout(function() {
						$('#btnGuardarPrecio').trigger('click');
					}, 200);
				}
			}
			if (valor == 'PRO' || valor == 'MAX' || valor == 'MIN') {
			}

		});
$("#btnAgregarPrecio")
		.click(
				function(event) {
					var valor = $("#tipoPrecio").val();
					var volumenInicial = $("#inputVolumenInicial").val();
					var volumenFinal = $("#inputVolumenFinal").val();
					var precioVolumen = $("#inputPrecioVolumen").val();
					if (volumenInicial == '') {
						volumenInicial = null;
					}
					if (volumenFinal == '') {
						volumenFinal = null;
					}
					if (precioVolumen == '') {
						$("#inputPrecioVolumen").prop('required', true);
					}

					if (valor == 'FIJ' || valor == 'REN') {
						console.log(valor);
					}
					if (valor == 'VOL' && precioVolumen !== ''
							|| valor == 'ESC' && precioVolumen !== '') {
						console.log(valor);
						$('#tablaRangoPrecio')
								.append(
										':<tr><td>'
												+ volumenInicial
												+ '</td><td>'
												+ volumenFinal
												+ '</td><td>'
												+ precioVolumen
												+ '</td><td><div class="form-check"><input class="form-check-input form-check-input-precios position-static d-none" checked="checked" type="checkbox" value="'
												+ volumenInicial
												+ ','
												+ volumenFinal
												+ ','
												+ precioVolumen
												+ '" /></div><button type="button" class="removebutton">Eliminar</button></td></tr>');
					}
					if (valor == 'PRO' || valor == 'MAX' || valor == 'MIN') {
						console.log(valor);
					}
				});
$(document).on('click', 'button.removebutton', function() {
	$(this).closest('tr').remove();
	return false;
});

$(".form-poliza").change(function() {
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		if ($(".form-poliza").val() == 'FIJO') {
			$(".form-poliza-cha").removeClass("d-none");
			$(".form-poliza-cha").prop("disabled", false);
		} else {
			$(".form-poliza-cha").prop("disabled", true);
			$(".form-poliza-cha").addClass("d-none");
		}
	}, 400);

});

$('#agregarTable').click(function() {
	var cuentaContable = $("#cuentaContable").val();
	var empresa = $("#empresa").val();
	var centroCostos = $("#centroCostos").val();
	if (cuentaContable == "") {
		$("#cuentaContable").prop("required", true);
		$('#compro').trigger('click');
	} else if (empresa == "") {
		$("#empresa").prop("required", true);
		$('#compro').trigger('click');

	} else if (centroCostos == "") {
		$("#centroCostos").prop("required", true);
		$('#compro').trigger('click');
	} else {
		if (centroCostos == "FIJO") {
			var lista = $("#listaDeCentro").val();
			if ($("#listaDeCentro").val() == "") {
				$("#listaDeCentro").prop("required", true);
				$('#compro').trigger('click');
			} else {
				tablePoliza(cuentaContable, empresa, centroCostos, lista);
			}
		} else {
			var lista = 0;
			tablePoliza(cuentaContable, empresa, centroCostos, lista);
		}
	}
});

function tablePoliza(cuentaContable, empresa, centroCostos, lista) {
	var proyecto = $("#proyecto").val();
	var producto = $("#producto").val();
	var tipo = $("#tipo").val();
	var temporal = $("#temporal").val();
	var descripcion = $("#descripcion").val();
	var desccosto = $("#desccosto").val();
	var tipo1 = "";
	var tipo2 = "";
	if (proyecto == "") {
		proyecto = "null";
	}
	if (producto == "") {
		producto = "null";
	}
	if (tipo == "") {
		var tipo1 = "null";
		var tipo2 = "null";
	}
	if (temporal == "") {
		temporal = "000";
	}
	if (descripcion == "") {
		descripcion = "null";
	}
	if (desccosto == "") {
		desccosto = "null";
	}
	var split1 = tipo.split(",");
	tipo1 = split1[0];
	tipo2 = split1[1];
	var split2 = empresa.split("||");
	var nFilas = $("#tableBody tr").length + 1;
	$('#tableBody')
			.append(
					':<tr><td>'
							+ nFilas
							+ '</td><td>'
							+ split2[0]
							+ '</td><td>'
							+ cuentaContable
							+ '</td><td>'
							+ centroCostos
							+ '</td><td id="tabletipo">'
							+ tipo1
							+ '</td><td>'
							+ proyecto
							+ '</td><td>'
							+ producto
							+ '</td><td>'
							+ temporal
							+ '</td><td>'
							+ descripcion
							+ '</td><td>'
							+ '<div class="form-check"><input class="form-check-input form-check-input-precios position-static d-none" checked="checked" type="checkbox" value="'
							+ nFilas + ',' + split2[1] + ',' + cuentaContable
							+ ',' + centroCostos + ',' + lista + ',' + tipo2
							+ ',' + proyecto + ',' + producto + ',' + temporal
							+ ',' + descripcion + ',' + desccosto
							+ '" /></div>' + desccosto);

}
$('#comparar')
		.click(
				function() {
					var variables = "";
					$('#tableBody #tabletipo').each(function() {
						// Obtengo el valor de dicho th
						var value = $(this).text();
						// Acá deberías hacer lo que quieras con ese valor
						// obtenido
						variables += value + ",";
					});
					if (variables.indexOf("CARGO") == -1
							&& variables.indexOf("ABONO") == -1) {
						alertify.error('Faltan los Modelos de Cargo y Abono',
								10);
					} else if (variables.indexOf("CARGO") == -1) {
						alertify.error('Falta Modelo de Cargo.', 10);
					} else if (variables.indexOf("ABONO") == -1) {
						alertify.error('Falta Modelo de Abono.', 10);
					} else {
						var clavePoliza = $("#clavePoliza").val();
						var tipopoli = $("#tipopoli").val();
						if (clavePoliza == "") {
							$("#clavePoliza").prop("required", true);
							$('#compro').trigger('click');
						} else if (tipopoli == "") {
							$("#tipopoli").prop("required", true);
							$('#compro').trigger('click');

						} else {
							var requestParam = "/home/registro/parametrizacion/comprobacion";
							var path = $("#path").val();
							var url = path + requestParam;
							$
									.ajax({
										url : url,
										data : {
											term : clavePoliza
										},
										success : function(data) {
											$
													.each(
															data,
															function(index,
																	element) {
																if (index == 1) {
																	alertify
																			.error(
																					'Esa Poliza ya se encuentra Registrada',
																					10);
																} else {
																	var lista = $(
																			".form-check-input:checked")
																			.map(
																					function() {
																						return this.value;
																					})
																			.get()
																			.join(
																					"||");
																	$(
																			"#checkval")
																			.val(
																					lista);
																	setTimeout(
																			function() {
																				$(
																						'#compro')
																						.trigger(
																								'click');
																			},
																			10000);
																}
															});
										}
									});

						}
					}
				});
$(".btnAplicacionPrecio").click(function(event) {
	var id_subconcepto = $(this).attr("id");
	var precio = $(this).val();

	console.log(id_subconcepto + " " + precio);
	$("#id_subconcepto").val(id_subconcepto);
	$("#id_precio").val(precio);
	setTimeout(function() {
		$('#btnHiddenAplicacionesPrecio').trigger('click');
	}, 400);

});

$(document).on('click', '.buttonreporte', function() {
	var botonid = $(this).attr("id");
	$("#tipo").val(botonid);
	setTimeout(function() {
		$('#reporte').trigger('click');
	}, 1000);

});

$(".globalGetReport").each(function() {
	var cleanIdReport = $(this).attr("id");
	var rowReporte = $("#" + cleanIdReport.replace('reporteParam', '')).val();
	$("#" + cleanIdReport).val(rowReporte);
});

$('.pasar').click(function() {
	return !$('#origen option:selected').remove().appendTo('#destino');
});
$('.quitar').click(function() {
	return !$('#destino option:selected').remove().appendTo('#origen');
});
$('.pasartodos').click(function() {
	$('#origen option').each(function() {
		$(this).remove().appendTo('#destino');
	});
});
$('.quitartodos').click(function() {
	$('#destino option').each(function() {
		$(this).remove().appendTo('#origen');
	});
});
$(document).on('click', '#Asociar', function() {
	var lista = $("#destino option").map(function() {
		return this.value;
	}).get().join("||");
	console.log(lista);
	$("#newaso").val(lista);
	setTimeout(function() {
		$('#AsociarMandar').trigger('click');
		console.log(lista);
	}, 1000);

});

$(".form-producto").change(function() {
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		if ($(".form-producto").val() == 'FUENTE') {
			$(".form-fuente-cha").removeClass("d-none");
			$(".form-fuente-cha").prop("disabled", false);
			$(".form-servicio-cha").prop("disabled", true);
			$(".form-servicio-cha").addClass("d-none");
		} else if ($(".form-producto").val() == 'SER') {
			$(".form-servicio-cha").prop("disabled", false);
			$(".form-servicio-cha").removeClass("d-none");
			$(".form-fuente-cha").addClass("d-none");
			$(".form-fuente-cha").prop("disabled", true);
		} else {
			$(".form-servicio-cha").prop("disabled", true);
			$(".form-servicio-cha").addClass("d-none");
			$(".form-fuente-cha").addClass("d-none");
			$(".form-fuente-cha").prop("disabled", true);
		}
	}, 400);

});

function cargoabono() {
	var sumaabono = 0;
	var sumacargo = 0;
	var diferencia = 0;
	$('#tableBody #tableimporte #inputimporte').each(function() {
		var value = $(this).val();
		var split = value.split("||");
		if (split[1].indexOf("C") != -1) {
			sumacargo += parseFloat(split[0]);
		} else {
			sumaabono += parseFloat(split[0]);
		}
	});
	diferencia = sumacargo - sumaabono;
	var sumaabono = accounting.formatMoney(sumaabono, "", 2, ",", ".");
	var sumacargo = accounting.formatMoney(sumacargo, "", 2, ",", ".");
	var diferencia = accounting.formatMoney(diferencia, "", 2, ",", ".");
	$('#abonosum').text(sumaabono);
	$('#cargosum').text(sumacargo);
	$('#dif').text(diferencia);
}

cargoabono();

$('#agregarTableRegistro')
		.click(
				function() {
					var negocio = $("#id_negocio").val();
					var cuentacontable = $("#cuentacontable").val();
					var empresa = $("#empresa").val();
					var centroCostos = $("#listaDeCentro").val();
					var tipo = $("#tipo").val();
					var descripcion = $("#descripcion").val();
					var importe = $("#importe").val();
					if (negocio == "") {
						$("#id_negocio").prop("required", true);
						$('#compro').trigger('click');
					} else if (cuentacontable == "") {
						$("#cuentacontable").prop("required", true);
						$('#compro').trigger('click');

					} else if (centroCostos == "") {
						$("#listaDeCentro").prop("required", true);
						$('#compro').trigger('click');
					} else if (tipo == "") {
						$("#tipo").prop("required", true);
						$('#compro').trigger('click');
					} else if (descripcion == "") {
						$("#descripcion").prop("required", true);
						$('#compro').trigger('click');
					} else if (importe == "") {
						$("#importe").prop("required", true);
						$('#compro').trigger('click');
					} else if (empresa == "") {
						$("#empresa").prop("required", true);
						$('#compro').trigger('click');
					} else {
						var producto = $("#producto").val();
						if (producto == "FUENTE") {
							var producto = $("#listaDeFuentes").val();
							tableRegistro(empresa, negocio, cuentacontable,
									centroCostos, tipo, descripcion, importe,
									producto);
						} else if (producto == "SER") {
							var producto = $("#listaDeServicios").val();
							tableRegistro(empresa, negocio, cuentacontable,
									centroCostos, tipo, descripcion, importe,
									producto);
						} else {
							tableRegistro(empresa, negocio, cuentacontable,
									centroCostos, tipo, descripcion, importe,
									producto);
						}
					}
				});

function tableRegistro(empresa, negocio, cuentacontable, centroCostos, tipo,
		descripcion, importe, producto) {
	var cliente = $("#listaDeClientes").val();
	var proceso = $("#proceso").val();
	var proyecto = $("#proyecto").val();
	var temporal = $("#temporal").val();
	var tipo1 = "";
	var tipo2 = "";
	if (cliente == "") {
		cliente = "null";
	}
	if (proceso == "") {
		proceso = "null";
	}
	if (proyecto == "") {
		proyecto = "null";
	}
	if (temporal == "") {
		temporal = "000";
	}
	var split1 = tipo.split(",");
	tipo1 = split1[0];
	tipo2 = split1[1];
	var split2 = empresa.split("||");
	var split3 = proceso.split("||");
	var split4 = negocio.split("||");
	var split5 = cliente.split("||");
	var importe1 = accounting.formatMoney(importe, "", 2, ",", ".");
	var nFilas = $("#tableBody tr").length + 1;
	$('#tableBody')
			.append(
					':<tr id="idTable'
							+ nFilas
							+ '"><td>'
							+ '---'
							+ '</td><td>'
							+ split3[1]
							+ '</td><td>'
							+ split3[2]
							+ '</td><td>'
							+ split4[1]
							+ '</td><td>'
							+ split4[2]
							+ '</td><td>'
							+ split5[1]
							+ '</td><td>'
							+ split5[2]
							+ '</td><td>'
							+ split2[0]
							+ '</td><td>'
							+ cuentacontable
							+ '</td><td>'
							+ centroCostos
							+ '</td><td>'
							+ tipo1
							+ '</td><td>'
							+ proyecto
							+ '</td><td>'
							+ producto
							+ '</td><td>'
							+ temporal
							+ '</td><td>'
							+ descripcion
							+ '</td><td id="tableimporte"> <input id="inputimporte" type="text" class="d-none" value="'
							+ importe
							+ '||'
							+ tipo2
							+ '">'
							+ '<input type="text" id="inputidTable'
							+ nFilas
							+ '" name="idTable'
							+ nFilas
							+ '" class="form-importe text-center form-control form-control-sm" value="'
							+ importe1
							+ '">'
							+ '</td><td>'
							+ '<div class="form-check"><input class="form-check-input form-check-input-vacio form-check-input-precios position-static" checked="checked" type="checkbox" value="'
							+ 'no' + ',idTable' + nFilas + ',---,' + split3[0]
							+ ',' + split4[0] + ',' + split5[0] + ','
							+ split2[1] + ',' + cuentacontable + ','
							+ centroCostos + ',' + tipo2 + ',' + proyecto + ','
							+ producto + ',' + temporal + ',' + descripcion
							+ ',' + importe + '" /></div>');
	cargoabono();
}
$(document)
		.on(
				'click',
				'.btnacteli',
				function() {
					var button = this.name;
					if (button == "act") {
						var texto = $("#dif").text();
						if (texto != "0.00") {
							alertify
									.error(
											'Los cargos y abonos no concuerdan favor de verificar',
											4);
						} else {
							$('#evento').val('update');
							var lista = $(".form-check-input").map(function() {
								return this.value;
							}).get().join("||");
							$("#checkval").val(lista);
							setTimeout(function() {
								$('#compro').trigger('click');
							}, 1000);
						}

					} else {
						$('.form-check-input:checked').each(function() {
							var value = $(this).val();
							var split = value.split(",");
							var select = "#" + split[1];
							$(select).remove();
							cargoabono();
						});
					}

				});

$(".ajax-form-periodo").change(function() {
	var valor = this.value;
	var inputName = this.name;
	console.log(inputName);
	var requestParam = null;
	var subSelect = null;
	var mainSelect = "#" + inputName + "_r";
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		globalTimeout = null;
		switch (inputName) {
		case "id_periodo":
			requestParam = "/home/list/json/periodo";
			mainSelect = "#fecha_inicio";
			subSelect = "#fecha_final";
			break;
		default:
			break;
		}
		var path = $("#path").val();
		var lista = $("#" + inputName).val();
		var url = path + requestParam;
		$.ajax({
			url : url,
			data : {
				term : valor
			},
			success : function(data) {
				$(mainSelect).empty();
				$(subSelect).empty();

				$.each(data, function(index, element) {
					textoseparado = element.split(",");
					$(mainSelect).val(textoseparado[0]);
					$(subSelect).val(textoseparado[1]);
				});
			}
		});

	}, 400);

});

$(document).on(
		'keyup',
		'.form-importe',
		function() {
			var inputName = this.name;
			var o = $(this).val();
			var idin = "#input" + inputName;
			var var1 = o.replace(o.match("^0+(?!$)"), "");
			var formato = var1.replace(/[^\d.-]/g, '');
			var mainSelect = "#tableBody #" + inputName
					+ " #tableimporte #inputimporte";
			var input = $(mainSelect).val();
			var split = input.split("||");
			var newvar = formato + "||" + split[1];
			var importe1 = accounting.formatMoney(formato, "", 2, ",", ".");
			$(mainSelect).val(newvar);
			if (globalTimeout != null) {
				clearTimeout(globalTimeout);
			}
			globalTimeout = setTimeout(function() {
				var importe1 = accounting.formatMoney(o, "", 2, ",", ".");
				console.log(importe1);
				$(idin).val(importe1);
				globalTimeout = null;
				cargoabono();
			}, 400);
		});

$(document).on('keyup', '[type=date]', function() {
	var inputName = this.name;
	var o = $(this).val();
	var input = $(this);
	var caracteres = o.length;
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		console.log(o + "  " + parte1 + "  " + parte2);
		if (caracteres == 11) {
			var parte1 = o.substring(0, 4);
			var parte2 = o.substring(5, 11);
			$(input).removeAttr("type");
			$(input).val(parte1 + parte2);
			$(input).attr("type", "date");
		} else if (caracteres == 12) {

			var parte1 = o.substring(0, 4);
			var parte2 = o.substring(6, 12);
			$(input).removeAttr("type");
			$(input).val(parte1 + parte2);
			$(input).attr("type", "date");

		}
	}, 200);
});

$(".selectTab").click(function(event) {
	var tab = $(this).attr("id");
	if (tab == "tab-1") {
		$("#flag").val(0);
		$(".tabFuente").removeClass("d-none");
		$(".tabServicio").addClass("d-none");
	} else if (tab == "tab-2") {
		$("#flag").val(1);
		$(".tabFuente").addClass("d-none");
		$(".tabServicio").removeClass("d-none");
	}
});
$("#flag").each(function() {
	var evento = $(this).val();
	if (evento == 0) {
		setTimeout(function() {
			$('#tab-1').trigger('click');
		}, 200);
	}
	if (evento == 1) {
		setTimeout(function() {
			$('#tab-2').trigger('click');
		}, 200);
	}
});

$(document).on('click', '.btnMantener', function() {
	var inputName = this.name;
	if (inputName == "btnEli") {
		$("#opcion").val("eliminar");
		var lista = $(".form-check-input:checked").map(function() {
			return this.value;
		}).get().join("||");
		$("#datos").val(lista);
		setTimeout(function() {
			$('#btnGen').trigger('click');
			console.log("listooo ");
		}, 1000);

	} else if (inputName == "btnEnviar") {
		$("#opcion").val("enviar");
	} else {
		$("#opcion").val("reversar");
	}

});

$(document).on('click', '#consultar', function() {

	var valor = $('input:radio[name=radio_cuentas]:checked').val();
	if (valor == "consul") {

		$("#id_moneda").prop("required", false);
		$("#list_Clientes_report").prop("required", false);
		$("#fecha_aplic").prop("required", false);
	} else {
		$("#id_moneda").prop("required", true);
		$("#list_Clientes_report").prop("required", true);
		$("#fecha_aplic").prop("required", true);
	}
});

$(".botonSaldos").click(function() {

	var variables = "";

	$("#saldosCuentasTable tbody tr").each(function(index) {

		$(this).children("td").each(function(index2) {
			switch (index2) {
			case 0:
				variables += $(this).text() + ",";
				break;
			case 4:
				variables += $(this).text() + ",";
				break;
			case 6:
				variables += $(this).children("input").val() + ",";
				break;
			case 8:
				variables += $(this).text() + ",";
				break;
			case 9:
				variables += $(this).text() + ",";
				break;
			case 10:
				variables += $(this).text() + ",";
				break;
			case 11:
				variables += $(this).text() + ",";
				break;

			}

		});

	});
	var requestParam = "/home/cuentas/saldos/save";
	var path = $("#path").val();
	var url = path + requestParam;
	$.ajax({
		url : url,
		data : {
			term : variables
		},
		success : function(data) {
			$('#btnCuentas').trigger('click');
		}
	});
});
$(document).on('click', '.botonesenviar', function() {
	var inputName = this.name;
	
	if(inputName=="MandarDato")
	{
		var lista = $(".form-check-input:checked").map(function() {
			return this.value;
		}).get().join("||");
	}
	else{
		var lista = $(".form-check-input").map(function() {
			return this.value;
		}).get().join("||");
	}
	$("#checkval").val(lista);
	setTimeout(function() {
		$('#Mandar').trigger('click');
	}, 1000);
});

$(document).on('click', '.botonopcion', function() {
	var inputName = this.name;
	$("#tipo").val(inputName);
	setTimeout(function() {
		$('#opciones').trigger('click');
	}, 1000);

});

$(document).on(
		'click',
		'.form-check-input-obtener:checked',
		function() {
			// PARTE 1
			var checkId = $(this).attr('id');
			console.log(checkId);
			var valor = $(this).val();
			// var campo1 = $("#" + checkId + ' #campo1').val();
			// var campo2 = $("#" + checkId + ' #campo2').val();
			// var campo3 = $("#" + checkId + ' #campo3').val();
			var td0 = $("#" + checkId + ' #td0').val();
			var td1 = $("#" + checkId + ' #td1').val();
			var td2 = $("#" + checkId + ' #td2').val();
			var td3 = $("#" + checkId + ' #td3').val();
			var td4 = $("#" + checkId + ' #td4').val();
			var td5 = $("#" + checkId + ' #td5').val();
			var td6 = $("#" + checkId + ' #td6').val();
			var td7 = $("#" + checkId + ' #td7').val();
			var td8 = $("#" + checkId + ' #td8').val();
			var td9 = $("#" + checkId + ' #td9').val();
			var td10 = $("#" + checkId + ' #td10').val();
			var td11 = $("#" + checkId + ' #td11').val();
			var td12 = $("#" + checkId + ' #td12').val();
			var td13 = $("#" + checkId + ' #td13').val();
			var td14 = $("#" + checkId + ' #td14').val();
			var td15 = $("#" + checkId + ' #td15').val();
			var td16 = $("#" + checkId + ' #td16').val();
			var td17 = $("#" + checkId + ' #td17').val();
			var td18 = $("#" + checkId + ' #td18').val();
			var td19 = $("#" + checkId + ' #td19').val();
			var td20 = $("#" + checkId + ' #td20').val();
			var td21 = $("#" + checkId + ' #td21').val();
			var td23 = $("#" + checkId + ' #td23').val();
			var td24 = $("#" + checkId + ' #td24').val();
			$("#" + checkId + " #checkValue").val(
					valor + "," + td0 + "," + td1 + "," + td2 + "," + td3 + ","
							+ td4 + "," + td5 + "," + td6 + "," + td7 + ","
							+ td8 + "," + td9 + "," + td10 + "," + td11 + ","
							+ td12 + "," + td13 + "," + td14 + "," + td15 + ","
							+ td16 + "," + td17 + "," + td18 + "," + td19 + ","
							+ td20 + "," + td21 + " ," + td23 + "," + td24);
		});
// PARTE 2
$(document).on('click', '.form-check-input-obtener', function() {

	$("#mostrar").val($(".form-check-input-obtener:checked").map(function() {
		var checkId = $(this).attr('id');
		return $("#" + checkId + " #checkValue").val();
	}).get().join("||"));

});
// PARTE 3
$(document).on(
		'keyup',
		'#td17',
		function() {
			var checkId = $(this).closest('tr').attr('id');
			var valor = $("#" + checkId + ' .form-check-input-obtener').val();
			// var campo1 = $(this).val();
			// var campo2 = $("#" + checkId + ' #campo2').val();
			// var campo3 = $("#" + checkId + ' #campo3').val();
			var td0 = $("#" + checkId + ' #td0').val();
			var td1 = $("#" + checkId + ' #td1').val();
			var td2 = $("#" + checkId + ' #td2').val();
			var td3 = $("#" + checkId + ' #td3').val();
			var td4 = $("#" + checkId + ' #td4').val();
			var td5 = $("#" + checkId + ' #td5').val();
			var td6 = $("#" + checkId + ' #td6').val();
			var td7 = $("#" + checkId + ' #td7').val();
			var td8 = $("#" + checkId + ' #td8').val();
			var td9 = $("#" + checkId + ' #td9').val();
			var td10 = $("#" + checkId + ' #td10').val();
			var td11 = $("#" + checkId + ' #td11').val();
			var td12 = $("#" + checkId + ' #td12').val();
			var td13 = $("#" + checkId + ' #td13').val();
			var td14 = $("#" + checkId + ' #td14').val();
			var td15 = $("#" + checkId + ' #td15').val();
			var td16 = $("#" + checkId + ' #td16').val();
			var td17 = $(this).val();
			var td18 = $("#" + checkId + ' #td18').val();
			var td19 = $("#" + checkId + ' #td19').val();
			var td20 = $("#" + checkId + ' #td20').val();
			var td21 = $("#" + checkId + ' #td21').val();
			var td23 = $("#" + checkId + ' #td23').val();
			var td24 = $("#" + checkId + ' #td24').val();
			$("#" + checkId + " #checkValue").val(
					valor + "," + td0 + "," + td1 + "," + td2 + "," + td3 + ","
							+ td4 + "," + td5 + "," + td6 + "," + td7 + ","
							+ td8 + "," + td9 + "," + td10 + "," + td11 + ","
							+ td12 + "," + td13 + "," + td14 + "," + td15 + ","
							+ td16 + "," + td17 + "," + td18 + "," + td19 + ","
							+ td20 + "," + td21 + "," + td23 + "," + td24);
			$("#mostrar").val(
					$(".form-check-input-obtener:checked").map(function() {
						var checkId = $(this).attr('id');
						return $("#" + checkId + " #checkValue").val();
					}).get().join("||"));

		});
$(document).on(
		'keyup',
		'#t18',
		function() {
			var checkId = $(this).closest('tr').attr('id');
			var valor = $("#" + checkId + ' .form-check-input-obtener').val();
			var td0 = $("#" + checkId + ' #td0').val();
			var td1 = $("#" + checkId + ' #td1').val();
			var td2 = $("#" + checkId + ' #td2').val();
			var td3 = $("#" + checkId + ' #td3').val();
			var td4 = $("#" + checkId + ' #td4').val();
			var td5 = $("#" + checkId + ' #td5').val();
			var td6 = $("#" + checkId + ' #td6').val();
			var td7 = $("#" + checkId + ' #td7').val();
			var td8 = $("#" + checkId + ' #td8').val();
			var td9 = $("#" + checkId + ' #td9').val();
			var td10 = $("#" + checkId + ' #td10').val();
			var td11 = $("#" + checkId + ' #td11').val();
			var td12 = $("#" + checkId + ' #td12').val();
			var td13 = $("#" + checkId + ' #td13').val();
			var td14 = $("#" + checkId + ' #td14').val();
			var td15 = $("#" + checkId + ' #td15').val();
			var td16 = $("#" + checkId + ' #td16').val();
			var td17 = $("#" + checkId + ' #td17').val();
			var td18 = $(this).val();
			var td19 = $("#" + checkId + ' #td19').val();
			var td20 = $("#" + checkId + ' #td20').val();
			var td21 = $("#" + checkId + ' #td21').val();
			var td23 = $("#" + checkId + ' #td23').val();
			var td24 = $("#" + checkId + ' #td24').val();
			$("#" + checkId + " #checkValue").val(
					valor + "," + td0 + "," + td1 + "," + td2 + "," + td3 + ","
							+ td4 + "," + td5 + "," + td6 + "," + td7 + ","
							+ td8 + "," + td9 + "," + td10 + "," + td11 + ","
							+ td12 + "," + td13 + "," + td14 + "," + td15 + ","
							+ td16 + "," + td17 + "," + td18 + "," + td19 + ","
							+ td20 + "," + td21 + "," + td23 + "," + td24);
			$("#mostrar").val(
					$(".form-check-input-obtener:checked").map(function() {
						var checkId = $(this).attr('id');
						return $("#" + checkId + " #checkValue").val();
					}).get().join("||"));

		});


