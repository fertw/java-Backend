# Clase 4 – Java Backend

## Etapa 4: Seguridad y Autenticación en Spring Boot

---

### 🎯 Objetivo de la clase

Comprender cómo proteger una API REST utilizando **Spring Security**,  
implementando mecanismos de **autenticación y autorización** para restringir el acceso a los endpoints,  
mediante **Basic Auth**, roles y configuración de seguridad básica.

---

### 🧠 Temas vistos en clase

#### 🔐 Introducción a la seguridad en APIs REST

- Hasta ahora, cualquier usuario podía consumir nuestros endpoints.
- La seguridad se incorpora para **verificar quién accede (autenticación)** y **qué puede hacer (autorización)**.
- Spring Boot integra **Spring Security**, que intercepta todas las solicitudes HTTP.

---

#### 🧩 Autenticación vs Autorización

| Concepto          | Descripción                        | Ejemplo             |
| ----------------- | ---------------------------------- | ------------------- |
| **Autenticación** | Verifica la identidad del usuario. | “¿Quién sos?”       |
| **Autorización**  | Controla qué recursos puede usar.  | “¿Qué podés hacer?” |

📘 En una API REST, esto se maneja a través de **cabeceras HTTP** (`Authorization`).

---

#### ⚙️ Métodos comunes de autenticación

| Método         | Descripción                                 | Ventajas                      | Desventajas                                    |
| -------------- | ------------------------------------------- | ----------------------------- | ---------------------------------------------- |
| **Basic Auth** | Usuario y contraseña codificados en Base64. | Simple, nativo en HTTP.       | No cifra datos, requiere HTTPS.                |
| **API Key**    | Clave única por cliente o aplicación.       | Fácil de usar.                | Sin cifrado, poco seguro para datos sensibles. |
| **Token JWT**  | Token firmado con datos del usuario.        | Stateless, seguro, escalable. | Requiere lógica de generación y validación.    |
| **OAuth 2.0**  | Acceso delegado (Google, GitHub, etc.).     | Muy seguro, estándar actual.  | Complejo de implementar.                       |

💡 En esta clase usamos **Basic Auth** para comprender la base de la autenticación en Spring Boot.

---

#### 🔒 Basic Authentication

- Usa el encabezado HTTP `Authorization: Basic base64(user:password)`.
- Spring Security lo maneja automáticamente, sin necesidad de código adicional.
- Se recomienda usarlo solo en entornos **con HTTPS** o fines didácticos.
