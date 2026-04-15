-- Datos dummy para demo local con H2
-- No representan clientes o empresas reales

INSERT INTO TBL_SIF_CAT_CENTRO_COSTOS (id_centro_costos, clave, descripcion, usuario, estatus, fecha_cre, fecha_mod)
VALUES (1, 'CC-001', 'Centro de Costos Corporativo', 'admin', 'A', CURRENT_DATE, CURRENT_DATE),
       (2, 'CC-002', 'Centro de Costos Operaciones', 'admin', 'A', CURRENT_DATE, CURRENT_DATE);

INSERT INTO TBL_SIF_CAT_EMPRESAS (id_empresa, clave_empresa, razon_social, rfc, tel1, email, usuario, estatus, fecha_cre, fecha_mod, version_cfdi_sat)
VALUES (1, 'EMP-DEMO', 'Empresa Demo S.A. de C.V.', 'EDM010101AAA', '5550001234', 'contacto@demo.com', 'admin', 'A', CURRENT_DATE, CURRENT_DATE, '3.3');

INSERT INTO TBL_SIF_CAT_CLIENTES (id_cliente, clave_cliente, nombre_corto, razon_social, rfc, pct_iva, usuario, estatus, fecha_mod)
VALUES (1, 'CLI-001', 'Cliente Alfa', 'Cliente Alfa S.A. de C.V.', 'CAL010101AAA', 16.00, 'admin', 'A', CURRENT_DATE),
       (2, 'CLI-002', 'Cliente Beta', 'Cliente Beta S.A. de C.V.', 'CBE020202BBB', 16.00, 'admin', 'A', CURRENT_DATE),
       (3, 'CLI-003', 'Cliente Gamma', 'Gamma Corporativo S.A.', 'CGA030303CCC', 16.00, 'admin', 'I', CURRENT_DATE);

INSERT INTO TBL_SIF_CAT_NEGOCIOS (id_negocio, id_proceso, id_centro_costos, clave, descripcion, usuario, status, fecha_cre, fecha_mod, clave_metodopago_sat, clave_usocfdi_sat)
VALUES (1, 1, 1, 'NEG-PROC', 'Procesamiento de Transacciones', 'admin', 'A', CURRENT_DATE, CURRENT_DATE, 'PPD', 'G03'),
       (2, 2, 1, 'NEG-COMP', 'Compensacion Interbancaria', 'admin', 'A', CURRENT_DATE, CURRENT_DATE, 'PPD', 'G03'),
       (3, 3, 2, 'NEG-RED', 'Renta de Red', 'admin', 'A', CURRENT_DATE, CURRENT_DATE, 'PUE', 'G03');

INSERT INTO TBL_SIF_CAT_SERVICIOS (id_servicio, id_negocio, clave_servicio, descripcion, unidad, precio_unitario, pct_descuento, usuario, estatus, fecha_cre, fecha_mod)
VALUES (1, 1, 'SRV-TRX', 'Transaccion de Procesamiento', 'TRX', 0.50, 0.00, 'admin', 'A', CURRENT_DATE, CURRENT_DATE),
       (2, 1, 'SRV-MENS', 'Mensualidad de Red', 'MES', 5000.00, 5.00, 'admin', 'A', CURRENT_DATE, CURRENT_DATE),
       (3, 2, 'SRV-COMP', 'Compensacion por Transaccion', 'TRX', 0.25, 0.00, 'admin', 'A', CURRENT_DATE, CURRENT_DATE);

INSERT INTO TBL_SIF_FACTURAS (id_factura, id_cliente, id_negocio, id_moneda, id_centro_costos, id_periodo, folio, fecha_datos, total_importe_neto, porc_iva_cliente, total_importe_iva, tipo_cambio, total_desc_especial, total_desc_adic_vol, total_importe_liquidado, total_iva_liquidado, razon_social_cliente, rfc_cliente, usuario, estatus, fecha_cre, fecha_mod)
VALUES (1, 1, 1, 1, 1, 202401, 'SIF-2024-00001', '2024-01-31', 50000.00, 16.00, 8000.00, 1.0000, 0.00, 0.00, 58000.00, 9280.00, 'Cliente Alfa S.A. de C.V.', 'CAL010101AAA', 'admin', 'A', '2024-01-31', '2024-01-31'),
       (2, 2, 1, 1, 1, 202401, 'SIF-2024-00002', '2024-01-31', 32000.00, 16.00, 5120.00, 1.0000, 0.00, 0.00, 37120.00, 5939.20, 'Cliente Beta S.A. de C.V.', 'CBE020202BBB', 'admin', 'A', '2024-01-31', '2024-01-31'),
       (3, 1, 2, 1, 1, 202402, 'SIF-2024-00003', '2024-02-29', 48500.00, 16.00, 7760.00, 1.0000, 500.00, 0.00, 55760.00, 8921.60, 'Cliente Alfa S.A. de C.V.', 'CAL010101AAA', 'admin', 'B', '2024-02-29', '2024-02-29');
