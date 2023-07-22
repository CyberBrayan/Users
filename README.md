# Bienvenido a la aplicación de Usuarios

¡Gracias por visitar la aplicación de Usuarios! Aquí puedes realizar operaciones como crear y listas usuarios y sus teléfonos. A continuación, te proporcionamos información sobre cómo utilizar la aplicación y las funcionalidades disponibles.

## URL de la Aplicación

La aplicación está alojada en la siguiente URL:

[users-production.up.railway.app](https://users-production.up.railway.app)

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

Gracias por utilizar nuestra aplicación de Usuarios. Si tienes alguna pregunta, problema o sugerencia, no dudes en contactarnos.

¡Esperamos que disfrutes utilizando la aplicación!

### users-production.up.railway.app
