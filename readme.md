# AguaAlerta · API

API REST del sistema **AguaAlerta**, una plataforma para monitorear la red hídrica municipal: depósitos, reportes ciudadanos, técnicos, colonias y usuarios del sistema.

## Descripción

AguaAlerta ayuda a que el municipio vea el estado de la red de agua y atienda más rápido los problemas como fugas, falta de agua o baja presión.

- **Problema que resuelve:** los reportes de problemas con el agua se reciben y atienden de forma lenta y desordenada.
- **Objetivos principales:**
    - Registrar los reportes de los ciudadanos y atenderlos en orden de llegada.
    - Consultar los depósitos de agua y su nivel actual.
    - Gestionar a los técnicos, las colonias, los roles y los usuarios del sistema.
- **Contexto:** es la API del mismo sistema cuyas pantallas construimos en Plataformas Abiertas 1 ([Frontend](https://github.com/kevRG/Frontend)). En este parcial los datos viven **en memoria**, dentro de estructuras de datos propias. La base de datos (PostgreSQL en Neon) solo está conectada y se comprueba con `/api/health/db`.

## Tecnologías Utilizadas

- Java 17
- Spring Boot 4 (Web MVC y JDBC)
- Gradle
- PostgreSQL (Neon)
- Postman

## Requisitos Previos

- JDK 17 o superior
- Una base de datos PostgreSQL y sus credenciales
- Postman, para probar los endpoints
- Editor de código (recomendamos IntelliJ IDEA o VS Code)

No necesitas instalar Gradle, porque el proyecto incluye su wrapper (`gradlew`).

## Instalación

1. Clona este repositorio:

   ```bash
   git clone https://github.com/kevRG/Backend.git
Entra a la carpeta del proyecto:
cd Backend
Crea el archivo .env a partir de .env.example:
cp .env.example .env
Abre .env y escribe las credenciales de tu base de datos:
DB_URL=jdbc:postgresql://<host>/<base_de_datos>?sslmode=require
DB_USER=<usuario>
DB_PASSWORD=<contraseña>
El archivo .env está en .gitignore, así que nunca se sube a GitHub.

Uso
Arranca el proyecto:
./gradlew bootRun
En Windows (CMD o PowerShell) usa gradlew.bat bootRun.

La API queda disponible en http://localhost:8080.
Comprueba que el servidor y la base de datos funcionan:
GET http://localhost:8080/api/health responde OK.
GET http://localhost:8080/api/health/db responde Database OK.
Importa en Postman la colección postman/AguaAlerta.postman_collection.json. Usa la variable baseUrl (http://localhost:8080) y tiene una carpeta por módulo.
Módulos y Endpoints
Cada módulo tiene su propio controller, service, model y DTO. Cada service empieza con al menos 3 registros de ejemplo.

Health (no cuenta como módulo)
Método	Ruta	Respuesta
GET	/api/health	200 OK
GET	/api/health/db	200 Database OK (ejecuta SELECT 1)
Usuarios
Método	Ruta	Respuesta
GET	/api/usuarios	200 con la lista
GET	/api/usuarios/{id}	200 con el usuario, o 404
POST	/api/usuarios	201 con el usuario creado
Roles
Método	Ruta	Respuesta
GET	/api/roles	200 con la lista
GET	/api/roles/{id}	200 con el rol, o 404
POST	/api/roles	201 con el rol creado · 400 datos inválidos · 409 nombre repetido
Colonias
Método	Ruta	Respuesta
GET	/api/colonias	200 con la lista
GET	/api/colonias/{id}	200 con la colonia, o 404
POST	/api/colonias	201 con la colonia creada · 400 datos inválidos · 409 nombre repetido
Depósitos
Método	Ruta	Respuesta
GET	/api/depositos	200 con la lista
GET	/api/depositos/{id}	200 con el depósito, o 404
POST	/api/depositos	201 con el depósito creado
Técnicos
Método	Ruta	Respuesta
GET	/api/tecnicos	200 con la lista
GET	/api/tecnicos/{id}	200 con el técnico, o 404
POST	/api/tecnicos	201 con el técnico creado
Reportes
Método	Ruta	Respuesta
GET	/api/reportes	200 con la lista
GET	/api/reportes/{id}	200 con el reporte, o 404
POST	/api/reportes	201 con el reporte creado (entra a la cola de pendientes) · 400 datos inválidos
GET	/api/reportes/pendientes	200 con los reportes sin asignar, en orden de llegada
POST	/api/reportes/pendientes/atender	200 con el reporte que más tiempo lleva esperando, ya marcado “En proceso” · 404 si la cola está vacía
Estructuras de Datos
Las dos estructuras son implementaciones propias hechas con nodos y están en el paquete structures. Las dos tienen un método toList() que convierte sus datos a List para poder responder en JSON.

Estructura	Clase	Dónde se usa
Lista ligada simple	CustomLinkedList<T> (con Node<T>)	Guarda en memoria los registros de todos los módulos (UsuarioService, RolService, ColoniaService, DepositoService, TecnicoService y ReporteService). Tiene add, find (búsqueda por condición, usada en GET /{id} y para evitar duplicados) y toList.
Cola (FIFO)	Cola<T> (con Node<T>)	En ReporteService guarda los reportes “Sin asignar”. Cada reporte nuevo se encola, y POST /api/reportes/pendientes/atender desencola el reporte que llegó primero y lo marca “En proceso”.
Estructura del Proyecto
src/main/java/com/example/springb/
├── controllers/   # Reciben las peticiones y regresan las respuestas
├── services/      # Lógica y datos en memoria
├── models/        # Usuario, Rol, Colonia, Deposito, Tecnico, Reporte
├── dto/           # Lo que manda el cliente (sin id)
└── structures/    # Node, CustomLinkedList, Cola
postman/           # Colección de Postman (v2.1)
Autores
Kevin Reyes González

GitHub: @kevRG
Email: tu-email@ejemplo.com
Mikel Novas

GitHub: @MikeelNov
Email: tu-email@ejemplo.com