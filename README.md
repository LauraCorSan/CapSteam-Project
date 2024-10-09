# Capsteam Game Project

## Descripción

**Capsteam Game Project** es una aplicación web desarrollada en **Spring Boot** que implementa un **CRUD** y que también permite a los usuarios buscar videojuegos por nombre. La aplicación utiliza una arquitectura basada en servicios, con un controlador que maneja las solicitudes HTTP y un servicio que interactúa con la base de datos a través de un **DAO**.



## Tecnologías Utilizadas

- **Java 11+**
- **Spring Boot 3.4.4**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf** (para la generación de vistas dinámicas)
- **Bootstrap** (para estilos de interfaz de usuario)
- **MySql** 

## Estructura del Proyecto

El proyecto está estructurado siguiendo el patrón MVC (Modelo-Vista-Controlador):

- **Modelo**: Representado por la clase `Game`, que mapea los datos de los juegos.
- **Vista**: Utiliza **Thymeleaf** para generar el HTML dinámico en el lado del servidor.
- **Controlador**: `GameController`, maneja las solicitudes de búsqueda y muestra los resultados.
- **Servicio**: `GameService` y `GameServiceImpl`, proporcionan la lógica de negocio.
- **DAO**: `GameDao`, para realizar consultas a la base de datos utilizando Spring Data JPA.

 ![0_qncTYBmq2ERUIdap](https://github.com/user-attachments/assets/25608dd7-8702-43fe-a596-38879ed566df)

## Instalación y Configuración

Sigue los pasos a continuación para instalar y ejecutar el proyecto en tu máquina local.

### Prerrequisitos

- **Java 11** o superior instalado
- **Maven** instalado (opcional si usas un IDE como IntelliJ IDEA o Eclipse con soporte para Maven)

## Dependencias del Proyecto

El proyecto **CapSteam** utiliza las siguientes dependencias de Maven. Todas están gestionadas por Spring Boot, lo que facilita el manejo de versiones y compatibilidad entre las bibliotecas.

- **Spring Boot Actuator**: Proporciona endpoints para monitoreo y métricas de la aplicación.
- **Spring Boot Data JPA**: Proporciona integración con JPA/Hibernate para el manejo de la persistencia de datos.
- **Spring Boot Thymeleaf**: Utiliza Thymeleaf como motor de plantillas para generar vistas dinámicas.
- **Spring Boot Web**: Para construir aplicaciones web basadas en Spring MVC.
- **Spring Boot DevTools**: Herramienta de desarrollo para reinicios rápidos y recarga en caliente.
- **MySQL Connector**: Controlador JDBC para conectar la aplicación con bases de datos MySQL.

### Dependencias para Pruebas
- **Spring Boot Starter Test**: Incluye todas las herramientas necesarias para realizar pruebas unitarias y de integración con Spring Boot.
- **Mockito**: Framework para crear simulaciones (mocks) en pruebas unitarias.
- **Mockito JUnit Jupiter**: Extensión de Mockito para JUnit 5.
- **Spring Test**: Proporciona soporte para pruebas de integración con el contexto de Spring.

### Configuracion BBDD

En el archivo applicion.properties añade:
```bash
spring.application.name=CapSteam
```
(En lo siguientes campos introduce los valores de tu entorno de desarrollo)
```bash
spring.datasource.url=  
spring.datasource.username=  
spring.datasource.password= 
```







### Paso 1: Clonar el Repositorio

Clona el proyecto desde el repositorio de GitHub:

```bash
git clone [repository] (https://github.com/LauraCorSan/CapSteam-Project.git)!
cd capsteam-game-project
```

### Paso 2: Configurar la Base de Datos
Edita el archivo src/main/resources/application.properties

### Paso 3: Compilar y Ejecutar

Si tienes Maven instalado, puedes ejecutar el proyecto desde la línea de comandos:
```bash
mvn spring-boot:run

```
También puedes usar un IDE como IntelliJ IDEA o Eclipse para ejecutar el proyecto directamente.


### Paso 4: Acceder a la Aplicación
Una vez que la aplicación esté en ejecución, puedes acceder a ella a través de tu navegador web:
```bash
http://localhost:8080/games

```

