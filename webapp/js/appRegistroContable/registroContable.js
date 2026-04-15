var radio="radioNegocio";
var num=0;
$(".radioOpcion").change(function() {
	var inputName=$(this).attr('id');
	if(inputName=='radioLibre'){
		radio="radioLibre";
		$(".form-negocio").addClass("d-none");
		$(".form-libre").removeClass("d-none");
	}else if(inputName=='radioNegocio'){
		radio="radioNegocio";
		$(".form-negocio").removeClass("d-none");
		$(".form-libre").addClass("d-none");
	}

});

$(".ajax-form-registro")
.keyup(
		function() {
			var inputName = this.name;
			var requestParam = null;
			var subSelect = null;
			var mainSelect = "#" + inputName + "_r";
			var datosmandar = "";
			if (globalTimeout != null) {
				clearTimeout(globalTimeout);
			}
			globalTimeout = setTimeout(
					function() {
						globalTimeout = null;
						switch (inputName) {
						case "list_Cuentas":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeCuentas"
								datosmandar +="2||";
							break;
						case "list_Negocios":
							requestParam = "/home/list/json/negocio";
							subSelect = "#listaDeNegocios";
							break;
						case "list_Importes":
							requestParam = "/home/list/json/importe";
							subSelect = "#listaDeImportes";
							break;
						case "list_Empresas":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeEmpresas";
							datosmandar +="1||";
							break;
						case "list_Inter":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeInter";
							datosmandar +="5||";
							break;
						case "list_Centro":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeCentro";
							datosmandar +="3||";
							break;
						case "list_Proyectos":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeProyectos";
							datosmandar +="4||";
							break;
						case "list_Productos":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeProductos";
							datosmandar +="6||";
							break;
						case "list_Futuro":
							requestParam = "/home/list/json/parametrizacion";
							subSelect = "#listaDeFuturo";
							datosmandar +="7||";
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
							datosmandar+=$("#" + inputName).val();
							$.ajax({
								url : url,
								data : {
									term : datosmandar
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
$(document).on('click', '#addModelo', function() {
	var contador=0;
	//TIPO
	var tipo=$("#tipo").val();
	if(tipo==""){
		$('#tipo').prop('required', true);
		$('#compro').trigger('click');
	}else{
		contador++;
	}
	//DESCRIPCION
	var descripcion=$("#descripcion").val();
	if(descripcion==""){
		$('#descripcion').prop('required', true);
		$('#compro').trigger('click');
	}else{
		contador++;
	}
	//IMPORTE
	var imported=$("#listaDeImportes").attr('class');
	var importe=$("#listaDeImportes").val();
	var banderaimporte=imported.indexOf("d-none");
	if(parseInt(banderaimporte) > -1){
		importe=$("#list_Importes_r").val();
		$("#listaDeImportes").prop('required', false);
		$("#list_Importes_r").prop('required', true);
	}else{
		$("#listaDeImportes").prop('required', true);
		$("#list_Importes_r").prop('required', false);
	}
	if(importe==null){
		alertify.error('El importe seleccionado no existe',10);
	}else if(importe==""){
		$('#compro').trigger('click');
	}else{
		contador++;
	}
	if(radio=="radioNegocio"){
		//CLIENTE
		var cliented=$("#listaDeClientes").attr('class');
		var cliente=$("#listaDeClientes").val();
		var banderacliente=cliented.indexOf("d-none");
		if(parseInt(banderacliente) > -1){
			cliente=$("#list_Clientes_r").val();
			$("#listaDeClientes").prop('required', false);
			$("#list_Clientes_r").prop('required', true);
		}else{
			$("#listaDeClientes").prop('required', true);
			$("#list_Clientes_r").prop('required', false);
		}
		if(cliente==null){
			alertify.error('El cliente seleccionado no existe',10);
		}else if(cliente==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//NEGOCIO
		var negociod=$("#listaDeNegocios").attr('class');
		var negocio=$("#listaDeNegocios").val();
		var banderanegocio=negociod.indexOf("d-none");
		if(parseInt(banderanegocio) > -1){
			negocio=$("#list_Negocios_r").val();
			$("#listaDeNegocios").prop('required', false);
			$("#list_Negocios_r").prop('required', true);
		}else{
			$("#listaDeNegocios").prop('required', true);
			$("#list_Negocios_r").prop('required', false);
		}
		if(negocio==null){
			alertify.error('El negocio seleccionado no existe',10);
		}else if(negocio==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
	}else{
		//CUENTAS
		var cuentad=$("#listaDeCuentas").attr('class');
		var cuenta=$("#listaDeCuentas").val();
		var banderacuenta=cuentad.indexOf("d-none");
		if(parseInt(banderacuenta) > -1){
			cuenta=$("#list_Cuentas_r").val();
			$("#listaDeCuentas").prop('required', false);
			$("#list_Cuentas_r").prop('required', true);
		}else{
			$("#listaDeCuentas").prop('required', true);
			$("#list_Cuentas_r").prop('required', false);
		}
		if(cuenta==null){
			alertify.error('El cuenta seleccionado no existe',10);
		}else if(cuenta==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//COSTOS
		var centrod=$("#listaDeCentro").attr('class');
		var centro=$("#listaDeCentro").val();
		var banderacentro=centrod.indexOf("d-none");
		if(parseInt(banderacentro) > -1){
			centro=$("#list_Centro_r").val();
			$("#listaDeCentro").prop('required', false);
			$("#list_Centro_r").prop('required', true);
		}else{
			$("#listaDeCentro").prop('required', true);
			$("#list_Centro_r").prop('required', false);
		}
		if(centro==null){
			alertify.error('El centro de costos seleccionado no existe',10);
		}else if(centro==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//COMPAÑIA
		var empresad=$("#listaDeEmpresas").attr('class');
		var empresa=$("#listaDeEmpresas").val();
		var banderaempresa=empresad.indexOf("d-none");
		if(parseInt(banderaempresa) > -1){
			empresa=$("#list_Empresas_r").val();
			$("#listaDeEmpresas").prop('required', false);
			$("#list_Empresas_r").prop('required', true);
		}else{
			$("#listaDeEmpresas").prop('required', true);
			$("#list_Empresas_r").prop('required', false);
		}
		if(empresa==null){
			alertify.error('La compañia seleccionada no existe',10);
		}else if(empresa==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//INTERCOMPAÑIA
		var interd=$("#listaDeInter").attr('class');
		var inter=$("#listaDeInter").val();
		var banderainter=interd.indexOf("d-none");
		if(parseInt(banderainter) > -1){
			inter=$("#list_Inter_r").val();
			$("#listaDeInter").prop('required', false);
			$("#list_Inter_r").prop('required', true);
		}else{
			$("#listaDeInter").prop('required', true);
			$("#list_Inter_r").prop('required', false);
		}
		if(inter==null){
			alertify.error('La intercompañia seleccionada no existe',10);
		}else if(inter==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//PROYECTO
		var proyectod=$("#listaDeProyectos").attr('class');
		var proyecto=$("#listaDeProyectos").val();
		var banderaproyecto=proyectod.indexOf("d-none");
		if(parseInt(banderaproyecto) > -1){
			proyecto=$("#list_Proyectos_r").val();
			$("#listaDeProyectos").prop('required', false);
			$("#list_Proyectos_r").prop('required', true);
		}else{
			$("#listaDeProyectos").prop('required', true);
			$("#list_Proyectos_r").prop('required', false);
		}
		if(proyecto==null){
			alertify.error('El proyecto seleccionado no existe',10);
		}else if(proyecto==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//PRODUCTO
		var productod=$("#listaDeProductos").attr('class');
		var producto=$("#listaDeProductos").val();
		var banderaproducto=productod.indexOf("d-none");
		if(parseInt(banderaproducto) > -1){
			producto=$("#list_Productos_r").val();
			$("#listaDeProductos").prop('required', false);
			$("#list_Productos_r").prop('required', true);
		}else{
			$("#listaDeProductos").prop('required', true);
			$("#list_Productos_r").prop('required', false);
		}
		if(producto==null){
			alertify.error('El producto seleccionado no existe',10);
		}else if(producto==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		//TEMPORAL
		var futurod=$("#listaDeFuturo").attr('class');
		var futuro=$("#listaDeFuturo").val();
		var banderafuturo=futurod.indexOf("d-none");
		if(parseInt(banderafuturo) > -1){
			futuro=$("#list_Futuro_r").val();
			$("#listaDeFuturo").prop('required', false);
			$("#list_Futuro_r").prop('required', true);
		}else{
			$("#listaDeFuturo").prop('required', true);
			$("#list_Futuro_r").prop('required', false);
		}
		if(futuro==null){
			alertify.error('El futuro seleccionado no existe',10);
		}else if(futuro==""){
			$('#compro').trigger('click');
		}else{
			contador++;
		}
		console.log(contador);
		if(contador==10){
			num++;
			var nFilas = $("#tableBody tr").length + 1;
			$('#tableBody')
					.append(
							':<tr id="table'+nFilas+'" class="num'+num+' vista-table"><td>'
									+ tipo
									+ '</td><td>'
									+ descripcion
									+ '</td><td>'
									+ importe
									+ '</td><td>'
									+ empresa
									+ '</td><td>'
									+ cuenta
									+ '</td><td>'
									+ centro
									+ '</td><td>'
									+ proyecto
									+ '</td><td>'
									+ inter
									+ '</td><td>'
									+ producto
									+ '</td><td>'
									+ futuro
									+ '</td><td>'
									+ '<button type="button" id="table'+nFilas+'" '
									+'class="btn-delete-table btn btn-secondary text-white btn-sm "> '
									+'<span class="icon-delete"></span></button>');

		}
		
	}
	
});

$(document).on('click', '#removeModelo', function() {
	var contador=0;
	var nFilas = $("#tableBody tr").length;
	if(nFilas>0){
		while(contador<=0){
			$(".num"+num).each(function() {
				contador++;
			});
			if(contador>0){
				$(".num"+num).remove();
				
			}
			num--;
		}
	}
	
	
	
});
$(document).on('click', '#Tabla', function() {
	var datos="";
	var contador=0;
	$('#tableBody tr td').each(function() {
		contador++;
		if(contador==1){
			datos+=$(this).text().charAt(0)+","
		}else if(contador==2){
			datos+=$(this).text()+",";
		}else if(contador<=9){
			var split = $(this).text().split(" - ");
			datos+=split[0]+",";
		}else if(contador==10){
			var split1 = $(this).text().split(" - ");
			datos+=split1[0]+"||";
		}else if(contador>10){
			contador=0;
		}
	    
	    
	});
	console.log(datos);
	
});

$(document).on('click', '.btn-delete-table', function() {
	var inputName=$(this).attr('id');
	$("#"+inputName).remove();
});

