jQuery(document).ready(function($) {

	$('.prev').on('click', function() {
		paginacion(true, false);
	});

	$('.next').on('click', function() {
		paginacion(false, true);
	});
	$(document).on('click', '.pagination-list', function() {
		var pageClic = $(this).text();
		paginacion(false, false, pageClic);
	});

});
window.onload = function() {
	globalGet();
	paginacion();
}
/* FUNCION UTILIZADA PARA OBTENER LOS DATOS DE OTROS FORM AL RECARGAR LA PAGINA */
function globalGet() {
	var i = 0;
	$(".globalGet").each(function() {
		var cleanId = $(this).attr("id");
		var rowValue = $("#" + cleanId.replace('get', '')).val();
		$("#" + cleanId).val(rowValue);
	});
}
/* FUNCION DE PAGINACION */
function paginacion(previous, next, pageClic) {
	/* SE OBTIENE EL TOTAL DE CAMPOS EN LA CONSULTA */
	var totalRows = $(".registros_totales").val();
	/* SE INDICA LA CANTIDAD DE REGISTROS A MOSTRAR POR PAGINA */
	var totalPerPage = 15;
	/* SE UTILIZA COMO CONTADOR DEL FOREACH, PARA MOSTRAR LA PAGINACIÓN */
	var counterPage = 0;
	/* SE INDICA EL NUMERO MAXIMO DE PAGINAS A MOSTRAR A LA VEZ */
	var showMaxPages = 15;
	/* SE REALIZA EL CALCULO DE PAGINAS TOTALES */
	var total = Math.ceil(totalRows / totalPerPage);

	/* ACCION REALIZADA CUANDO SE DA CLIC AL BOTON DE NEXT */
	if (next == true) {
		var firstValue = parseInt(document
				.getElementById("pagination-container").firstChild.innerHTML);
		var lastValue = parseInt(document
				.getElementById("pagination-container").lastChild.innerHTML);
		var addNum = lastValue + 1;
		if (lastValue !== total) {
			$(".pagination-container").append(
					"<span class='page-link d-inline-block pagination-list'>"
							+ addNum + "</span>");
			var list = document.getElementById("pagination-container");
			list.removeChild(list.childNodes[0]);
		}
	}
	/* ACCION REALIZADA CUANDO SE DA CLIC AL BOTON PREVIOUS */
	if (previous == true) {
		var firstValue = parseInt(document
				.getElementById("pagination-container").firstChild.innerHTML);
		var lastValue = parseInt(document
				.getElementById("pagination-container").lastChild.innerHTML);
		var removeNum = firstValue - 1;
		if (firstValue !== 1) {
			var select = document.getElementById('pagination-container');
			select.removeChild(select.lastChild);
			$(".pagination-container").prepend(
					"<span class='page-link d-inline-block pagination-list'>"
							+ removeNum + "</span>");
		}
	}

	if (typeof pageClic !== "undefined") {
		var toRow = pageClic * 15;
		var fromRow = toRow - 15;
		$(".fromRow").val(fromRow);
		$(".toRow").val(toRow);
		setTimeout(function() {
			$('#pagination-submit').trigger('click');
		}, 150);

	}
	/* ACCION REALIZADA CUANDO LOS BOTONES PREVIOUS Y NEXT NO ESTAN ACTIVOS */
	if (previous !== true && next !== true && typeof pageClic === "undefined") {
		for (var numberPage = 1; numberPage <= total; numberPage++) {
			counterPage++;
			if (counterPage <= showMaxPages) {
				$(".pagination-container").append(
						"<span class='page-link d-inline-block pagination-list'>"
								+ numberPage + "</span>");
				$('.prev').hide();
				$('.next').hide();
				$(".page-search").hide();
				
				

			} else {
				$('.prev').show();
				$('.next').show();
				$(".page-search").show();
				

			}
		}
	}
}