/* LIMITE DE VALIDACIONES */
/* LIMITE DE VALIDACIONES */

$("#evento").each(function() {
	var evento = $(this).val();
	if (evento == "porCliente") {
		setTimeout(function() {
			$('#tab-1').trigger('click');
		}, 200);
	}
	if (evento == "porServicio") {
		setTimeout(function() {
			$('#tab-2').trigger('click');
		}, 200);
	}
});

$(".tab-link").click(function(event) {
	var tab = $(this).attr("id");
	if (tab == "tab-1") {
		$("#evento").val("porCliente");
		$("#tituloServicioCliente").text("Búsqueda por CLIENTE");
	} else if (tab == "tab-2") {
		$("#tituloServicioCliente").text("Búsqueda por SERVICIO");
		$("#evento").val("porServicio");
	}
});
/* LIMITE DE VALIDACIONES */
/* LIMITE DE VALIDACIONES */

/* VALIDACION EN PRECIO */
jQuery(".btnAplicar").on(
		"click",
		function() {
			$("#lista").val(
					$(".form-check-input-asignar:checked").map(function() {
						return this.value;
					}).get().join(","));
			alertify.confirm('Ejecutar Proceso',
					'¿Desea asigar el precio a los campos seleccionados?',
					function() {
						alertify.success('Ejecutando asignación');
						setTimeout(function() {
							$('.btnEjecutar').trigger('click');
						}, 200);
					}, function() {
						alertify.error('Proceso cancelado', 2);
					});
		});

/* VALIDACIONES DE CAMPOS DE PRECIOS */
formatearNumeroAlCargar();
var globalTimeout = null;

function formatearNumeroAlCargar() {
	$("[class*='formatearNumero']").each(function() {
		var claseCompleta = this.className.match(/formatearNumero\d+/);
		if (claseCompleta == "formatearNumero12") {
			var numero = accounting.formatMoney(0, "", 0, ",", ".");
			$(this).val(numero);
		}
		if (claseCompleta == "formatearNumero24") {
			var numero = accounting.formatMoney(0, "", 4, ",", ".");
			$(this).val(numero);
		}
		if (claseCompleta == "formatearNumero100") {
			var numero = accounting.formatMoney(0, "", 4, ",", ".");
			$(this).val(numero);
		}
	});
}

function formatearNumero(claseCompleta, longitudPrecio, cifraMax, input) {
	if (globalTimeout != null) {
		clearTimeout(globalTimeout);
	}
	globalTimeout = setTimeout(function() {
		if (claseCompleta == "formatearNumero12") {
			numeroFinal = accounting.formatMoney(cifraMax, "", 0, ",", ".");
			$(input).val(numeroFinal);
		}
		if (claseCompleta == "formatearNumero24") {
			if (longitudPrecio >= 25) {
			} else {
			}

		}
		if (claseCompleta == "formatearNumero100") {
			numeroFinal = accounting.formatMoney(cifraMax, "", 4, ",", ".");
			$(input).val(numeroFinal);
		}

	}, 700);
}
$("[class*='formatearNumero']")
		.keyup(
				function(event) {

					var claseCompleta = this.className
							.match(/formatearNumero\d+/);
					var valorConFormato = $(this).val();
					var longitudPrecio = JSON.stringify(accounting
							.unformat(valorConFormato)).length;
					var input = $(this);
					var formatoSinCero = valorConFormato.replace(
							valorConFormato.match("^0+(?!$)"), "");
					var formatoCompleto = formatoSinCero
							.replace(/[^\d.-]/g, '');

					/* VALIDACIONES EN LA EXTENSION DEL NUMERO ESCRITO */
					if (claseCompleta == "formatearNumero12") {
						var cifraMax = formatoCompleto.substring(0, 12);

						formatearNumero(claseCompleta, longitudPrecio,
								cifraMax, input);
					}
					if (claseCompleta == "formatearNumero24") {
						var cifraMax = formatoCompleto.substring(0, 25);
						formatearNumero(claseCompleta, longitudPrecio,
								cifraMax, input);
					}
					if (claseCompleta == "formatearNumero100") {
						if (!(formatoCompleto.indexOf(".") != -1)) {
							formatoCompleto = formatoCompleto + ".";
						}
						var puntoDecimal = formatoCompleto.split('.')
						var enteros = puntoDecimal[0].substring(0, 2);
						var decimales = puntoDecimal[1].substring(0, 4);
						var cifraMax = enteros + "." + decimales;
						formatearNumero(claseCompleta, longitudPrecio,
								cifraMax, input);
					}

				});