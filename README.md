# PROYECTO HOSPITAL POST PANDEMIA

Este proyecto es un desafío para practicar los conocimientos adquiridos en Java y la biblioteca Spring Boot.

El objetivo del desarrollo es crear un CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar los pacientes de un hospital.

## Configuración del Proyecto

Para que el proyecto funcione correctamente, es necesario crear un archivo de configuración en la siguiente ruta:
**src/main/resources/application.properties**


### Instrucciones de Configuración

A continuación, se proporciona el código que debe incluirse en el archivo `application.properties`. Es importante modificar los siguientes valores según la configuración de su base de datos:

- **Usuario de la base de datos:** Reemplace `nombre de usuario` con su nombre de usuario de MySQL.
- **Contraseña:** Reemplace `contraseña` con la contraseña correspondiente al usuario de MySQL.

### Código de Configuración

```properties
spring.application.name=hospital_post_pandemia

# Configuración de la base de datos MySQL
spring.datasource.url=jdbc:mysql://localhost:3307/hospital?useSSL=false&serverTimezone=UTC
spring.datasource.username=nombre de usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect

# Configuración de Hibernate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always

# Habilitar métodos PUT y DELETE en MVC
spring.mvc.hiddenmethod.filter.enabled=true
```

Notas Adicionales <br>
El nombre de la base de datos en esta configuración es hospital. Si tu base de datos tiene otro nombre, asegúrate de actualizar la siguiente línea en el archivo application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3307/tu_nombre_de_base_de_datos?useSSL=false&serverTimezone=UTC
```