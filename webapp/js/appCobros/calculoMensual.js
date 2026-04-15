/**
 * OPERACIONES GENERALES
 * 
 * @returns
 */
function getOperacion(operacion) {
	switch (operacion) {
	case "porFuente":
		operacion = "¿Desea calcular el ajuste por fuente?";
		break;
	case "porProceso":
		operacion = "¿Desea calcular el ajuste por proceso?";
		break;
	case "deshacer":
		operacion = "¿Desea deshacer el ajuste?";
		break;

	default:
		break;
	}
	return operacion;
}

$(".globalGetProceso").each(function() {
	var id = $(this).attr("id");
	var valor = $("#" + id.replace('getProceso', '')).val();
	console.log(valor);
	$("#" + id).val(valor);
});

/**
 * CALCULAR AJUSTE
 * 
 * @returns
 */
$('#checkAjustePorProceso').click(function() {
	if ($('#checkAjustePorProceso').is(':checked')) {
		$('#ajustePorProceso').val(1);
	} else {
		$('#ajustePorProceso').val(0);
	}

});

if ($('#checkAjustePorProceso').is(':checked')) {
	$('#ajustePorProceso').val(1);
} else {
	$('#ajustePorProceso').val(0);
}

jQuery(".btnProceso").click(function(event) {
	var lista = $(".form-check-get-1:checked").map(function() {
		return this.value;
	}).get().join("||");
	$("#lista1").val(lista);
	$("#operacion").val($(this).attr("id"));
	var hola = getOperacion($(this).attr("id"));
	alertify.confirm('Ejecutar Proceso', hola, function() {
		alertify.success('Ejecutando proceso');
		setTimeout(function() {
			$('#btnEjecutar').trigger('click');
		}, 400);
	}, function() {
		alertify.error('Proceso cancelado',2);
	});

});
/**
 * CALENDARIO DE OPERACIONES
 * 
 * @param event
 * @returns
 */

$(".btnAppendConceptos").click(function(event) {
	var i = 0;
	var mensaje = "";
	$(".getColumn").each(function() {
		i++;
		var valColum = $(this).val();

		if (i == 7) {
			mensaje = mensaje + valColum + "||";
			i = 0

		} else {
			mensaje = mensaje + valColum + ",";
		}
		mensaje = mensaje.replace(/á/gi, "a");
		mensaje = mensaje.replace(/é/gi, "e");
		mensaje = mensaje.replace(/í/gi, "i");
		mensaje = mensaje.replace(/ó/gi, "o");
		mensaje = mensaje.replace(/ú/gi, "u");
		mensaje = mensaje.replace(/ñ/gi, "n");
		mensaje = mensaje.replace(/[a-z]/gi, '');
		mensaje = mensaje.replace(/ /g, "");
		$(".sendTable").val(mensaje);
		setTimeout(function() {
			$('.btn-hide').trigger('click');
		}, 500);

	});

});