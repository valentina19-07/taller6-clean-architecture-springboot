# Backend Spring Boot – Clean Architecture

API REST en Spring Boot (Java 25, Gradle) con 3 módulos: **Users, Products y Books**.

## Arquitectura

| Capa | Paquete | Responsabilidad |
|---|---|---|
| Domain | `domain.entity`, `domain.repository` | Entidades y contratos (clases abstractas). No depende de nada. |
| Application | `application.usecase` | Casos de uso. Dependen solo de los contratos. |
| Infrastructure | `infrastructure.controller`, `.repository`, `.datasource` | Controllers REST, implementaciones de repositorio y fuentes de datos (JavaFaker). |
| Config | `config` | `AppConfig` (inyección de dependencias) y `CorsConfig`. |

Flujo: `Controller -> Caso de uso -> Repositorio (contrato) -> Repositorio Impl -> Datasource`.

**Inyección de dependencias:** cada implementación se registra como `@Bean` en `AppConfig`;
Spring la entrega al controller por constructor.

## Ejecución

Requiere JDK 25.

```bash
./gradlew bootRun
```

Servidor: `http://localhost:8080` (context-path `/api`).

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/users/{countUsers}` | Lista de usuarios |
| GET | `/api/products/{countProducts}` | Lista de productos |
| GET | `/api/books/{countBooks}` | Lista de libros |

Swagger/OpenAPI: `http://localhost:8080/api/swagger-ui/index.html`

## Integrantes

Juan · Valen