/**
################################################################################
# Autor               : Loredo                                                 #
# Compania            : Código Geek                                            #
# Proyecto/Procliente :                                      Fecha: 08/03/2018 #
# Descripcion General : 										               #
# Marca del cambio    : 									                   #
################################################################################
**/

package com.prosa.sif.dao;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.prosa.sif.operation.ProcesoGeneral;
import com.prosa.sif.pojo.BeanCalculaCobranza;
import com.prosa.sif.pojo.TablaBitacora;
import com.prosa.sif.pojo.TablaEmpresa;
import com.prosa.sif.pojo.ViewAdquisicionAuto;
import com.prosa.sif.pojo.ViewTiposCambio;

@Repository
@Transactional
@SuppressWarnings("all")
public class CobranzaDaoImpl implements CobranzaDao {
	@Autowired
	private ProcesoGeneral procesoGeneral;

	@Override
	public void queryCobranza(Model model, HttpServletRequest request, Integer id_fuente, Integer id_servicio,
			Integer flag, String fecha_inicial, String fecha_final, Integer fromRow) {
		String consulta = "";
		
		switch (flag) {
		case 0:
			consulta = "select ra.id_fuente as \"id_fuente\" , f.clave as \"clave\" , ra.descripcion_evento as \"descripcion_evento\" ,"
					+ " ra.total_trans_leidas as \"total_trans_leidas\" , ra.total_trans_conv as \"total_trans_conv\" , ra.total_trans_nconv as "
					+ "\"total_trans_nconv\" , ra.estatus as \"estatus\" , ra.fecha_datos as \"fecha_datos\",  ra.fecha_base_contingencia as"
					+ " \"fecha_base_contingencia\", ra.fecha_ajuste as \"fecha_ajuste\" from tbl_sif_resumen_adq ra, tbl_sif_fuentes f  "
					+ "where ra.id_fuente = f.id_fuente and ra.estatus in ('EXI','CNT')  and ra.fecha_datos between to_date(?,"
					+ " 'YYYY-MM-DD')" + "and to_date(?,'YYYY-MM-DD')"
					+ "and f.id_fuente = ?  union select f.id_fuente as id_fuente, f.clave as clave ,"
					+ "'Adquisicion Manual' as descripcion_evento ,count(1) as total_trans_leidas ,count(1) as total_trans_conv ,0 as total_trans_nconv,"
					+ " 'MAN' as estatus ,sf.fecha_datos as fecha_datos ,NULL as fecha_base_contingencia ,NULL as fecha_ajuste from tbl_sif_servicios_facturar "
					+ "sf, tbl_sif_servicios s, tbl_sif_fuentes f where sf.id_servicio = s.id_servicios and f.id_fuente = s.id_fuente "
					+ "and sf.fecha_datos between to_date(?,'YYYY-MM-DD')" + "and to_date(?,"
					+ " 'YYYY-MM-DD')" + "and " + "sf.estatus = 'MAN' and f.id_fuente = ?"
					+ " group by f.id_fuente, f.clave, sf.fecha_datos order by 8 desc ";
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			count.setParameter(0, fecha_inicial);
			count.setParameter(1, fecha_final);
			count.setParameter(2, id_fuente);
			count.setParameter(3, fecha_inicial);
			count.setParameter(4, fecha_final);
			count.setParameter(5, id_fuente);
			model.addAttribute("registros_totales", count.list().size());
			consulta = consulta.concat(" OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY");
			
			Query query = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanCalculaCobranza.class));
			query.setParameter(0, fecha_inicial);
			query.setParameter(1, fecha_final);
			query.setParameter(2, id_fuente);
			query.setParameter(3, fecha_inicial);
			query.setParameter(4, fecha_final);
			query.setParameter(5, id_fuente);
			query.setParameter(6, fromRow);
			model.addAttribute("consulta", query.list());

			break;
		case 1:
			consulta = "select b.clave as \"clave\",a.id_servicio as \"id_servicio\",b.descripcion as \"descripcion\",a.fecha_datos as \"fecha_datos\", a.estatus as \"estatus\", a.estatus_calculo as \"estatus_calculo\","
					+ "sum(nvl(a.total_trans_emisor,0)) as \"total_trans_emisor\", sum(nvl(a.total_trans_adq,0)) as \"total_trans_adq\","
					+ "sum(nvl(a.costo_servicio,0)) as \"costo_servicio\"  from tbl_sif_servicios_facturar a, tbl_sif_servicios b,"
					+ "tbl_sif_cat_clientes c  where a.id_servicio = b.id_servicios and c.id_cliente = a.id_cliente and "
					+ "a.estatus_cobro in ('PEN','NO') and a.estatus_factura in ('PEN','NO') and a.estatus_registro_contable in "
					+ "('PEN','NO') and a.estatus not in('ELI') and a.id_servicio = ?"
					+ "  and a.fecha_datos " + "between to_date(?,'YYYY-MM-DD') and to_date(?,"
					+ " 'YYYY-MM-DD')  "
					+ "group by b.clave,a.id_servicio,b.descripcion,a.fecha_datos, a.estatus, a.estatus_calculo "
					+ "order by b.clave, a.fecha_datos desc";
			Query count2 = procesoGeneral.getSession().createSQLQuery(consulta);
			count2.setParameter(0, id_servicio);
			count2.setParameter(1, fecha_inicial);
			count2.setParameter(2, fecha_final);
			model.addAttribute("registros_totales", count2.list().size());
			consulta = consulta.concat(" OFFSET ? ROWS FETCH NEXT 15 ROWS ONLY");
			
			Query query1 = procesoGeneral.getSession().createSQLQuery(consulta)
					.setResultTransformer(Transformers.aliasToBean(BeanCalculaCobranza.class));
			query1.setParameter(0, id_servicio);
			query1.setParameter(1, fecha_inicial);
			query1.setParameter(2, fecha_final);
			query1.setParameter(3, fromRow);
			model.addAttribute("consulta", query1.list());
			
			break;
		default:
			break;
		}

	}

	@Override
	public void crudCobranza(Model model, HttpServletRequest request, String cadena, String evento, Integer flag) {
		
		Query query;
		String[] listArray = cadena.split(Pattern.quote("||"));
		
		switch (evento) {
		case "pendiente":
			for (String subArray : listArray) {
				String[] porComa = subArray.split(Pattern.quote(","));
				
				String fechaDatos = porComa[1];
				query = procesoGeneral.getSession().createSQLQuery(
						"declare p_fechacalculo date; v_return number; begin p_fechacalculo \\:\\= to_date(?,"
								+ " 'dd-mm-yyyy'); v_return \\:\\= sif_calculos.calcula_pendientes( p_fechacalculo => p_fechacalculo ); end;");
				query.setParameter(0, fechaDatos);
				query.executeUpdate();
				
			}
			break;
		case "deshacer":
			if (flag == 0) {

				for (String subArray : listArray) {
					String[] porComa = subArray.split(Pattern.quote(","));
					String fuente = porComa[0];
					
					query = procesoGeneral.getSession().createSQLQuery(
							"declare p_fecha_ini date; p_fecha_fin date; p_fuente number; p_servicio number; v_return varchar2(200); begin p_fecha_ini \\:\\= null; p_fecha_fin \\:\\= null; p_fuente \\:\\= ?;"
									+ " p_servicio \\:\\= null; v_return \\:\\= pk_sif_servicios_facturar.deshacer_calculo( p_fecha_ini => p_fecha_ini, p_fecha_fin => p_fecha_fin, p_fuente => p_fuente, p_servicio => p_servicio );end;");
					query.setParameter(0, fuente);
					query.executeUpdate();

				}

			} else if (flag == 1) {
				for (String subArray : listArray) {
					String[] porComa = subArray.split(Pattern.quote(","));
					String servicio = porComa[0];
					
					query = procesoGeneral.getSession().createSQLQuery(
							"declare p_fecha_ini date; p_fecha_fin date; p_fuente number; p_servicio number; v_return varchar2(200); begin p_fecha_ini \\:\\= null; p_fecha_fin \\:\\= null; p_fuente \\:\\= null; p_servicio \\:\\= ?;"
									+ " v_return \\:\\= pk_sif_servicios_facturar.deshacer_calculo( p_fecha_ini => p_fecha_ini, p_fecha_fin => p_fecha_fin, p_fuente => p_fuente, p_servicio => p_servicio );end;");
					query.setParameter(0, servicio);
					query.executeUpdate();

				}

			}
			break;
		case "recalcular":
			
			if (flag == 0) {
				for (String subArray : listArray) {
					String[] porComa = subArray.split(Pattern.quote(","));
					String fuente = porComa[0];
					String fechaDatos = porComa[1];
					query = procesoGeneral.getSession().createSQLQuery(
							"declare p_idfuente number; p_fechacalculo date; v_return number; begin p_idfuente \\:\\= ?;"
									+ " p_fechacalculo \\:\\= to_date(?,"
									+ " 'dd-mm-yyyy'); v_return \\:\\= sif_calculos.calcula_fuente( p_idfuente => p_idfuente,p_fechacalculo => p_fechacalculo);end;");
					query.setParameter(0, fuente);
					query.setParameter(1, fechaDatos);
					query.executeUpdate();

				}

			} else if (flag == 1) {
				for (String subArray : listArray) {
					String[] porComa = subArray.split(Pattern.quote(","));
					String servicio = porComa[0];
					String fechaDatos = porComa[1];
					query = procesoGeneral.getSession().createSQLQuery(
							"declare p_idservicio number; p_fechacalculo date; v_return number; begin p_idservicio \\:\\= ?;"
									+ " p_fechacalculo \\:\\= to_date(?,"
									+ " 'dd-mm-yyyy'); v_return \\:\\= sif_calculos.calcula_servicio( p_idservicio => p_idservicio, p_fechacalculo => p_fechacalculo );end;");
					query.setParameter(0, servicio);
					query.setParameter(1, fechaDatos);
					query.executeUpdate();
				}
			}

			break;
		default:
			break;
		}

	}

	@Override
	public void queryTipoCambio(Model model, String id_moneda, String id_periodo) {
		int id_moneda1 = Integer.parseInt(id_moneda);
		int id_periodo1 = Integer.parseInt(id_periodo);
		
		Query query = procesoGeneral.getSession().createQuery(
				"FROM ViewTiposCambio WHERE id_moneda = :id_moneda and id_periodo = :id_periodo");
		query.setParameter("id_moneda", id_moneda1);
		query.setParameter("id_periodo", id_periodo1);
		model.addAttribute("consulta", query.list());
	}

	@Override
	public void actualizariposCambio(String variables) {
		
		String[] Actualizar = variables.split("#");
		
		for (int i = 1; i < Actualizar.length; i++) {
			String[] string = Actualizar[i].split(",");
			double tipo_cambio = Double.parseDouble(string[1]);
			int id_moneda1 = Integer.parseInt(Actualizar[0]);
			String fecha =string[0];
			
			Query query = procesoGeneral.getSession()
					.createSQLQuery("update TBL_SIF_TIPOS_CAMBIO set tipo_cambio=:tipo_cambio where id_moneda=:id_moneda1"
							+ " and fecha_tipo_cambio=to_date(:date,'DD-MM-YY')");
			query.setParameter("tipo_cambio", tipo_cambio);
			query.setParameter("id_moneda1", id_moneda1);
			query.setParameter("date", fecha);
			query.executeUpdate();
		}

	}

	@Override
	public void queryBitacora(String tipo, Model model, HttpServletRequest request, Integer fromRow,
			String fecha_inicial, String fecha_final, String usuario) {
		switch (tipo) {
		case "consulta":
			String consulta = "select hora as \"hora\",codigo as \"codigo\",usuario as \"usuario\",descripcion as \"descripcion\",procedimiento as \"procedimiento\" from tbl_sif_bitacora where 1=1 ";
			if (!(usuario.equals("null"))) {
				consulta = consulta.concat(" and upper(usuario)=upper(:usuario) ");
			}
			if (!(fecha_inicial.equals("null")) && !(fecha_final.equals("null"))) {
				consulta = consulta.concat(" and trunc(hora)  between to_date(:fecha_inicial,"
						+ " 'YYYY-MM-DD') and to_date(:fecha_final,'YYYY-MM-DD')");
			}
			Query count = procesoGeneral.getSession().createSQLQuery(consulta);
			consulta = consulta.concat("order by hora desc  OFFSET :fromRow ROWS FETCH NEXT 15 ROWS ONLY");
			Query queryConsulta = procesoGeneral.getSession().createSQLQuery(consulta);
			if (!(usuario.equals("null"))) {
				count.setParameter("usuario", usuario);
				queryConsulta.setParameter("usuario", usuario);
				}
			count.setParameter("fecha_inicial", fecha_inicial);
			count.setParameter("fecha_final", fecha_final);
			model.addAttribute("registros_totales", count.list().size());
			
			queryConsulta.setParameter("fecha_inicial", fecha_inicial);
			queryConsulta.setParameter("fecha_final", fecha_final);
			queryConsulta.setParameter("fromRow", fromRow);
			queryConsulta.setResultTransformer(Transformers.aliasToBean(TablaBitacora.class));
			model.addAttribute("consulta", queryConsulta.list());

			break;

		default:
			break;
		}
	}

}
