/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 12/06/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanCalcularAjuste;
import com.prosa.sif.pojo.TBL_SIF_REBATE;
import com.prosa.sif.pojo.TablaPeriodo;
import com.prosa.sif.pojo.ViewPeriodo;

@Repository
@Transactional
@SuppressWarnings("all")
public class CalculoMensualDaoImpl implements CalculoMensualDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;
	
	private static String mens = "ParseException";

	@Override
	public void queryPeriodo(String tipo, String periodo, String fecha, Model model, Integer fromRow) {
		String consulta = "select id_periodos as \"id_periodos\",nombre as \"nombre\",fecha_inicio as \"fecha_inicio\",fecha_fin as \"fecha_fin\""
				+ ",fecha_cierre as \"fecha_cierre\",estatus as \"estatus\" "
				+ "  from v_sif_cat_periodos where estatus='ACT' ";
		if (!periodo.equals("null")) {
			consulta = consulta.concat("and nombre like '%' || :periodo || '%'");
		}
		if (!fecha.equals("null")) {
			consulta = consulta.concat(" and (to_char(to_date(:fecha,"
					+ " 'yyyy-mm-dd'),'dd/mon/yyyy') between fecha_inicio and fecha_fin )");
		}
		if (tipo.equals("consulta")) {
			consulta = consulta
					.concat(" order by id_periodos desc  OFFSET :fromRow ROWS FETCH NEXT 15 ROWS ONLY");
		}
		Query query = procesoGeneral.getSession().createSQLQuery(consulta)
				.setResultTransformer(Transformers.aliasToBean(ViewPeriodo.class));

		if (!periodo.equals("null")) {
			query.setParameter("periodo", periodo.toUpperCase());
		}
		if (!fecha.equals("null")) {
			query.setParameter("fecha", fecha);
		}
		if (tipo.equals("consulta")) {
			query.setParameter("fromRow", fromRow);
		}
		
		
		if (tipo.equals("count")) {
			model.addAttribute("registros_totales", query.list().size());
		}
		if (tipo.equals("consulta")) {
			model.addAttribute("consulta", query.list());
		}
		model.addAttribute("periodo", periodo);
		model.addAttribute("fecha", fecha);
	}

	@Override
	public void queryDiaPeriodo(String tipo, Integer id_periodo, Model model, String event) {
		String consulta = "";
		Query query = null;
		switch (tipo) {
		case "dia":
			consulta = "select id_periodo as \"id_periodo\",fecha_referencia as \"fecha_referencia\",fecha_calculo as \"fecha_calculo\",fecha_cobro_libra as \"fecha_cobro_libra\",fecha_cobro_sac as \"fecha_cobro_sac\",fecha_contingencia as \"fecha_contingencia\",fecha_cobro as \"fecha_cobro\",fecha_registro_gl as \"fecha_registro_gl\",b_dia_habil as \"b_dia_habil\","
					+ "b_dia_cierre as \"b_dia_cierre\" from TBL_SIF_CAT_DIAS_PERIODO where id_periodo=" + id_periodo;
			query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(ViewPeriodo.class));
			model.addAttribute("consultaDia", query.list());
			model.addAttribute("event", event);

			break;
		case "param":
			consulta = "select id_periodos as \"id_periodos\",nombre as \"nombre\",fecha_inicio as \"fecha_inicio\",fecha_fin as \"fecha_fin\",fecha_cierre as \"fecha_cierre\","
					+ "estatus as \"estatus\",fecha_cre as \"fecha_cre\",fecha_mod as \"fecha_mod\",usuario as \"usuario\",comentarios as \"comentarios\" from tbl_sif_cat_periodo where id_periodos="
					+ id_periodo;
			query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(ViewPeriodo.class));
			model.addAttribute("consulta", query.list());
			model.addAttribute("event", event);

			break;

		default:
			break;
		}

	}

	@Override
	public void listaDiaPeriodo(HttpServletRequest request, String event, String nombre, String fechaInicio, String fechaFin, String fechaCierre,
			Model model, Integer inicio, Integer fin, String secondaryEvent) {
		if (!secondaryEvent.equals("null") && !fechaInicio.equals("null") && !fechaFin.equals("null")) {
			try {
				SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
				Date dateValueStart = input.parse(fechaInicio);
				Date dateValueEnd = input.parse(fechaFin);

				/*
				 * Se aumenta un día a la fecha final
				 */
				// se crear la mascara
				SimpleDateFormat sumarDia = new SimpleDateFormat("dd-MM-yyyy");
				SimpleDateFormat sumarDiaInicial = new SimpleDateFormat("dd-MM-yyyy");
				// se crea el calendario
				Calendar calendario = Calendar.getInstance();
				Calendar calendarioInicial = Calendar.getInstance();
				// se setea el calendario
				calendario.setTime(dateValueEnd);
				calendarioInicial.setTime(dateValueStart);
				// sumar un dia a la fecha
				calendario.add(Calendar.DATE, inicio);
				calendarioInicial.add(Calendar.DATE, fin);
				// se obtiene la fecha con el día ya sumado
				String fechaFinal = sumarDia.format(calendario.getTime());
				String fechaInicial = sumarDiaInicial.format(calendarioInicial.getTime());

				/**
				 * Se establece la fecha de inicio y la fecha final
				 */
				// se definen variables
				Date dateInicio;
				Date dateFin;
				// se formatean variables
				dateInicio = new SimpleDateFormat("dd-MM-yy").parse(fechaInicial);
				dateFin = new SimpleDateFormat("dd-MM-yy").parse(fechaFinal);
				// se genera la columna fechaReferencia
				List<Date> fechaReferencia = new ArrayList<Date>();
				List<Date> listaDos = new ArrayList<Date>();
				List<Date> listaTres = new ArrayList<Date>();
				List<Date> listaCuatro = new ArrayList<Date>();
				List<Date> listaCinco = new ArrayList<Date>();
				List<String> listaDias = new ArrayList<String>();
				// se define el tiempo
				calendario.setTime(dateInicio);
				// recorre el array hasta llegar a la fecha
				while (calendario.getTime().before(dateFin)) {
					Date listaReferencia = calendario.getTime();
					fechaReferencia.add(listaReferencia);
					calendario.add(Calendar.DATE, 1);
					String diaSemanas = new SimpleDateFormat("EEEE", Locale.forLanguageTag("en-EN"))
							.format(listaReferencia);
					listaDias.add(diaSemanas);
					// comienza con la segunda Lista
					DateFormat listaDosDF = new SimpleDateFormat("dd-MM-yyyy");
					String fechaListaDos = listaDosDF.format(listaReferencia);
					SimpleDateFormat sumarDias = new SimpleDateFormat("dd-MM-yyyy");
					calendario.setTime(sumarDias.parse(fechaListaDos));
					calendario.add(Calendar.DATE, 1);
					String fechaFinalListaDos = listaDosDF.format(calendario.getTime());
					Date elementoListaDos = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFinalListaDos);
					String diaSemana = new SimpleDateFormat("EEEE", Locale.forLanguageTag("en-EN"))
							.format(elementoListaDos);

					if (diaSemana.equals("Sunday")) {
						Calendar c = Calendar.getInstance();
						c.setTime(elementoListaDos);
						c.add(Calendar.DATE, 1);
						String fechaFinals = sumarDia.format(c.getTime());
						Date elementoListaDoss = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFinals);
						listaDos.add(elementoListaDoss);
					}
					if (diaSemana.equals("Saturday")) {
						Calendar c = Calendar.getInstance();
						c.setTime(elementoListaDos);
						c.add(Calendar.DATE, 2);
						String fechaFinals = sumarDia.format(c.getTime());
						Date elementoListaA = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFinals);
						listaDos.add(elementoListaA);

					}
					if (!diaSemana.equals("Saturday") && !diaSemana.equals("Sunday")) {
						listaDos.add(elementoListaDos);
					}
					// comienza la tercera lista
					DateFormat listaTresDF = new SimpleDateFormat("dd-MM-yyyy");
					String fechaListaTres = listaTresDF.format(listaReferencia);
					SimpleDateFormat sumarDiaListaTres = new SimpleDateFormat("dd-MM-yyyy");
					calendario.setTime(sumarDiaListaTres.parse(fechaListaTres));
					calendario.add(Calendar.DATE, 1);
					String fechaFinalListaTres = listaTresDF.format(calendario.getTime());
					Date elementoListaTres = new SimpleDateFormat("dd-MM-yyyy").parse(fechaFinalListaTres);
					String diaSemanaTres = new SimpleDateFormat("EEEE", Locale.forLanguageTag("en-EN"))
							.format(elementoListaTres);

					if (diaSemanaTres.equals("Sunday")) {
						Calendar cTres = Calendar.getInstance();
						cTres.setTime(elementoListaTres);
						cTres.add(Calendar.DATE, 2);
						String stringListaTres = sumarDia.format(cTres.getTime());
						Date elementoListaB = new SimpleDateFormat("dd-MM-yyyy").parse(stringListaTres);

						listaTres.add(elementoListaB);

					}
					if (diaSemanaTres.equals("Saturday")) {
						Calendar cTres = Calendar.getInstance();
						cTres.setTime(elementoListaTres);
						cTres.add(Calendar.DATE, 2);
						String stringListaTres = sumarDia.format(cTres.getTime());
						Date elementoListaB = new SimpleDateFormat("dd-MM-yyyy").parse(stringListaTres);
						listaTres.add(elementoListaB);

					}
					if (diaSemanaTres.equals("Monday")) {
						Calendar cTres = Calendar.getInstance();
						cTres.setTime(elementoListaTres);
						cTres.add(Calendar.DATE, 1);
						String stringListaTres = sumarDia.format(cTres.getTime());
						Date elementoListaB = new SimpleDateFormat("dd-MM-yyyy").parse(stringListaTres);
						listaTres.add(elementoListaB);

					}
					if (!diaSemanaTres.equals("Saturday") && !diaSemana.equals("Sunday")
							&& !diaSemana.equals("Monday")) {
						Calendar cTres = Calendar.getInstance();
						cTres.setTime(elementoListaTres);
						String stringListaTres = sumarDia.format(cTres.getTime());
						Date elementoListaB = new SimpleDateFormat("dd-MM-yyyy").parse(stringListaTres);
						listaTres.add(elementoListaB);
					}
					// comienza con la cuarta Lista
					DateFormat listaCuatroDF = new SimpleDateFormat("dd-MM-yyyy");
					String fechaListaCuatro = listaCuatroDF.format(listaReferencia);
					Date elementoListaCuatro = new SimpleDateFormat("dd-MM-yyyy").parse(fechaListaCuatro);
					String diaSemanaCuatro = new SimpleDateFormat("EEEE", Locale.forLanguageTag("en-EN"))
							.format(elementoListaCuatro);

					if (diaSemanaCuatro.equals("Saturday")) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(elementoListaCuatro);
						cal.add(Calendar.DATE, -1);
						Date restar = cal.getTime();
						listaCuatro.add(restar);

					}

					if (diaSemanaCuatro.equals("Sunday")) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(elementoListaCuatro);
						cal.add(Calendar.DATE, -2);
						Date restar = cal.getTime();
						listaCuatro.add(restar);

					}

					if (!diaSemanaCuatro.equals("Saturday") && !diaSemanaCuatro.equals("Sunday")) {
						listaCuatro.add(elementoListaCuatro);
					}
					// comienza con la quinta Lista
					DateFormat listaCincoDF = new SimpleDateFormat("dd-MM-yyyy");
					String fechaListaCinco = listaCincoDF.format(listaReferencia);
					Date elementoListaCinco = new SimpleDateFormat("dd-MM-yyyy").parse(fechaListaCinco);
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(elementoListaCinco);
					cal.add(Calendar.MONTH, -1);
					Date restarMes = cal.getTime();
					listaCinco.add(restarMes);
				}
				if (inicio == 1 && fin == 0) {
					model.addAttribute("listaDia", listaDias);
					model.addAttribute("autoTable", fechaReferencia);
					model.addAttribute("autoTableDos", listaDos);
					model.addAttribute("autoTableCuatro", listaCuatro);
					model.addAttribute("autoTableCinco", listaCinco);
				}

				if (inicio == 2) {
					model.addAttribute("autoTableTres", listaTres);
				}

			} catch (ParseException e) {
				procesoGeneral.loggerErr(mens, request, e);
			}
		}
	}

	@Override
	public void crudDiaPeriodo(HttpServletRequest request, Integer id_periodo, String listUpdate, Model model, String event, String nombre,
			String fechaInicio, String fechaFin, String fechaCierre, String comentarios,String bandera) {
		switch (event) {
		case "insert":
				Integer max_id = procesoGeneral.getId(TablaPeriodo.class, "id_periodos");
				Query insert = procesoGeneral.getSession()
						.createSQLQuery("insert into tbl_sif_cat_periodo values (?, ?,"
								+ " to_date(?,'yyyy-MM-dd'),to_date(?,"
								+ " 'yyyy-MM-dd'),to_date(?,'yyyy-MM-dd'),'ACT',sysdate,sysdate, ?, ?)");
				insert.setParameter(0, max_id);
				insert.setParameter(1, nombre);
				insert.setParameter(2, fechaInicio);
				insert.setParameter(3, fechaFin);
				insert.setParameter(4, fechaCierre);
				insert.setParameter(5, procesoGeneral.getSesionActual());
				insert.setParameter(6, comentarios);
				insert.executeUpdate();
				String[] partrInsert = listUpdate.split(Pattern.quote("||"));
				int numInsert = 1;
				int contador=0;
				String[] banderas=bandera.split(Pattern.quote("||"));
				for (String part : partrInsert) {
					String[] part2 = part.split(Pattern.quote(","));
					
					String fechaReferencia = part2[0];
					String fechaCalculo = part2[1];
					String fechaCobro = part2[2];
					String fechaCobroLibra = part2[3];
					String fechaCobroSac = part2[4];
					String fechaRegistroGl = part2[5];
					String fechaContingencia = part2[6];
					Query query = procesoGeneral.getSession()
							.createSQLQuery("insert into TBL_SIF_CAT_DIAS_PERIODO values (?, to_date(?,'dd/mm/yy'), to_date(?,"
									+ " 'dd/mm/yy'), to_date(?,'dd/mm/yy'), to_date(?,'dd/mm/yy'),to_date(?,"
									+ " 'dd/mm/yy'), to_date(?,'dd/mm/yy'), to_date(?, 'dd/mm/yy'),?,0)");
					query.setParameter(0, max_id);
					query.setParameter(1, fechaReferencia);
					query.setParameter(2, fechaCalculo);
					query.setParameter(3, fechaCobroLibra);
					query.setParameter(4, fechaCobroSac);
					query.setParameter(5, fechaContingencia);
					query.setParameter(6, fechaCobro);
					query.setParameter(7, fechaRegistroGl);
					query.setParameter(8, banderas[contador]);
					query.executeUpdate();
					numInsert++;
					contador++;
				}

			break;
		case "update":
			
				String[] partr = listUpdate.split(Pattern.quote("||"));
				int num = 1;
				int contado=0;
				String[] banderasup=bandera.split(Pattern.quote("||"));
				for (String part : partr) {
					String[] part2 = part.split(Pattern.quote(","));
					String fechaReferencia = part2[0];
					String fechaCalculo = part2[1];
					String fechaCobro = part2[2];
					String fechaCobroLibra = part2[3];
					String fechaCobroSac = part2[4];
					String fechaRegistroGl = part2[5];
					String fechaContingencia = part2[6];
					Query query = procesoGeneral.getSession()
							.createSQLQuery("update tbl_sif_cat_dias_periodo set fecha_calculo=to_date(?,"
									+ " 'dd/mm/yy'),fecha_cobro=to_date(?,'dd/mm/yy'),"
									+ " fecha_cobro_libra=to_date(?,"
									+ " 'dd/mm/yy'),fecha_cobro_sac=to_date(?,"
									+ " 'dd/mm/yy'),fecha_registro_gl=to_date(?,'dd/mm/yy'),"
									+ " fecha_contingencia=to_date(?,'dd/mm/yy'), b_dia_habil=? "
									+ "where id_periodo=? and fecha_referencia=to_date(?,'dd/mm/yy')");
					query.setParameter(0, fechaCalculo);
					query.setParameter(1, fechaCobro);
					query.setParameter(2, fechaCobroLibra);
					query.setParameter(3, fechaCobroSac);
					query.setParameter(4, fechaRegistroGl);
					query.setParameter(5, fechaContingencia);
					query.setParameter(6, banderasup[contado]);
					query.setParameter(7, id_periodo);
					query.setParameter(8, fechaReferencia);
					query.executeUpdate();
					num++;
					contado++;
				}

			break;
		case "delete":
			Query deletePeriodo = procesoGeneral.getSession()
					.createSQLQuery("update tbl_sif_cat_periodo set estatus='CER' where id_periodos=?");
			deletePeriodo.setParameter(0, id_periodo);
			deletePeriodo.executeUpdate();
			break;
		default:
			break;
		}

	}

	@Override
	public void queryCalcularAjuste(String tipo, Model model, HttpServletRequest request, Integer id_periodo,
			Integer ajustePorProceso, Integer fromRow) {
		String consulta = "";
		switch (ajustePorProceso) {
		case 0:

			consulta = "select a.id_fuente as \"id_fuente\", b.clave as  \"clave\", a.estatus as \"estatus\", a.fecha_datos as \"fecha_datos\" from tbl_sif_resumen_adq a, "
					+ "tbl_sif_fuentes b where a.id_fuente = b.id_fuente and fecha_datos in (select fecha_referencia "
					+ "from tbl_sif_cat_dias_periodo where id_periodo = " + id_periodo
					+ ") and a.estatus = 'EXI' group by a.id_fuente, a.estatus, a.fecha_datos, b.clave";
			break;
		case 1:

			consulta = "select p.id_proceso as \"id_proceso\", p.clave_proceso as \"clave_proceso\", n.id_negocio as \"id_negocio\", n.clave as \"clave\", "
					+ "count(s.id_servicios) as \"num_serv\",  " + id_periodo
					+ "  as \"periodo\", (select count(distinct res.id_fuente) from tbl_sif_resumen_adq res, tbl_sif_servicios s2 "
					+ " where res.estatus = 'CNT' and res.id_fuente = s2.id_fuente and s2.id_negocio = n.id_negocio and  fecha_datos in "
					+ "(select fecha_referencia from tbl_sif_cat_dias_periodo where id_periodo = " + id_periodo
					+ "))  as \"num_serv_cont\" "
					+ "from tbl_sif_cat_procesos p, tbl_sif_cat_negocios n, tbl_sif_servicios s where p.id_proceso = n.id_proceso  "
					+ "and s.id_negocio = n.id_negocio and s.estatus = 'ACT' and p.estatus = 'ACT' and n.status = 'ACT' and exists  "
					+ "( select 'X' from tbl_sif_servicios_facturar sf where sf.id_servicio = s.id_servicios and "
					+ "((sf.estatus_calculo = 'CAL'  and s.periodicidad_cobro = 'DIA')  or (s.periodicidad_cobro = 'MEN')) "
					+ "and sf.fecha_datos in (select fecha_referencia from tbl_sif_cat_dias_periodo where id_periodo = "
					+ id_periodo + ") ) " + " group by p.id_proceso, p.clave_proceso,  n.id_negocio, n.clave";
			break;
		default:
			break;
		}

		if (tipo.equals("count")) {
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			model.addAttribute("registros_totales", count.list().size());

		}
		if (tipo.equals("consulta")) {
			consulta = consulta.concat(" OFFSET " + fromRow + " ROWS FETCH NEXT 15 ROWS ONLY");
		}

		Query query = procesoGeneral.getSession().createSQLQuery(consulta)
				.setResultTransformer(Transformers.aliasToBean(BeanCalcularAjuste.class));
		model.addAttribute("consulta", query.list());
	}

	@Override
	public void crudCalcularAjuste(Model model, HttpServletRequest request, Integer id_periodo,
			Integer ajustePorProceso, String lista1, String operacion) {
		String[] objLista = lista1.split(Pattern.quote("||"));

		switch (ajustePorProceso) {
		case 0:
			if (operacion.equals("porFuente")) {

				for (String id : objLista) {
					String consulta = "DECLARE " + "  P_IDFUENTE NUMBER; " + "  P_IDPERIODO NUMBER; "
							+ "  P_USUARIO VARCHAR2(200); " + "  P_COMENTARIOS VARCHAR2(200); "
							+ "  v_Return VARCHAR2(200); " + "BEGIN " + "  P_IDFUENTE \\:\\= ?; "
							+ "  P_IDPERIODO \\:\\= ?; " + "  P_USUARIO \\:\\= ?; "
							+ "  P_COMENTARIOS \\:\\= NULL; "
							+ "  v_Return \\:\\= SIF_CALCULO_MENSUAL.CALCULA_FUENTE( "
							+ "    P_IDFUENTE => P_IDFUENTE, " + "    P_IDPERIODO => P_IDPERIODO, "
							+ "    P_USUARIO => P_USUARIO, " + "    P_COMENTARIOS => P_COMENTARIOS " + "  ); " + "END;";
					Query query = procesoGeneral.getSession().createSQLQuery(consulta);
					query.setParameter(0, id);
					query.setParameter(1, id_periodo);
					query.setParameter(2, procesoGeneral.getSesionActual());
					query.executeUpdate();
				}
			}
			break;
		case 1:
			if (operacion.equals("porProceso")) {
				for (String id : objLista) {
					String consulta = "DECLARE P_IDNEGOCIO NUMBER; " + "P_IDPERIODO NUMBER; "
							+ "P_USUARIO VARCHAR2(200); " + "P_COMENTARIOS VARCHAR2(200); " + "v_Return VARCHAR2(200); "
							+ "BEGIN " + "P_IDNEGOCIO \\:\\= ?; " + "P_IDPERIODO \\:\\= ?; "
							+ "P_USUARIO \\:\\= ?; "
							+ "P_COMENTARIOS \\:\\= NULL; "
							+ "v_Return \\:\\= SIF_CALCULO_MENSUAL.CALCULA_NEGOCIO( P_IDNEGOCIO => P_IDNEGOCIO, P_IDPERIODO => P_IDPERIODO, P_USUARIO => P_USUARIO, P_COMENTARIOS => P_COMENTARIOS );END;";
					Query query = procesoGeneral.getSession().createSQLQuery(consulta);
					query.setParameter(0, id);
					query.setParameter(1, id_periodo);
					query.setParameter(2, procesoGeneral.getSesionActual());
					query.executeUpdate();
				}

			} else if (operacion.equals("deshacer")) {
				for (String id : objLista) {
					String consulta = "DECLARE P_PERIODO NUMBER; P_NEGOCIO NUMBER; v_Return VARCHAR2(200);"
							+ "BEGIN P_PERIODO \\:\\= ?; P_NEGOCIO \\:\\= ?;"
							+ " v_Return \\:\\= PK_SIF_REVERSOS.DESHACER_AJUSTE( P_PERIODO => P_PERIODO, P_NEGOCIO => P_NEGOCIO); END;";
					Query query = procesoGeneral.getSession().createSQLQuery(consulta);
					query.setParameter(0, id_periodo);
					query.setParameter(1, id);
					query.executeUpdate();
				}
			}

			break;

		default:
			break;
		}
	}

	@Override
	public List<TBL_SIF_REBATE> findAllRebate(int id_periodo, int id_moneda) {
		Criteria cr = procesoGeneral.getSession().createCriteria(TBL_SIF_REBATE.class)
				.add(Restrictions.eq("id_periodo", id_periodo)).add(Restrictions.eq("id_moneda", id_moneda));
		return cr.list();
	}

}
