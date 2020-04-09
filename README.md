# APIRest_SpringBoot
API Rest se pude loguear y consutar una lista de usuarios y productos, al igual de realizarles mantenimiento a cada tabla

## Test
Se puede realizar un tets mediante Postman, se ubica en `/src/main/resources/requests` solamente importelo en postman.

## Functions
* Login
* Catalogo de productos y usuarios
* Actualizacion de productos y usuarios
* Eliminar productos y usuarios
* agregar productos y usuarios
* Filtar productos por SKU y nombre

### Authentication
Es por medio de POST, se puede acceder por
`http://localhost:8080/login`

#### Input
```
{
    "username":"jorge.p.391@gmail.com",
    "password":"PruebaPassword"
}
```
#### Output
```
{"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIi"}
```


## Resources
* Java 8
* Apache Netbeans IDE 11.3
* Maven 4.0.0
* Spring Boot 2.2.4
* MariaDB  9.5

## Install
* Crear la BDD PruebaElaniin
* Importar el script sql que esta en: /src/main/resources/database
* Agregar el proyecto a Apache Netbeans
* Inicar SpringBoot Application
