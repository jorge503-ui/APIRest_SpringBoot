# APIRest_SpringBoot
API Rest se pude loguear y consutar una lista de usuarios y productos, al igual de realizarles mantenimiento a cada tabla

## Pruebas
Se puede realizar un tets mediante Postman, se ubica en `/src/main/resources/requests` solamente importelo en postman.

## Funcionalidades
* Login
* Catalogo de productos y usuarios
* Actualizacion de productos y usuarios
* Eliminar productos y usuarios
* agregar productos y usuarios
* Filtar productos por SKU y nombre

### Autenticacion
Es por medio de POST, se puede acceder por
`http://localhost:8080/login`

#### Input
```
{
    "mail":"jorge.p.391@gmail.com",
    "password":"PruebaPassword"
}
```
#### Output
```
{"token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb3JnZS5wLjM5MUBnbWFpbC5jb20iLCJzY29wZXMiOiJST0xFX0FETSIsImlhdCI6MTU4NjUzNjU1NCwiZXhwIjoxNTg3MTQxMzU0fQ.Xkv-njMGHK5CsEtF_Rl95EMCRazoNjKKuwyGxc3cqSM"}
```


## Recursos
* Java 8
* Apache Netbeans IDE 11.3
* Maven 4.0.0
* Spring Boot 2.2.4
* MySQL  9.5

## Instalaccion
* Crear la BDD cPvkQ1lTKU
* Importar el script sql que esta en: /src/main/resources/database
* Agregar el proyecto a Apache Netbeans
* Inicar SpringBoot Application
