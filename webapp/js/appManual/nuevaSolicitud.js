jQuery(document).ready(function() {

	$('#tabGenerales').collapse('show');
	if ($('#lista_Servicios').val() == '') {
		$('#lista_Servicios_r').addClass();
	}
});

$(".ajax-form1")
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
								case "lista_Servicios":
									requestParam = "/home/list/json/serviciosClave";
									subSelect = "#listaDeServicios";
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

// Agregar cliente a la tabla
var j = 1;
jQuery(".btnAddClientes")
		.on(
				"click",
				function() {
					// separar id_cliente
					var clientes = $('#clientes').val();
					var clientesTot = $('#clientesTot').val();
					var split = clientes.split("&&");
					var id_cliente = "";
					var cliente = "";
					var colum = 0;

					var columGet = $('#colum').val();
					colum = parseInt(columGet) + 1;

					$("#colum").val(colum);

					for (var i = 0; i < split.length; i++) {
						if (i == 0) {
							id_cliente += split[i];
						} else {
							cliente += split[i];
						}
					}

					clientesTot = clientesTot + cliente + "&&";
					$("#clientesTot").val(clientesTot);

					var total = $('#totConcep').val();

					if (total > 1) {
						var tede = "<tr id='tr"
								+ j
								+ "'><td><input class='d-none' type='text' id='col0"
								+ "' name='id_cliente' value='" + id_cliente
								+ "'>" + cliente + "</td>";

						for (let i = 1, length1 = total; i < length1; i++) {
							tede += "<td><input class='inputVal' type='text' id='col"
									+ i + "' name='total' value='0'></td>";
							if (i == length1 - 1) {
								var endCol = i + 1;
							}

						}
						tede += "<td><input type='text' id='col" + endCol
								+ "' value='0' readonly></td>";
						tede += "<td class='d-none'><input type='hidden' id='numTr"
								+ j + "' value='tr" + j + "'></td>";
						tede += "</tr>";
						$("#AddClientes").append(tede);
						j++;

					} else if (total == 1) {
						console.log(id_cliente)
						var tede1 = "<tr id='tr"
								+ j
								+ "'><td><input class='d-none' type='text' id='col0"
								+ "' name='id_cliente' value='" + id_cliente
								+ "'>" + cliente + "</td>";

						tede1 += "<td><input class='' type='text' id='col1' name='total' value='0'></td>";
						tede1 += "<td class='d-none'><input type='hidden' id='numTr"
								+ j + "' value='tr" + j + "'></td>";
						tede1 += "</tr>";
						$("#AddClientes").append(tede1);
						j++;
					}
					$("#solCrear").removeClass('d-none');
				});

// cacular total
$(document).on('keyup', '.inputVal', function() {
	var colum = $('#colum').val();

	for (let j = 1, length2 = colum; j <= length2; j++) {

		var numTr = $('#numTr' + j).val();

		var total = $('#totConcep').val();
		var valInput = "";
		var suma = 0;

		for (let i = 1, length1 = total; i <= length1; i++) {

			if (i < length1) {
				valInput = $("#" + numTr + ' #col' + i).val();
				suma += parseInt(valInput);
			}
			if (i == length1) {
				$("#" + numTr + ' #col' + i).val(suma);
			}

		}
	}

});

// valores de la tabla
$(".btnSolicitud").click(function() {

	var total = $('#totConcep').val();
	var variables = "";
	var colum = $('#colum').val();
	var tds = "";

	for (let j = 1, length2 = colum; j <= length2; j++) {
		var suma = 0;
		var tr = "tr" + j;
		// variables += "";

		for (let i = 0, length1 = total; i <= length1; i++) {

			if (i < length1) {
				tds = $("#" + tr + ' #col' + i).val();
				variables += tds + ",";

			} else if (i == length1) {
				tds = $("#" + tr + ' #col' + i).val();
				variables += tds + "||";
			}
		}
	}

	$("#datos").val(variables);
});
