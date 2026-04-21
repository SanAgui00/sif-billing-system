# SIF — Sistema Integrado de Facturación
### Enterprise Billing & Invoicing System

[English](#english) | [Español](#español)

---

## English

### Overview

Enterprise-grade billing and invoicing system built for a financial services company in Mexico. Handles client management, service catalogs, invoice generation (CFDI/SAT compliant), collections, and financial reporting.

Built during my time at **Código Geek S.A.S.** (2019–2021) as part of the backend development team.

### Architecture

**Stack:** Java 8 · Spring MVC 4 · Spring Security 4.2 · Hibernate 4 · Oracle · JSP · jQuery · JasperReports · JBoss

```
src/com/prosa/sif/
├── controller/    → 22 Spring MVC controllers (REST + view rendering)
├── service/       → 20 service classes (business logic layer)
├── dao/           → 20 DAO interfaces + implementations (Hibernate)
├── pojo/          → 203 JPA entities mapped to Oracle tables
├── pk/            → Composite primary key classes
└── operation/     → Shared utilities, Jasper report engine, logging
```

**Frontend:** 151 JSP views organized by module, jQuery for AJAX, Bootstrap for layout.

### Functional Modules

| Module | Description |
|--------|-------------|
| **Catalogs** | Clients, services, pricing tiers, SAT tax categories, logical networks |
| **Invoicing** | Generate, request, and automate CFDI-compliant invoices |
| **Collections** | Daily collection tracking, account statements |
| **Reporting** | JasperReports: client reports, service summaries, treasury, cross-reports |
| **Acquisitions** | Manual and automated service acquisition workflows |
| **Configuration** | Data loading, conversion rules, parameterization |
| **Security** | LDAP authentication with role-based access control |

### Key Technical Highlights

- **Layered MVC architecture** with clean separation: Controller → Service → DAO → Entity
- **Spring Security + LDAP** integration with role-based route protection
- **Hibernate ORM** mapping 203 entities to Oracle tables with composite keys
- **JasperReports** engine generating PDF/Excel reports from SQL queries
- **SAT/CFDI compliance** — Mexican tax authority invoice requirements built into the data model
- **Multi-environment configs** — separate Spring profiles for dev, cert, and production

### Running Locally

> **Note:** This project was designed for Oracle DB + JBoss. The repo is shared as a portfolio artifact demonstrating enterprise Java architecture. See `config.properties.example` for required configuration.

```bash
# Clone
git clone https://github.com/[your-username]/sif.git
cd sif

# Copy and configure
cp config.properties.example config.properties
# Edit config.properties with your LDAP and DB settings

# Build (Maven)
mvn clean package

# Deploy the .war to JBoss/WildFly
```

### What I Built

- Backend services for invoice generation and collection workflows
- DAO layer with Hibernate queries for complex financial data aggregation
- JasperReports integration for automated PDF/Excel report generation
- SQL-based data processing workflows with shell scripting automation
- Code reviews, refactoring, and performance optimization in Agile sprints

---

## Español

### Descripción

Sistema empresarial de facturación y cobranza construido para una empresa del sector financiero en México. Gestiona catálogos de clientes, servicios, generación de facturas (cumplimiento CFDI/SAT), cobranza diaria y reportería financiera.

Desarrollado durante mi trabajo en **Código Geek S.A.S.** (2019–2021) como parte del equipo de desarrollo backend.

### Arquitectura

**Stack:** Java 8 · Spring MVC 4 · Spring Security 4.2 · Hibernate 4 · Oracle · JSP · jQuery · JasperReports · JBoss

```
src/com/prosa/sif/
├── controller/    → 22 controladores Spring MVC
├── service/       → 20 clases de servicio (lógica de negocio)
├── dao/           → 20 interfaces + implementaciones DAO (Hibernate)
├── pojo/          → 203 entidades JPA mapeadas a tablas Oracle
├── pk/            → Claves primarias compuestas
└── operation/     → Utilidades compartidas, motor Jasper, logging
```

### Módulos

| Módulo | Descripción |
|--------|-------------|
| **Catálogos** | Clientes, servicios, precios, categorías SAT, redes lógicas |
| **Facturación** | Generación, solicitud y automatización de facturas CFDI |
| **Cobranza** | Seguimiento diario, estados de cuenta |
| **Reportes** | JasperReports: clientes, servicios, tesorería, reportes cruzados |
| **Adquisiciones** | Flujos de adquisición manuales y automáticos |
| **Parametrización** | Carga de datos, reglas de conversión |
| **Seguridad** | Autenticación LDAP con control de acceso por roles |

### Lo que construí

- Servicios backend para generación de facturas y flujos de cobranza
- Capa DAO con consultas Hibernate para agregación de datos financieros complejos
- Integración de JasperReports para generación automatizada de reportes PDF/Excel
- Flujos de procesamiento de datos basados en SQL con automatización por shell scripting
- Code reviews, refactoring y optimización de rendimiento en sprints Agile

---

### License

This repository is shared for portfolio and educational purposes. The original codebase was developed at Código Geek S.A.S. All client-specific data, credentials, and internal configurations have been removed.

### Contact

**Alfonso Sánchez** — Software Development Engineer
- Email: ing.jasanchezaguilar@gmail.com
- Phone: (986) 837-5002
- Location: Boise, Idaho
