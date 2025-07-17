# LiterAlura - Proyecto de Biblioteca

## Descripción

Proyecto desarrollado en Java con Spring Boot para consultar información de libros usando la API pública Gutendex (Project Gutenberg). Este proyecto forma parte de un desafío guiado para aprender a consumir APIs REST, mapear datos JSON a objetos Java y construir aplicaciones con interacción por consola.

---

## Tecnologías utilizadas

- Java 17+
- Spring Boot 3.5.3
- Maven 4+
- PostgreSQL 15 (configurado para futuras etapas)
- Jackson (para manejo de JSON)
- API Gutendex (https://gutendex.com)

---

## Arquitectura

Este proyecto está desarrollado siguiendo los principios de **Domain-Driven Design (DDD)** para una mejor organización y claridad del dominio.

## Estado actual

- Configuración inicial del entorno Java y Spring Boot.
- Consulta y consumo de la API Gutendex con HttpClient.
- Mapeo de respuesta JSON a DTOs con Jackson.
- Transformación de DTOs a entidades de dominio.
- Extracción y visualización de datos importantes: título, trama, autores e imágenes.
- Preparación para la interacción con usuario en consola (en desarrollo).

---

## Próximos pasos

- Implementar menú interactivo con opciones para buscar libros y mostrar detalles.
- Mejorar estructura y modularidad del código.
- Añadir persistencia con PostgreSQL.
- Realizar pruebas exhaustivas y manejo de errores.
- Documentar el proyecto y refinar el README.

---

## Uso

Por ahora, la aplicación se ejecuta desde el método main y muestra por consola los libros consultados con los datos obtenidos desde la API.

---

## Repositorio

El código fuente del proyecto está disponible en GitHub:

[https://github.com/stonedjjh/Literalura](https://github.com/stonedjjh/Literalura)

## Autor

**Daniel Jiménez**  
GitHub: [Stone_DJJH](https://github.com/Stone_DJJH)  
LinkedIn: [https://www.linkedin.com/in/daniel-jimenez-88a2a293/](https://www.linkedin.com/in/daniel-jimenez-88a2a293/)
