-- Schema H2 para demo local — tablas core del SIF
-- Equivalente simplificado del esquema Oracle original

CREATE TABLE IF NOT EXISTS TBL_SIF_CAT_CLIENTES (
    id_cliente          INTEGER PRIMARY KEY,
    clave_cliente       VARCHAR(50),
    id_grupo_vol        INTEGER,
    id_domicilio        INTEGER,
    nombre_corto        VARCHAR(100),
    razon_social        VARCHAR(200),
    rfc                 VARCHAR(20),
    curp                VARCHAR(20),
    fiid                DECIMAL(18,2),
    pct_iva             DECIMAL(5,2),
    telefono_pric       VARCHAR(20),
    b_cliente_consorcio DECIMAL(1,0),
    b_cliente_nacional  DECIMAL(1,0),
    b_cliente_socio     DECIMAL(1,0),
    b_incluir_rebate    DECIMAL(1,0),
    inf_addicional      VARCHAR(500),
    inf_addicional_1    VARCHAR(500),
    usuario             VARCHAR(50),
    estatus             VARCHAR(1),
    fecha_mod           DATE,
    comentarios         VARCHAR(500),
    clave_formapago_sat VARCHAR(10),
    clave_residfiscal_sat VARCHAR(10),
    numero_idfiscal_sat VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS TBL_SIF_CAT_EMPRESAS (
    id_empresa          INTEGER PRIMARY KEY,
    clave_empresa       VARCHAR(50),
    razon_social        VARCHAR(200),
    curp                VARCHAR(20),
    rfc                 VARCHAR(20),
    tel1                VARCHAR(20),
    tel2                VARCHAR(20),
    fax                 VARCHAR(20),
    representante_legal VARCHAR(200),
    email               VARCHAR(100),
    id_domicilio        INTEGER,
    usuario             VARCHAR(50),
    estatus             VARCHAR(1),
    fecha_cre           DATE,
    fecha_mod           DATE,
    comentarios         VARCHAR(500),
    regimen_fiscal      VARCHAR(100),
    lugar_expedicion    VARCHAR(100),
    version_cfdi_sat    VARCHAR(10),
    clave_regfiscal_sat VARCHAR(10),
    clave_lugarexp_sat  VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS TBL_SIF_CAT_NEGOCIOS (
    id_negocio          INTEGER PRIMARY KEY,
    id_proceso          INTEGER,
    id_centro_costos    INTEGER,
    id_negocio_padre    INTEGER,
    id_grupo_edo_cuenta INTEGER,
    clave               VARCHAR(50),
    descripcion         VARCHAR(200),
    cuenta_ingreso      VARCHAR(50),
    clave_gl            VARCHAR(50),
    usuario             VARCHAR(50),
    status              VARCHAR(1),
    fecha_cre           DATE,
    fecha_mod           DATE,
    comentarios         VARCHAR(500),
    concepto_carta      VARCHAR(200),
    clave_metodopago_sat VARCHAR(10),
    clave_usocfdi_sat   VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS TBL_SIF_FACTURAS (
    id_factura              INTEGER PRIMARY KEY,
    id_cliente              INTEGER,
    id_negocio              INTEGER,
    id_moneda               INTEGER,
    id_centro_costos        INTEGER,
    id_periodo              INTEGER,
    folio                   VARCHAR(50),
    fecha_datos             DATE,
    total_importe_neto      DECIMAL(18,2),
    porc_iva_cliente        DECIMAL(5,2),
    total_importe_iva       DECIMAL(18,2),
    tipo_cambio             DECIMAL(10,4),
    total_desc_especial     DECIMAL(18,2),
    total_desc_adic_vol     DECIMAL(18,2),
    total_importe_liquidado DECIMAL(18,2),
    total_iva_liquidado     DECIMAL(18,2),
    id_carta_impresa        INTEGER,
    id_contacto_cliente     INTEGER,
    razon_social_cliente    VARCHAR(200),
    rfc_cliente             VARCHAR(20),
    direccion_cliente       VARCHAR(500),
    nombre_contacto_cliente VARCHAR(200),
    comentarios             VARCHAR(500),
    usuario                 VARCHAR(50),
    estatus                 VARCHAR(1),
    fecha_mod               DATE,
    fecha_cre               DATE,
    fecha_cancelacion       DATE
);

CREATE TABLE IF NOT EXISTS TBL_SIF_CAT_SERVICIOS (
    id_servicio         INTEGER PRIMARY KEY,
    id_negocio          INTEGER,
    clave_servicio      VARCHAR(50),
    descripcion         VARCHAR(200),
    unidad              VARCHAR(50),
    precio_unitario     DECIMAL(18,4),
    pct_descuento       DECIMAL(5,2),
    usuario             VARCHAR(50),
    estatus             VARCHAR(1),
    fecha_cre           DATE,
    fecha_mod           DATE,
    comentarios         VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS TBL_SIF_CAT_CENTRO_COSTOS (
    id_centro_costos    INTEGER PRIMARY KEY,
    clave               VARCHAR(50),
    descripcion         VARCHAR(200),
    usuario             VARCHAR(50),
    estatus             VARCHAR(1),
    fecha_cre           DATE,
    fecha_mod           DATE
);
