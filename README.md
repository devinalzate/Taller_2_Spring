# 📘 Documentación de la API REST - Plantilla General

Esta documentación describe cómo utilizar los endpoints estándar de una API REST basada en Spring Boot que implementa un servicio genérico `BaseService<F, T, E>` para manipular entidades y datos en una base de datos.

---

## 🧩 Estructura Base del Servicio

```java
/**
 * F : Entity (Entidad JPA que representa una tabla)
 * T : Model (Objeto de dominio para operaciones internas)
 * E : DTO (Objeto que se expone a través de la API)
 */
public interface BaseService<F, T, E> {
    F save(T t);
    void delete(Long id);
    F update(T t);
    E findById(Long id);
    List<E> findAll();
}
```

---

## 📂 Endpoints Generales

A continuación se describen los métodos REST disponibles, sus rutas, estructuras de entrada y salida, y recomendaciones de uso.

### ✅ POST `/api/[entidad]` - Crear nuevo recurso

- **Descripción:** Crea una nueva entidad en la base de datos.
- **Cuerpo de la solicitud (JSON - Modelo T):**
```json
{
  "nombre_usuario": "devalzate",
  "contrasena": "1234",
  "rol": "ADMIN",
  "fk_id_empleado": 1,
  "fk_id_cliente": 2
}
```
- **Respuesta esperada (Entidad F):**
```json
{
  "id_usuario": 1,
  "nombre_usuario": "devalzate",
  "contrasena": "1234",
  "rol": "ADMIN",
  "fk_id_empleado": {
    "id_empleado": 1,
    "primer_nombre": "Juan",
    "primer_apellido": "Pérez"
  },
  "fk_id_cliente": 2
}
```

---

### 📝 PUT `/api/[entidad]` - Actualizar recurso

- **Descripción:** Modifica los datos de una entidad existente.
- **Cuerpo de la solicitud (JSON - Modelo T):**
```json
{
  "id_usuario": 1,
  "nombre_usuario": "devalzate2",
  "contrasena": "4321",
  "rol": "EMPLEADO",
  "fk_id_empleado": 1,
  "fk_id_cliente": 2
}
```
- **Respuesta esperada (Entidad F actualizada):**
```json
{
  "id_usuario": 1,
  "nombre_usuario": "devalzate2",
  "contrasena": "4321",
  "rol": "EMPLEADO",
  "fk_id_empleado": { "id_empleado": 1 },
  "fk_id_cliente": 2
}
```

---

### ❌ DELETE `/api/[entidad]/{id}` - Eliminar recurso

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api/[entidad]/{id}` - Obtener por ID

- **Descripción:** Devuelve los datos de una entidad específica.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_usuario": 1,
  "nombre_usuario": "devalzate",
  "rol": "ADMIN",
  "fk_id_empleado": 1,
  "fk_id_cliente": 2
}
```

---

### 📋 GET `/api/[entidad]` - Obtener todos

- **Descripción:** Lista todos los elementos de la entidad.
- **Respuesta (lista de DTOs):**
```json
[
  {
    "id_usuario": 1,
    "nombre_usuario": "devalzate",
    "rol": "ADMIN",
    "fk_id_empleado": 1,
    "fk_id_cliente": 2
  },
  {
    "id_usuario": 2,
    "nombre_usuario": "dpaez",
    "rol": "EMPLEADO",
    "fk_id_empleado": 2,
    "fk_id_cliente": 3
  }
]
```

---

## ⚠️ Notas Adicionales

- ⚠️ **Contraseñas u otros datos sensibles no deben incluirse en DTOs.**
- 💡 Se recomienda manejar excepciones y errores con un formato estándar.
- 🛡️ Para relaciones `@OneToOne`, asegúrate de que las FK no se repitan.
- 🔐 Si usas autenticación, añade un encabezado `Authorization: Bearer <token>`.

---

## 🧪 Recomendaciones de prueba

- Prueba los endpoints con datos válidos e inválidos.
- Asegúrate de probar restricciones de claves foráneas (`fk_*`).
- Verifica que las validaciones sean coherentes con el modelo de dominio.

---

> 📅 Última actualización: 2025-06-27

