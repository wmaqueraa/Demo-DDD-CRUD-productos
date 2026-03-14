# 🛒 Demo DDD CRUD - Productos & Clientes API

API REST desarrollada con **Spring Boot** siguiendo los principios de **Domain-Driven Design (DDD)**, que permite gestionar Productos y Clientes con operaciones CRUD completas.

---

## 🚀 Tecnologías

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- PostgreSQL
- HikariCP (Connection Pool)
- Flyway (Migraciones de BD)
- MapStruct (Mapeo de objetos)
- Lombok
- Maven

---

## 📁 Estructura del Proyecto

```
src/main/java/com/example/productosapi/
├── application/
│   └── usecase/                  # Casos de uso
│       ├── CreateClienteUseCase
│       ├── GetClienteUseCase
│       ├── UpdateClienteUseCase
│       └── DeleteClienteUseCase
├── domain/
│   ├── model/                    # Entidades del dominio
│   │   ├── Producto.java
│   │   └── Cliente.java
│   ├── repository/               # Interfaces de repositorio
│   │   ├── ProductoRepository
│   │   └── ClienteRepository
│   └── service/                  # Servicios del dominio
│       ├── ProductoService
│       └── ClienteService
└── infrastructure/
    ├── persistence/              # Capa de persistencia
    │   ├── entity/
    │   ├── mapper/
    │   └── repository/
    └── rest/                     # Capa REST
        ├── controller/
        └── dto/
```

---

## ⚙️ Configuración

### Requisitos previos
- Java 17+
- Maven 3.6+
- PostgreSQL 15+

### Variables de entorno (`application.properties`)

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tu_base_de_datos
spring.datasource.username=postgres
spring.datasource.password=tu_contraseña
server.port=8000
```

---

## ▶️ Ejecutar el proyecto

```bash
# Clonar el repositorio
git clone https://github.com/wmaqueraa/Demo-DDD-CRUD-productos.git

# Entrar al directorio
cd Demo-DDD-CRUD-productos

# Ejecutar con Maven
mvn spring-boot:run
```

La API estará disponible en: `http://localhost:8000`

---

## 📌 Endpoints - Clientes

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/clientes` | Crear cliente |
| `GET` | `/api/clientes` | Listar todos los clientes |
| `GET` | `/api/clientes/{id}` | Obtener cliente por ID |
| `GET` | `/api/clientes/dni/{numeroDni}` | Obtener cliente por DNI |
| `GET` | `/api/clientes/estado/{activo}` | Listar clientes por estado |
| `GET` | `/api/clientes/sexo/{sexo}` | Listar clientes por sexo |
| `PUT` | `/api/clientes/{id}` | Actualizar cliente |
| `PATCH` | `/api/clientes/{id}/estado` | Cambiar estado del cliente |
| `DELETE` | `/api/clientes/{id}` | Eliminar cliente |

### Ejemplo POST `/api/clientes`

```json
{
    "apellidoPaterno": "DIAZ",
    "apellidoMaterno": "MORI",
    "nombres": "LOURDES HAYDEE",
    "numeroDni": "00793989",
    "telefono": "952336830",
    "sexo": "MUJER",
    "activo": true,
    "fechaNacimiento": "1978-02-11T00:00:00"
}
```

### Ejemplo PUT `/api/clientes/{id}`

```json
{
    "apellidoPaterno": "DIAZ",
    "apellidoMaterno": "MORI",
    "nombres": "LOURDES HAYDEE",
    "telefono": "952336830",
    "sexo": "MUJER",
    "fechaNacimiento": "1978-02-11T00:00:00"
}
```

### Ejemplo PATCH `/api/clientes/{id}/estado`

```json
{
    "activo": false
}
```

---

## 📌 Endpoints - Productos

| Método | Endpoint | Descripción |
|--------|----------|-------------|
| `POST` | `/api/productos` | Crear producto |
| `GET` | `/api/productos` | Listar todos los productos |
| `GET` | `/api/productos/{id}` | Obtener producto por ID |
| `GET` | `/api/productos/codigo/{codigo}` | Obtener producto por código |
| `GET` | `/api/productos/categoria/{categoria}` | Listar por categoría |
| `PUT` | `/api/productos/{id}` | Actualizar producto |
| `PATCH` | `/api/productos/{id}/estado` | Cambiar estado del producto |
| `PATCH` | `/api/productos/{id}/stock` | Actualizar stock |
| `DELETE` | `/api/productos/{id}` | Eliminar producto |

---

## 🗄️ Base de Datos

El proyecto usa **Flyway** para gestionar las migraciones automáticamente al iniciar la aplicación.

```sql
-- Tabla clientes
CREATE TABLE clientes (
    id                  UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    apellido_paterno    VARCHAR(50)  NOT NULL,
    apellido_materno    VARCHAR(50)  NOT NULL,
    nombres             VARCHAR(100) NOT NULL,
    numero_dni          VARCHAR(8)   NOT NULL UNIQUE,
    telefono            VARCHAR(9),
    sexo                VARCHAR(10),
    activo              BOOLEAN      DEFAULT TRUE,
    fecha_nacimiento    TIMESTAMP,
    fecha_actualizacion TIMESTAMP    DEFAULT NOW()
);
```

---

## 👤 Autor

**Wilmer Maquera A**
- GitHub: [@wmaqueraa](https://github.com/wmaqueraa)

---

## 📄 Licencia

Este proyecto es de uso educativo - TECSUP Módulo 03
