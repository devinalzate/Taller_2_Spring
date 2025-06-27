# 📘 Documentación de la API REST - Gestion Hotelera

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

## 📂 Endpoints por entidad

A continuación se describen los métodos REST disponibles, sus rutas, estructuras de entrada y salida, y recomendaciones de uso.

## User

### ✅ POST `/api/v1/users/save_user` - Crear nuevo Usuario

- **Descripción:** Crea una nueva entidad de usuario en la base de datos, pidiendo en esta el modelo asignado a la entidad
- **Cuerpo de la solicitud (JSON):**
```json
{
    "nombre_usuario" : "primer admin general",
    "contrasena" : "1232222",
    "rol" : "Admin general",
    "fk_id_administrador" : ingreso opcional... Borrar de no ser usado,
    "fk_id_empleado" : ingreso opcional... Borrar de no ser usado,
    "fk_id_cliente" : ingreso opcional... Borrar de no ser usado,
    "fk_id_administrador_general" : ingreso opcional... Borrar de no ser usado,
}
```
- **Respuesta esperada (Entidad :**
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
.
.
.
.
}
```

---

### 📝 PUT `/api/v1/users/update_user` - Actualizar usuario

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

### ❌ DELETE `/api//api/v1/users/{id}` - Eliminar usuario

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api//api/v1/users/{id}` - Obtener por ID

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

### 📋 GET `/api//api//api/v1/users/find_all_users` - Obtener todos los usuarios

- **Descripción:** Lista todos los elementos de la tabla.
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

---

### 🔍 GET `/api//api/v1/users/empleado/{id}` - Obtener por ID el empleado

- **Descripción:** Devuelve los datos de el empleado asociado al usuario con {id}.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_empleado": 1,
  "primer_nombre" : "Devin",
    "primer_apellido" : "Alzate",
    "correo" : "telefono",
    "telofono" : "3204713443"
}
```

---

---

### 🔍 GET `/api//api/v1/users/admin/{id}` - Obtener por ID el admin

- **Descripción:** Devuelve los datos de el admin asociado al usuario con {id}.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_admin": 1,
   "primer_nombre" : "Hernesto",
    "primer_apellido" : "Jaramillo",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```

---

---

### 🔍 GET `/api//api/v1/users/admin_general/{id}` - Obtener por ID el admin general

- **Descripción:** Devuelve los datos de el admin general asociado al usuario con {id}.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_adming_general": 1,
   "primer_nombre" : "Administrado",
    "primer_apellido" : "General",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```

---

---

### 🔍 GET `/api//api/v1/users/cliente/{id}` - Obtener por ID el cliente

- **Descripción:** Devuelve los datos de el cliente asociado al usuario con {id}.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_cliente": 1,
  " "primer_nombre" : "cliente",
    "primer_apellido" : "General",
    "correo" : "telefono",
    "telefono" : "334445511"
}
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

