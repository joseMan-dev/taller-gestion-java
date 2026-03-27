# Taller Gestión Java
Aplicación de escritorio desarrollada en java para la gestión de un taller mecánico.
Permite gestionar clientes, coches y revisiones, aplicando una arquitectura por capas y acceso a base de datos mediante JDBC.

---

# Tecnologías utilizadas
- Java
- JavaFX
- Maven
- MySQL
- JDBC

- ## Funcionalidades actuales.

  ### Clientes.
- Alta de clientes.
- Búsqueda de clientes.
- Actualización de datos.
- Eliminación de clientes.

  ### Coches.
- Gestión de vehículos asociados a clientes.
- Visualización de datos del coche.

### Revisiones.
- Registro de revisiones.
- Asociación coche <-> operaciones.
- Gestión del historial de mantenimiento.

---

## Arquitectura del proyecto.
El proyecto sigue una estructura basada en capas.

- **Modelo** -> Entidades (Cliente, Coche, Revisión).
- **DAO** -> Acceso a base de datos (JDBC).
- **Controladores** -> Lógica de la aplicación.

___

## Base de datos.
- MySQL
- Relación entre tablas:
   - Cliente -> Coche (1:N)
   - Coche -> Revisiones (1:N9.
   - Revisiones -> Operaciones (N:M).

---

## Objetivo del proyecto
Proyecto desarrollado como parte del ciclo DAM con el objetivo de:

- Aplicar programación Java.
- Trabajar con bases de datos relacionales.
- Implementar una interfaz gráfica con JavaFx.
- Entender el patrón DAO.

---

- ## Autor
- José Manuel Villaescusa López
- Proyecto DAM:
