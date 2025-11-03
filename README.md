# 🧱 Clase 6 — Documentación de APIs con Swagger / OpenAPI

## 🎯 Objetivo de la clase

Incorporar **Swagger / OpenAPI** a nuestro proyecto **Spring Boot**, documentar los endpoints existentes y comprender cómo encaja dentro de la **arquitectura en capas (N-Tier)**.

---

## 🧩 1. Arquitectura trabajada

Usamos una **arquitectura monolítica en capas** con separación de responsabilidades:

Swagger documenta los **endpoints de la capa Controller**.

---

## ⚙️ 2. Agregar Swagger / OpenAPI al proyecto

### 📄 Dependencia Maven

```xml
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
  <version>2.6.0</version>
</dependency>
```
