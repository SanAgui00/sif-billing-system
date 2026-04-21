var radioContacto = "radioNacional";
function radioDireccion() {
	if ($('#radioNacional').is(':checked')) {
		$("#b_cliente_nacional").val("1");
		$("#dir_calle,#dir_num_int,#dir_num_ext,#dir_cp,#dir_colonia").prop(
				"readonly", false);
		$("#dir_ciudad,#dir_pais,#dir_estado,#dir_delegacion,#dir_apartado")
				.prop("readonly", true);
		$('#dir_pais option[value=1]').prop("selected", true);
		$("#dir_ciudad,#dir_apartado").val("");
	}
	if ($('#radioInternacional').is(':checked')) {
		$("#b_cliente_nacional").val("0");
		$(
				"#dir_calle,#dir_num_int,#dir_num_ext,#dir_ciudad,#dir_pais,#dir_apartado")
				.prop("readonly", false);
		$("#dir_cp,#dir_colonia,#dir_estado,#dir_delegacion").prop("readonly",
				true);
		$("#dir_cp,#dir_colonia,#dir_estado,#dir_delegacion").val("");

	}
}

radioDireccion();
$('.radioDireccion').click(function() {
	radioDireccion();
});

$('.changetab').click(function() {
	var inputName = this.name;
	inputName = inputName.replace("cambio", "");
	if (inputName == 10) {
		$(".contactostab").addClass("d-none");
		$(".cleanInput").val("");
		$("#id_contacto").val("0");
		$("#banderacon").val("0");
	} else {
		$(".contactostab").removeClass("d-none");
	}
	$("#tab-" + inputName).trigger("click");
});

function radioDireccion1() {
	if ($('#radioNacional1').is(':checked')) {
		radioContacto = "radioNacional";
		$("#b_cliente_nacional1").val("1");
		$("#dir_calle1,#dir_num_int1,#dir_num_ext1,#dir_cp1,#dir_colonia1")
				.prop("readonly", false);
		$("#dir_ciudad1,#dir_pais1,#dir_estado1,#dir_apartado1").prop(
				"readonly", true);
		$('#dir_pais1 option[value=1]').prop("selected", true);

	}
	if ($('#radioInternacional1').is(':checked')) {
		radioContacto = "radioInternacional";
		$("#b_cliente_nacional1").val("0");
		$(
				"#dir_calle1,#dir_num_int1,#dir_num_ext1,#dir_ciudad1,#dir_pai1s,#dir_apartado1")
				.prop("readonly", false);
		$("#dir_cp1,#dir_colonia1,#dir_estado1").prop("readonly", true);

	}
}

radioDireccion1();

$('.radioDireccion1').click(function() {
	radioDireccion1();
});

function BuscarCodigoPostal(codigo) {
	var path = $("#path").val();
	var url = path + "/home/list/json/codigopostal";
	$
			.ajax({
				url : url,
				data : {
					term : codigo
				},
				success : function(data) {
					var uniqueNames = [];
					var uniqueNames1 = [];
					if (data.length >= 1) {
						$("#dir_colonia11").empty();
						$("#dir_delegacion11").empty();
						$
								.each(
										data,
										function(index, element) {
											if ($.inArray(element.colonia,
													uniqueNames) === -1) {
												uniqueNames
														.push(element.colonia);
												$("#dir_colonia11")
														.append(
																':<option value="'
																		+ element.colonia
																		+ '">'
																		+ element.colonia
																		+ '</option>');
												if ($.inArray(
														element.delegacion,
														uniqueNames1) === -1) {
													uniqueNames1
															.push(element.delegacion);
													$("#dir_delegacion11")
															.append(
																	':<option value="'
																			+ element.id_poblacion
																			+ '">'
																			+ element.delegacion
																			+ '</option>');
												}
												$(
														'#dir_pais1 option[value="'
																+ element.id_pais
																+ '"]').attr(
														"selected", true);
												$(
														'#dir_estado1 option[value="'
																+ element.id_estado
																+ '"]').attr(
														"selected", true);

											}
										});
					} else {
						$('#dir_estado1 option[value=""]').attr("selected",
								true);
						$("#dir_colonia11").empty();
						$("#dir_colonia11")
								.append(
										':<option value="">Selecciona una opcion</option>');
						$("#dir_colonia11")
								.append(
										':<option value="nueva">Nueva Colonia</option>');

						$("#dir_delegacion11").empty();
						$("#dir_delegacion11")
								.append(
										':<option value="">Selecciona una opcion</option>');
						$("#dir_delegacion11")
								.append(
										':<option value="nueva">Nueva Delegacion</option>');

					}

				}
			});

}

$('.buscarCodigo').click(function() {
	var buttonId = $(this).attr('id');
	buttonId = buttonId.replace("buscarCodigoPostal", "")
	var codigop = $("#dir_cp" + buttonId).val();
	BuscarCodigoPostal(codigop);

});

$(".changedatos").change(function() {
	var inputName = this.name;
	var valor = $(this).val();
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		globalTimeout = null;
		if (valor == 'nueva') {
			$(".nueva" + inputName).removeClass("d-none");
		} else {
			$(".nueva" + inputName).addClass("d-none");
		}
	}, 400);

});

$("#addContact")
		.click(
				function() {
					var conrequeridos = 0;
					var contacto = $("#id_contacto").val();
					var bd = $("#bd").val();
					var bande = $("#banderacon").val();
					if (contacto != 0) {
						$("#bd" + bd).remove();
					}
					if (bande != 0) {
						$("#" + bande).remove();
					}
					var nombreapellidos = $("#nom_ape").val();
					var tel1 = $("#tel1").val();
					var tel2 = $("#tel2").val();
					var ext = $("#ext").val();
					var fax = $("#fax").val();
					var email = $("#email").val();
					var patronfac;
					if ($("#patronfac").is(':checked')) {
						patronfac = 1;
					} else {
						patronfac = 0;
					}
					var cfdmail;
					if ($("#cfdmail").is(':checked')) {
						cfdmail = 1;
					} else {
						cfdmail = 0;
					}
					var bandecfd = "";
					if (cfdmail == 1) {
						bandecfd = "Si";
					} else {
						bandecfd = "No";
					}
					var apli;
					if ($("#apli").is(':checked')) {
						apli = 1;
					} else {
						apli = 0;
					}
					var puesto = $("#puesto").val();
					var comentarios = $("#comentarios").val();
					var calle = $("#dir_calle1").val();
					var numext = $("#dir_num_ext1").val();
					var numint = $("#dir_num_int1").val();
					var codigop = $("#dir_cp1").val();
					var colonia = $("#dir_colonia11").val();
					var ciudad = $("#dir_ciudad1").val();
					var paid = $("#dir_pais1").val();
					var apartado = $("#dir_apartado1").val();
					var estado = $("#dir_estado1").val();
					var delegacion = $("#dir_delegacion11").val();
					var nuevacolonia = $("#dir_colonia1").val();
					var nuevadelegacion = $("#dir_delegacion1").val();
					var datosre = "";
					var datosre1 = "";
					if (nombreapellidos == '') {
						conrequeridos++;
						datosre += "Nombre Completo||";
					}
					if (tel1 == '') {
						conrequeridos++;
						datosre += "Telefono 1||";
					}
					if (email == '') {
						conrequeridos++;
						datosre += "Email||";
					}
					if (puesto == '') {
						conrequeridos++;
						datosre += "Puesto||";
					}
					if (comentarios == '') {
						conrequeridos++;
						datosre += "Comentarios||";
					}
					if (calle == '') {
						conrequeridos++;
						datosre += "Calle del contacto||";
					}
					if (conrequeridos <= 6 && conrequeridos > 0) {
						if (conrequeridos == 1) {
							alertify.error('Favor de Digitar el campo de '
									+ datosre.replace("||", ""), 10);
						} else {
							var split = datosre.split("||");
							for (var i = 0; i < split.length - 1; i++) {
								switch (i) {
								case split.length - 2:
									datosre1 += split[i];
									break;
								case split.length - 3:
									datosre1 += split[i] + " y ";
									break;
								default:
									datosre1 += split[i] + ",";
									break;

								}

							}
							alertify.error('Favor de Digitar los campos de '
									+ datosre1, 10);
						}

					} else {

						if (/^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i
								.test(email)) {
							var nFilas = $("#tableBody tr").length + 1;
							$('#tableBody')
									.append(
											'<tr id="libre'
													+ nFilas
													+ '"><td>'
													+ nombreapellidos
													+ '</td><td>'
													+ email
													+ '</td><td>'
													+ tel1
													+ '</td><td>'
													+ bandecfd
													+ '</td><td>'
													+ puesto
													+ '</td><td>'
													+ comentarios
													+ '<input type="hidden" class="inputBdContacto libre'
													+ nFilas
													+ '" value="'
													+ contacto
													+ ','
													+ nombreapellidos
													+ ','
													+ tel1
													+ ','
													+ tel2
													+ ','
													+ ext
													+ ','
													+ fax
													+ ','
													+ email
													+ ','
													+ patronfac
													+ ','
													+ cfdmail
													+ ','
													+ apli
													+ ','
													+ 'addenda'
													+ ','
													+ puesto
													+ ','
													+ comentarios
													+ '&&'
													+ radioContacto
													+ ','
													+ calle
													+ ','
													+ numext
													+ ','
													+ numint
													+ ','
													+ codigop
													+ ','
													+ colonia
													+ ','
													+ ciudad
													+ ','
													+ paid
													+ ','
													+ apartado
													+ ','
													+ estado
													+ ','
													+ delegacion
													+ ','
													+ nuevacolonia
													+ ','
													+ nuevadelegacion
													+ '"/>'
													+ '</td>'
													+ '<td><button type="button" id="libre'
													+ nFilas
													+ '" class="editarContacto btn btn-secondary text-white btn-sm btn-table editarContacto"><span class="icon-brush"></span></button></td>'
													+ '<td><button type="button" id="libre'
													+ nFilas
													+ '" class="eliminarContact btn btn-secondary text-white btn-sm btn-table"><span class="icon-delete"></span></button></td>'
													+ '</tr>');
							$("#regresarContact").trigger("click");

						} else {
							alertify
									.error(
											'Favor de Digitar una direccion de Correo valida',
											10);
						}
					}
				});
$(document).on('click', '.eliminarContact', function() {
	var str = $(this).attr('id');
	var valor = $("." + str).val();
	if (str.indexOf("bd") != -1) {
		$("#" + str).addClass("d-none");
		var split = valor.split(",");
		$("." + str).val(split[0] + ",ELI,update");
	} else {
		$("#" + str).remove();
	}
});

$(document).on(
		'click',
		'.editarContacto',
		function() {
			var str = $(this).attr('id');
			var clas = $(this).attr('class');
			if (str.indexOf("libre") != -1) {
				var valores = $("." + str).val();
				var splitval = valores.split("&&");
				var splitval1 = splitval[0].split(",");
				var splitval2 = splitval[1].split(",");
				$("#id_contacto").val("0");
				$("#banderacon").val(str);
				$("#nom_ape").val(splitval1[1]);
				$("#tel1").val(splitval1[2]);
				$("#tel2").val(splitval1[3]);
				$("#ext").val(splitval1[4]);
				$("#fax").val(splitval1[5]);
				$("#email").val(splitval1[6]);
				$("#puesto").val(splitval1[11]);
				$("#comentarios").val(splitval1[12]);
				if (splitval1[8] == 0) {
					$("#cfdmail").prop("checked", false);
				} else {
					$("#cfdmail").prop("checked", true);
				}
				if (splitval1[7] == 0) {
					$("#patronfac").prop("checked", false);
				} else {
					$("#patronfac").prop("checked", true);
				}
				if (splitval1[9] == 0) {
					$("#apli").prop("checked", false);
				} else {
					$("#apli").prop("checked", true);
				}
				$("#dir_calle1").val(splitval2[1]);
				$("#dir_num_int1").val(splitval2[3]);
				$("#dir_num_ext1").val(splitval2[2]);
				$("#dir_cp1").val(splitval2[4]);
				$("#dir_ciudad1").val(splitval2[6]);
				$("#dir_apartado1").val(splitval2[8]);
				if (splitval2[7] == 1) {
					$("#radioNacional1").prop("checked", true);
					$("#radioInternacional1").prop("checked", false);
				} else {
					$("#radioNacional1").prop("checked", false);
					$("#radioInternacional1").prop("checked", true);
				}
				BuscarCodigoPostal(splitval2[4]);
				$('#dir_colonia11 option[value="' + splitval2[5] + '"]').attr(
						"selected", true);
				$('#dir_delegacion11 option[value="' + splitval2[10] + '"]')
						.attr("selected", true);
				$(".contactostab").addClass("d-none");
				$("#tab-10").trigger("click");
			} else {
				str = str.replace("editContact", "");
				splitclass = clas.split("base");
				$("#bd").val(splitclass[1]);
				$("#id_contacto").val("");
				$("#banderacon").val("0");
				$("#id_contacto").val(str);
				var path = $("#path").val();
				var url = path + "/home/list/json/direccioncontacto";
				$.ajax({
					url : url,
					data : {
						term : str
					},
					success : function(data) {
						$.each(data,
								function(index, element) {
									$("#nom_ape").val(element.nombre_contacto);
									$("#tel1").val(element.telefono_1);
									$("#tel2").val(element.telefono_2);
									$("#ext").val(element.extension);
									$("#fax").val(element.fax);
									$("#email").val(element.email);
									$("#puesto").val(element.puesto);
									$("#comentarios").val(element.comentarios);
									if (element.b_enviocfd_x_email == 0) {
										$("#cfdmail").prop("checked", false);
									} else {
										$("#cfdmail").prop("checked", true);
									}
									if (element.b_cont_fact == 0) {
										$("#patronfac").prop("checked", false);
									} else {
										$("#patronfac").prop("checked", true);
									}
									if (element.b_addenda == 0) {
										$("#apli").prop("checked", false);
									} else {
										$("#apli").prop("checked", true);
									}
									$("#dir_calle1").val(element.calle);
									$("#dir_num_int1").val(element.numero_int);
									$("#dir_num_ext1").val(element.numero_ext);
									$("#dir_cp1").val(element.cp);
									$("#dir_ciudad1").val(element.ciudad);
									$("#dir_apartado1").val(
											element.apartado_postal);
									if (element.id_pais == 1) {
										$("#radioNacional1").prop("checked",
												true);
										$("#radioInternacional1").prop(
												"checked", false);
									} else {
										$("#radioNacional1").prop("checked",
												false);
										$("#radioInternacional1").prop(
												"checked", true);
									}
									BuscarCodigoPostal(element.cp);
									$(
											'#dir_colonia11 option[value="'
													+ element.colonia + '"]')
											.attr("selected", true);
									$(
											'#dir_delegacion11 option[value="'
													+ element.id_poblacion
													+ '"]').attr("selected",
											true);
									$(".contactostab").addClass("d-none");
									$("#tab-10").trigger("click");
								});
					}
				});

			}
		});
$(document).on('click', '.button-script', function() {
	var a = $(".inputBdContacto").map(function() {
		return $(this).val();
	}).get().join("||");
	$("#contactosSplit").val(a);
	setTimeout(function() {
		$('#save').trigger('click');
	}, 1000);
});

$(document).on('click', '.btn-pag', function() {
	var buttonId = $(this).attr('id');
	var valor = $("#fromRow").val();
	if (buttonId == 'prev') {
		var val = parseInt(valor);
		val -= 15;
		$("#fromRow").val(val);
		Paginacion();
	} else {
		var val = parseInt(valor);
		val += 15;
		$("#fromRow").val(val);
		Paginacion();
	}
	PaginacionConsulta(val);
});

Paginacion();
function Paginacion() {
	if ($("#fromRow").val() == 0) {
		$("#prev").addClass("d-none");
	} else {
		$("#prev").removeClass("d-none");
	}
}

function PaginacionConsulta(valor) {
	$("#prev").addClass("d-none");
	$("#next").addClass("d-none");
	var inputName = $("#cliente_id").val();
	var path = $("#path").val();
	var url = path + "/home/list/json/cuentascliente";
	$
			.ajax({
				url : url,
				data : {
					term : inputName,
					fromRow : valor
				},
				success : function(data) {
					$("#tableBodyClaves").empty();
					var banderaadquirente = "";

					$
							.each(
									data,
									function(index, element) {
										var nFilas = $("#tableBody tr").length + 1;
										var fuentecliente = "";
										var salida = "";
										if (element.b_adquirente == 0) {
											banderaadquirente = "No";
										} else {
											banderaadquirente = "Si";
										}
										if (element.id_fuente != null) {
											fuentecliente = element.id_fuente
													+ ' - ' + element.clave;
										}
										if (element.clave_sistema_salida != null) {
											salida = element.clave_sistema_salida;
										}

										$('#tableBodyClaves')
												.append(
														'<tr id="clave'
																+ nFilas
																+ '"><td>'
																+ element.clave_externa
																+ '</td><td>'
																+ fuentecliente
																+ '</td><td>'
																+ salida
																+ '</td><td>'
																+ banderaadquirente
																+ '</td><td>'
																+ element.id_agrupador
																+ ' - '
																+ element.clave_cliente
																+ '</td><td><button type="button" id="clave'
																+ nFilas
																+ '" class="agregareliminar btn btn-secondary text-white btn-sm btn-table"><span class="icon-delete"></span></button></td>'
																+ '</tr>');

									});
					CompararNext();
					Paginacion();
				}
			});

}

$(".radioentradasalida").change(function() {
	var buttonId = $(this).attr('id');
	if (buttonId == 'entrada') {
		$(".form-fuente").removeClass("d-none");
		$(".form-sistema").addClass("d-none");
	} else {
		$(".form-fuente").addClass("d-none");
		$(".form-sistema").removeClass("d-none");
	}
});

CompararNext();
function CompararNext() {
	var valor = $("#fromRow").val();
	var val = parseInt(valor);
	val += 15;
	var inputName = $("#cliente_id").val();
	var path = $("#path").val();
	var url = path + "/home/list/json/cuentascliente";
	var i = 0;
	$.ajax({
		url : url,
		data : {
			term : inputName,
			fromRow : val
		},
		success : function(data) {
			$.each(data, function(index, element) {
				i++;
			});
			if (i >= 1) {
				$("#next").removeClass("d-none");
			} else {
				$("#next").addClass("d-none");
			}
		}
	});
}

$(document).on(
		'click',
		'.agregareliminar',
		function() {
			var buttonId = $(this).attr('id');
			var conrequeridos = 0;
			var validcliente = 1;
			var datosre = "";
			var texto = "";
			var datosre1 = "";
			var fuentesis = 0;
			if (buttonId == 'add') {
				var clave_externa = $("#claveext").val();
				var adquirente;
				var fuentesistema;

				if ($("#adquirente").is(':checked')) {
					adquirente = 1;
				} else {
					adquirente = 0;
				}
				if ($("#entrada").is(':checked')) {
					fuentesistema = $("#fuenteentrada").val();
					fuentesis = 1;
					texto = "Fuente||";
				} else {
					fuentesistema = $("#sistema").val();
					fuentesis = 2;
					texto = "Sistema||";
				}
				// CLIENTE
				var cliented = $("#listaDeClientes").attr('class');
				var cliente = $("#listaDeClientes").val();
				var banderacliente = cliented.indexOf("d-none");
				if (parseInt(banderacliente) > -1) {
					cliente = $("#list_Clientes_r").val();
				}
				if (cliente == null) {
					validcliente = 0;

				} else if (cliente == "") {
					datosre += "Cliente||";
					conrequeridos++;
				}
				if (clave_externa == '') {
					conrequeridos++;
					datosre += "Clave Externa||";
				}
				if (fuentesistema == '') {
					conrequeridos++;
					datosre += texto;
				}
				if (validcliente == 0) {
					alertify.error('El cliente seleccionado no existe', 10);
				} else {
					if (conrequeridos <= 3 && conrequeridos > 0) {
						if (conrequeridos == 1) {
							alertify.error('Favor de Digitar el campo de '
									+ datosre.replace("||", ""), 10);
						} else {
							var split = datosre.split("||");
							for (var i = 0; i < split.length - 1; i++) {
								switch (i) {
								case split.length - 2:
									datosre1 += split[i];
									break;
								case split.length - 3:
									datosre1 += split[i] + " y ";
									break;
								default:
									datosre1 += split[i] + ",";
									break;

								}

							}
							alertify.error('Favor de Digitar los campos de '
									+ datosre1, 10);
						}

					} else {
						var inputName = $("#cliente_id").val();
						var path = $("#path").val();
						var url = path
								+ "/home/list/json/agregar/cuentascliente";
						$.ajax({
							url : url,
							data : {
								cliente : inputName,
								clave : clave_externa,
								adquirente : adquirente,
								agrupador : cliente,
								fuentesistema : fuentesistema,
								fuentesis : fuentesis
							},
							success : function(data) {
								console.log(data);
								if (data == 1) {
									$("#fromRow").val(0);
									PaginacionConsulta(0);
									$("#claveext").val("");
									$('#fuenteentrada option[value=""]').prop(
											"selected", true);
									$('#sistema option[value=""]').prop(
											"selected", true);
								} else if(data ==2){
									alertify.error(
											'La clave que quiere ingresar con esa fuente ya esta asociada a otro cliente', 10);
								}else{
									alertify.error(
											'Error al insertar los datos', 10);
								}

							}
						});
					}

				}

			} else {

				var datos = "";
				var contador = 0;
				$('#tableBodyClaves #' + buttonId + ' td').each(function() {
					contador++;
					if (contador == 1) {
						datos += $(this).text() + ","
					} else if (contador == 2) {
						var split = $(this).text().split(" - ");
						datos += split[0] + ",";
					} else if (contador == 3) {
						datos += $(this).text() + ",";
					} else if (contador == 4) {
						if ($(this).text() == 'Si') {
							datos += "1,";
						} else {
							datos += "0,";
						}
					} else if (contador == 5) {
						console.log($(this).text());
						var split = $(this).text().trim().split(" - ");
						datos += split[0];
					}

				});

				console.log(datos);

			}

		});
