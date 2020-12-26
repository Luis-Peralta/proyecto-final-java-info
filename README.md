# Proyecto Final Java,Spring,API Rest informatorio 2020 - By Luis Peralta
## CRUD USUARIOS: 
**Creacion de usuarios con metodo post(ejemplo):** 
{ "nombre":"Luis", "apellido":"Peralta", "email":"luis@gmail.com", "password":"1234", "ciudad":"Resistencia", "provincia":"Chaco", "pais":"Argentina" }

**metodo get para ver todos los usuarios:** localhost:8080/api/v1/users

**metodo put para actualizar usuario:** localhost:8080/api/v1/users/{id} y pasar valores

**para delete:** Poner en delete y colocar el id a eliminar --> localhost:8080/api/v1/users/{id}


**PARA BUSQUEDA SEGUN CIUDAD:** localhost:8080/api/v1/users/ciudad?ciudad=Resistencia


**PARA BUSQUEDA SEGUN FECHA:** localhost:8080/api/v1/users/fecha?filter=2020-12-23

## CRUD POSTS: 

**Creacion de posts con metodo post(Ejemplo):**
{ "titulo":"Venta de una bici", "descripcion":"Vendo una bicicleta a un buen precio", "contenido":"Hola, les vengo a ofrecer una bicicleta en muy buen estado, casi nueva a $15.000", "publicado":true, "autor":{ "id":2 } }


**metodo get para ver todos los posts:** localhost:8080/api/v1/posts


**metodo put para actualizar post:** localhost:8080/api/v1/posts/{id} y pasar valores


**para delete:** Poner en delete y colocar el id a eliminar --> localhost:8080/api/v1/posts/{id}


**PARA VER TODOS LOS POSTS NO PUBLICADOS:** localhost:8080/api/v1/posts/no-publicado


**PARA BUSCAR POR UNA PALABRA EN EL TITULO:** localhost:8080/api/v1/posts/titulo?filter={palabra}

## CRUD COMENTARIOS: 
Creacion de comentarios con metodo post(ejemplo): { "comentario":"buen blog", "autor_comentario":{ "id":2 }, "post":{ "id":2 } }


**metodo get para ver todos los comentarios:** localhost:8080/api/v1/posts/comments


**metodo put para actualizar comentario:** localhost:8080/api/v1/posts/comments/{id} y pasar valores


**para delete:** Poner en delete y colocar el id a eliminar --> localhost:8080/api/v1/posts/comments/{id}


**PARA TREAR LOS COMENTARIOS DE UN POST:** localhost:8080/api/v1/posts/comments/post/{id del post}


**PARA FILTRAR POR CANTIDAD DE COMENTARIOS:** localhost:8080/api/v1/posts/comments/post/{id del post}/valor?l={cantidad a filtrar}
