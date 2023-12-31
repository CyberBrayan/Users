# Bienvenido a la aplicación de Usuarios

¡Gracias por visitar la aplicación de Usuarios! Aquí puedes realizar operaciones como crear y listas usuarios y sus teléfonos. A continuación, te proporcionamos información sobre cómo utilizar la aplicación y las funcionalidades disponibles.

## URL de la Aplicación

La aplicación está alojada en la siguiente URL:

[users-production.up.railway.app](https://users-production.up.railway.app)

## Swagger

La API de esta aplicación está documentada con Swagger. Puedes acceder a la documentación interactiva de Swagger en el siguiente enlace:

[Documentación Swagger](https://users-production.up.railway.app/doc/swagger-ui/index.html)

Aquí encontrarás información detallada sobre los endpoints disponibles, los parámetros requeridos, las respuestas esperadas y podrás probar los endpoints directamente desde el navegador.

## Endpoints Disponibles

### Crear un Usuario

Puedes crear un nuevo usuario enviando una solicitud POST al siguiente endpoint: **/users/create**

Asegúrate de utilizar el siguiente JSON en el cuerpo de la solicitud para probarlo:

```json
{
    "name": "Juan Rodriguez",
    "email": "juan@rodriguez.org",
    "password": "Password1$$",
    "phones": [
            {
                "number": "1234567",
                "cityCode": "1",
                "countryCode": "57"
            },
            {
                "number": "4656565",
                "cityCode": "2",
                "countryCode": "10"
            }
        ]
}
```

#### Notas sobre la contraseña:

La contraseña debe tener un mínimo de 8 caracteres y un máximo de 16 caracteres.
Debe contener al menos una letra minúscula, una letra mayúscula y un dígito.

### Listar Usuarios con sus Teléfonos

Para ver la lista de usuarios con sus teléfonos registrados, puedes enviar una solicitud GET al siguiente endpoint: **/users/list**

La respuesta será similar a esta:

```json
[
    {
        "id": "71a1de61-f07e-4c30-b00d-6acd1b9b197b",
        "name": "Juan Rodriguez",
        "email": "juan@rodriguez.org",
        "password": "Password1$$",
        "phones": [
            {
                "id": "877b752c-0679-4a60-86d2-d883ef6316b1",
                "number": "1234567",
                "cityCode": 1,
                "countryCode": 57
            },
            {
                "id": "1076ee16-2e9f-4e2a-91e7-488e56fbf708",
                "number": "4656565",
                "cityCode": 2,
                "countryCode": 10
            }
        ],
        "created": "2023-07-22T21:04:34.967+00:00",
        "modified": "2023-07-22T21:04:34.967+00:00",
        "last_login": null,
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE2OTAwNTk4NzUsImV4cCI6MTY5MDE0NjI3NX0.SOf3_wTA_3Pmx7AX_szBinbOuKu34PgIpj2MrAEzIQ0",
        "isactive": true
    }
]
```

##### Nota: Este Response mostrará toda la data de un usuario almacenada en la Base de Datos sin restricciones, solo como ejemplo. En un escenario real se mostrará data confiable.

## Detalles Técnicos

La aplicación se ha desarrollado utilizando las siguientes tecnologías:

1. Base de Datos: H2 (base de datos en memoria)
2. Persistencia: JPA (Java Persistence API)
3. Java: Versión 17
4. Spring Boot: Versión 3.1.2
5. Manejo de Dependencias: Maven
6. Autenticación con Token JWT (JSON Web Token) para seguridad y autenticación de usuarios.

## Notas Importantes

Los datos almacenados en la base de datos H2 son volátiles y se borrarán al reiniciar la aplicación.
La aplicación implementa validaciones para garantizar que la contraseña cumpla con los requisitos especificados.

## ¡Agradecimientos!

Gracias por utilizar nuestra aplicación de Usuarios. Si tienes alguna pregunta, problema o sugerencia, no dudes en contactarme.

¡Espero que disfrutes utilizando la aplicación!
