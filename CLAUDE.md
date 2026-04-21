# CLAUDE.md — SIF (Sistema Integrado de Facturación)

## Contexto
Proyecto Java enterprise construido en Código Geek S.A.S. (2018-2020) para un cliente del sector financiero mexicano.
Sistema de facturación, cobranza, estados de cuenta y reportes con arquitectura MVC completa.
El objetivo es limpiar este repo para portafolio público en GitHub — NO es para deploy en producción.

## Stack Original
- Java 8 + Spring MVC 4.x + Spring Security 4.2.3
- Hibernate 4 (ORM) + Oracle 10g
- JSP + jQuery + Bootstrap (frontend)
- JasperReports (PDF/Excel reporting)
- JBoss/WildFly (app server)
- LDAP authentication
- Ant build (build.xml)

## TAREAS DE SANITIZACIÓN (ejecutar EN ORDEN)

### 1. ELIMINAR CREDENCIALES Y DATOS SENSIBLES — CRÍTICO
Archivos con credenciales LDAP que DEBEN limpiarse:
```
webapp/WEB-INF/spring-security.xml
configFiles/sifCert/spring-security.xml
configFiles/sifProd/spring-security.xml
```

En CADA archivo, reemplazar:
- `manager-password="<REDACTED>"` → `manager-password="${ldap.password}"`
- `url="ldap://<REDACTED-IP>:<PORT>"` → `url="${ldap.url}"`
- `url="ldap://<REDACTED-HOST>"` → `url="${ldap.url}"`
- `manager-dn="<REDACTED>"` → `manager-dn="${ldap.manager.dn}"`
- `user-search-base="<REDACTED>"` → `user-search-base="${ldap.search.base}"`
- `group-search-base="<REDACTED>"` → `group-search-base="${ldap.group.base}"`
- Lo mismo para `group-search-base` en prod

### 2. ELIMINAR BUILD ARTIFACTS
```bash
rm -rf build/
```

### 3. CREAR .gitignore
```
# Compiled
build/
*.class
*.jar
*.war

# IDE
.settings/
.classpath
.project
*.iml
.idea/

# Config con credenciales
configFiles/sifProd/
configFiles/sifCert/

# OS
.DS_Store
Thumbs.db
```

### 4. CREAR .env.example o properties.example
Crear `config.properties.example`:
```properties
# LDAP Configuration
ldap.url=ldap://localhost:389
ldap.manager.dn=cn=admin,dc=example,dc=com
ldap.password=changeme
ldap.search.base=dc=example,dc=com
ldap.group.base=ou=Groups,dc=example,dc=com

# Database (JNDI)
db.jndi.name=jdbc/sif
db.dialect=org.hibernate.dialect.Oracle10gDialect
```

### 5. AGREGAR SOPORTE H2 PARA DEMO LOCAL (OPCIONAL)
En `webapp/WEB-INF/hibernate.cfg.xml`:
- Agregar un perfil de desarrollo con H2 in-memory como alternativa a Oracle
- Crear `schema.sql` con las tablas principales (al menos 5-6 tablas core: clientes, facturas, servicios, negocios, usuarios, cobranza)
- Crear `data.sql` con datos dummy

### 6. MODERNIZAR BUILD SYSTEM
Crear `pom.xml` (Maven) para reemplazar Ant. Dependencias principales:
- spring-webmvc 4.3.x
- spring-security-web 4.2.x
- spring-security-ldap 4.2.x
- hibernate-core 4.3.x
- jasperreports 6.x
- javax.servlet-api 3.1
- h2 (scope: test/dev)

### 7. NO MODIFICAR
- NO cambiar la lógica de negocio en controllers/services/DAOs
- NO cambiar los nombres de las clases POJO (son mapeos directos a tablas)
- NO eliminar los headers de "Código Geek" — son atribución legítima
- NO cambiar la estructura de paquetes
- NO renombrar el proyecto — mantenerlo como "SIF"

## Estructura del Proyecto
```
src/com/prosa/sif/
├── controller/    # 22 Spring MVC controllers
├── service/       # 20 service classes (business logic)
├── dao/           # 20 interfaces + 20 implementations (Hibernate)
├── pojo/          # 203 JPA entities (table mappings)
├── pk/            # Composite primary keys
└── operation/     # ProcesoGeneral (utilities, Jasper, logging)

webapp/
├── jsp/           # 151 JSP views organized by módulo
│   ├── catalogo/  # Catálogos SAT, clientes, servicios, precios
│   ├── facturas/  # Generación, solicitud, automatización
│   ├── reportes/  # Estados de cuenta, cobranza, ODT
│   └── ...
├── jasper/        # 10+ JasperReports templates (.jrxml)
├── js/            # JavaScript por módulo
├── css/           # Estilos
└── WEB-INF/       # Spring configs, Hibernate, Security
```

## Módulos Funcionales
1. **Catálogos** — Clientes, servicios, negocios, precios, redes lógicas, estructura de datos
2. **Facturación** — Generar, solicitar, automatizar facturas (CFDI/SAT compliant)
3. **Cobranza** — Cobranza diaria, estados de cuenta
4. **Reportes** — JasperReports: clientes, servicios, ODT, cross, tesorería
5. **Adquisiciones** — Manuales y automáticas
6. **Parametrización** — Carga de datos, reglas de conversión
7. **Seguridad** — LDAP + roles (ROLE_ADMIN_MOD_ADQ, ROLE_MOD_ADQ_ADMINISTRADOR)

## Reglas de Código
- Código existente: NO refactorizar — solo sanitizar
- Nuevos archivos (README, configs): comentar el "por qué", no el "qué"
- Commits: fix/docs/chore prefix
- Encoding: archivos originales en ISO-8859-1, convertir a UTF-8 si se tocan

## Contacto
- Alfonso Sánchez — ing.jasanchezaguilar@gmail.com
- Boise, Idaho
