# Clase 5 – Java Backend

## Etapa 5: Autenticación con JWT (JSON Web Token) en Spring Boot

---

### 🎯 Objetivo de la clase

Entender cómo funciona **JWT** para proteger APIs REST de manera **stateless**, y agregarlo al proyecto **LimpiezaIT**:

- Emitir un token al autenticarse (`/auth/login`)
- Validar el token en cada request (filtro JWT)
- Restringir endpoints por **roles**
- Usar **`@PreAuthorize`** para reglas de autorización por método

---

## 🧠 Teoría y flujo completo

### ¿Qué es JWT?

**JWT** es un **token firmado** (no cifrado) que el servidor emite cuando el usuario se autentica correctamente.

- El cliente lo envía en cada request: `Authorization: Bearer <token>`
- El servidor **valida la firma** del token y **no guarda sesión** (stateless).

**Estructura:** `header.payload.signature`

- **header:** algoritmo y tipo (`alg`, `typ`)
- **payload:** claims (sub, roles, exp, etc.)
- **signature:** firma HS256/RS256 con la secret/clave privada
