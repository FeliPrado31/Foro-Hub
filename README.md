# 🚀 ForoHub - ChallenAlura 🚀

¡Bienvenido a **ForoHub**! 🎉 Este proyecto es un foro en línea desarrollado como parte del desafío **ChallenAlura** de Alura. Aquí los usuarios pueden crear tópicos, responder preguntas, y participar en discusiones sobre diversos temas. ¡Todo esto construido con las mejores prácticas de desarrollo y principios SOLID! 💻✨

---

## 📋 Descripción del Proyecto

**ForoHub** es una aplicación web que permite a los usuarios:

- 🗨️ Crear tópicos de discusión.
- 📝 Responder a tópicos existentes.
- 🔍 Buscar y filtrar tópicos por curso y año.
- 📊 Ver tópicos de manera paginada y ordenada.
- 🛠️ Actualizar y eliminar tópicos.

El proyecto está construido con **Spring Boot** y sigue una arquitectura limpia y modular, aplicando principios **SOLID** y buenas prácticas de desarrollo. 🏗️

---

## 🛠️ Tecnologías Utilizadas

- **Java 17** ☕
- **Spring Boot** 🌱
- **Spring Data JPA** 🗄️
- **H2 Database** (o cualquier base de datos compatible con JPA) 💾
- **Flyway** (para migraciones de base de datos) 🕊️
- **Maven** (gestión de dependencias) 📦
- **Lombok** (para reducir código boilerplate) 🛠️
- **Validaciones con Jakarta Validation** ✔️
- **Manejo de excepciones global** 🚨

---

## 🚀 Cómo Empezar

Sigue estos pasos para configurar y ejecutar el proyecto en tu máquina local.

### 📥 Prerrequisitos

- **Java 17** instalado.
- **Maven** instalado.
- Una base de datos configurada (puedes usar H2 en memoria o cualquier otra base de datos compatible con JPA).

### 🔧 Configuración

1. Clona el repositorio:

   ```bash
   git clone https://github.com/FeliPrado31/Foro-Hub.git
   ```

2. Navega al directorio del proyecto:

   ```bash
   cd foro-hub
   ```

3. Configura la base de datos en el archivo `application.properties`:

   ```properties
   spring.datasource.url=jdbc:h2:mem:forohub
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

   Si prefieres usar otra base de datos, modifica las propiedades correspondientes.

4. Ejecuta las migraciones de Flyway:

   Las migraciones se ejecutarán automáticamente al iniciar la aplicación.

5. Compila y ejecuta el proyecto:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

6. Accede a la aplicación:

    - La aplicación estará disponible en `http://localhost:8080`.
    - Si usas H2, puedes acceder a la consola de la base de datos en `http://localhost:8080/h2-console`.

---

## 📚 Endpoints Disponibles

### Tópicos

- **GET** `/topicos` - Lista todos los tópicos.
- **POST** `/topicos` - Crea un nuevo tópico.
- **GET** `/topicos/{id}` - Obtiene los detalles de un tópico específico.
- **PUT** `/topicos/{id}` - Actualiza un tópico existente.
- **DELETE** `/topicos/{id}` - Elimina un tópico.
- **GET** `/topicos/paginado` - Lista tópicos de manera paginada y ordenada.
- **GET** `/topicos/filtrado` - Filtra tópicos por curso y año.

---

## 🧪 Pruebas

El proyecto incluye pruebas unitarias y de integración para garantizar la calidad del código. Puedes ejecutar las pruebas con el siguiente comando:

```bash
mvn test
```

---

## 🛑 Manejo de Errores

El proyecto incluye un manejador global de excepciones que captura errores comunes y devuelve respuestas claras y útiles. Algunos de los errores manejados incluyen:

- **404 Not Found**: Cuando un recurso no existe.
- **400 Bad Request**: Cuando la validación de datos falla.
- **500 Internal Server Error**: Para errores inesperados.

---

## 🧩 Estructura del Proyecto

```
foro-hub/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/ForoHub/ChallenAlura/
│   │   │       ├── controllers/
│   │   │       ├── dto/
│   │   │       ├── exceptions/
│   │   │       ├── models/
│   │   │       ├── repositories/
│   │   │       └── services/
│   │   └── resources/
│   │       └── db/migration/
│   └── test/
│       └── java/
│           └── com/ForoHub/ChallenAlura/
└── .mvn/
```

---

## 🤝 Contribuciones

¡Las contribuciones son bienvenidas! Si deseas mejorar el proyecto, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -m 'Añade nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

---

## 📄 Licencia

Este proyecto está bajo la licencia **MIT**. Para más detalles, consulta el archivo [LICENSE](LICENSE).

---

## 🙏 Agradecimientos

- **Alura** por el desafío ChallenAlura.
- **Spring Boot** por facilitar el desarrollo de aplicaciones Java.
- **Flyway** por las migraciones de base de datos.

---
