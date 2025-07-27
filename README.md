# LiterAlura 📚 - Proyecto de Biblioteca Digital

**LiterAlura** es una aplicación de línea de comandos desarrollada en Java con Spring Boot, que permite consultar libros desde la API pública [Gutendex](https://gutendex.com/), transformarlos en objetos de dominio y almacenarlos en una base de datos PostgreSQL. El proyecto fue construido aplicando principios de **Domain-Driven Design (DDD)** y buenas prácticas de desarrollo en Java.

---

## 🚀 Tecnologías utilizadas

- Java 17+
- Spring Boot 3.2.3
- Maven 4+
- PostgreSQL 16
- Jackson (manejo de JSON)
- Gutendex API
- JPA + Spring Data

---

## 📁 Estructura del proyecto

La organización del proyecto sigue los principios de **DDD**, distribuyendo responsabilidades en paquetes separados por capas:

```
src/
└── main/
├── java/com/aluracursos/literatura/
│   ├── aplicacion/         # DTOs, enums, servicios externos (API)
│   ├── dominio/            # Entidades y repositorios
│   ├── infraestructura/    # Configuración y conexión con DB
│   └── presentacion/       # Clase principal, interacción por consola
└── resources/              # Configuración y persistencia
```

---

## ✅ Funcionalidades implementadas

### 1. Configuración inicial
- Creación de proyecto Maven con dependencias necesarias (Spring Data JPA, PostgreSQL Driver, Jackson).

### 2. Consumo de API externa
- Uso de `HttpClient` para conectar con Gutendex y buscar libros por título.

### 3. Mapeo de respuestas
- Mapeo automático de JSON a DTOs con Jackson (`LibroDTO`, `AutorDTO`, etc.).

### 4. Conversión a objetos de dominio
- Conversión de DTOs a entidades persistentes (`Libro`, `Autor`).

### 5. Menú interactivo por consola
- Construcción de menú CLI usando `Scanner`, con opciones para consultar, listar y filtrar libros/autores.

### 6. Consulta de libros
- Búsqueda por título desde consola, seleccionando el primer resultado válido de la API.

### 7. Listado y filtrado
- Listado de libros guardados.
- Listado de autores guardados.
- Filtro de autores vivos en un año específico.

### 8. Persistencia en base de datos
- Uso de Spring Data JPA para guardar libros y autores en PostgreSQL.
- Relaciones @ManyToOne entre entidades.
- Repositorios genéricos para consultas derivadas.

### 9. Estadísticas por idioma
- Consulta de libros filtrados por idioma.


---

## 🖥️ Cómo ejecutar

1. Asegúrate de tener PostgreSQL en funcionamiento y una base de datos creada (ej. `literatura_db`).
2. Configura el archivo `application.properties` con tus credenciales.
3. Ejecuta el proyecto desde la raíz con:
   ```bash
   ./mvnw spring-boot:run

El menú interactivo se ejecutará por consola y podrás navegar por las diferentes opciones.

📌 Estado actual
✅ 100% funcionalidades implementadas según los hitos del desafío.

✅ Persistencia funcional con PostgreSQL.

✅ Separación por capas con principios DDD.

✅ Interfaz de usuario funcional por consola.

## 📎 Repositorio

El código fuente se encuentra disponible en GitHub:  
[https://github.com/stonedjjh/Literalura](https://github.com/stonedjjh/Literalura)

---

## 📄 Licencia

Proyecto desarrollado con fines educativos como parte del curso **Java Backend** de **Alura Latam**.

---

## 👤 Autor

**Daniel Jiménez**
- GitHub: [@Stone_DJJH](https://github.com/Stone_DJJH)
- LinkedIn: [https://www.linkedin.com/in/daniel-jimenez-88a2a293/](https://www.linkedin.com/in/daniel-jimenez-88a2a293/