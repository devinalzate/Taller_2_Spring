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

## 📌 Restricciones necesarias para pruebas correctas

Para garantizar la **integridad de datos** y evitar duplicidad de registros asociados en la tabla `usuario`, es **necesario agregar las siguientes restricciones `UNIQUE`**.  
Estas aseguran que cada `Empleado`, `Cliente`, `Administrador General` y `Administrador` solo puedan estar vinculados a **un único usuario**, cumpliendo la lógica de negocio de relación uno a uno.

```sql
ALTER TABLE usuario
ADD CONSTRAINT uk_usuario_empleado UNIQUE (fk_id_empleado);

ALTER TABLE usuario
ADD CONSTRAINT uk_usuario_cliente UNIQUE (fk_id_cliente);

ALTER TABLE usuario
ADD CONSTRAINT uk_usuario_admin_general UNIQUE (fk_id_administrador_general);

ALTER TABLE usuario
ADD CONSTRAINT uk_usuario_admin UNIQUE (fk_id_administrador);
````

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

### ❌ DELETE `/api/v1/users/{id}` - Eliminar usuario

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api/v1/users/{id}` - Obtener por ID

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

### 📋 GET `/api/v1/users/find_all_users` - Obtener todos los usuarios

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

### 🔍 GET `/api/v1/users/empleado/{id}` - Obtener por ID el empleado

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

### 🔍 GET `/api/v1/users/admin/{id}` - Obtener por ID el admin

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

### 🔍 GET `/api/v1/users/admin_general/{id}` - Obtener por ID el admin general

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

### 🔍 GET `/api/v1/users/cliente/{id}` - Obtener por ID el cliente

- **Descripción:** Devuelve los datos de el cliente asociado al usuario con {id}.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
  "id_cliente": 1,
   "primer_nombre" : "cliente",
    "primer_apellido" : "General",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```

## Empleado

### ✅ POST `/api/v1/empleados/save_empleado` - Crear nuevo Empleado

- **Descripción:** Crea una nueva entidad de empleado en la base de datos, pidiendo en esta el modelo asignado a la entidad
- **Cuerpo de la solicitud (JSON):**
```json
{
    "primer_nombre" : "Devin",
    "primer_apellido" : "Alzate",
    "correo" : "telefono",
    "telofono" : "3204713443"
}
```
- **Respuesta esperada (Entidad :**
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

### 📝 PUT `/api/v1/empleados/update_empleado` - Actualizar empleado

- **Descripción:** Modifica los datos de una entidad existente.
- **Cuerpo de la solicitud (JSON - Modelo T):**
```json
{
    "primer_nombre" : "Devin",
    "primer_apellido" : "Alzate",
    "correo" : "telefono",
    "telofono" : "3204713443"
}
```
- **Respuesta esperada (Entidad F actualizada):**
```json
{
    "id_empledo": 1,
    "primer_nombre" : "Devin",
    "primer_apellido" : "Alzate",
    "correo" : "telefono",
    "telofono" : "3204713443"
}
```

---

### ❌ DELETE `/api/v1/empleados/{id}` - Eliminar enpleado

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api/v1/empleados/{id}` - Obtener por ID

- **Descripción:** Devuelve los datos de una entidad específica.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
    "id_empleado": 2,
    "correo": "telefono",
    "telofono": "3204713443",
    "primer_nombre": "Devin",
    "segundo_nombre": null,
    "primer_apellido": "Alzate",
    "segundo_apellido": null
}
```

---

### 📋 GET `/api/v1/empleados/get_all_empleados` - Obtener todos los empleados

- **Descripción:** Lista todos los elementos de la tabla.
- **Respuesta (lista de DTOs):**
```json
[
    {
        "id_empleado": 2,
        "correo": "telefono",
        "telofono": "3204713443",
        "primer_nombre": "Devin",
        "segundo_nombre": null,
        "primer_apellido": "Alzate",
        "segundo_apellido": null
    }
]
```

## Admin

### ✅ POST `/api/v1/admins/save_admin` - Crear nuevo Admin

- **Descripción:** Crea una nueva entidad de administrador en la base de datos, pidiendo en esta el modelo asignado a la entidad
- **Cuerpo de la solicitud (JSON):**
```json
{
    "primer_nombre" : "Hernesto",
    "primer_apellido" : "Jaramillo",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```
- **Respuesta esperada (Entidad :**
```json
{
    "id_administrador": 3,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Hernesto",
    "segundo_nombre": null,
    "primer_apellido": "Jaramillo",
    "segundo_apellido": null
}
```

---

### 📝 PUT `/api/v1/admins/update_admin` - Actualizar admin

- **Descripción:** Modifica los datos de una entidad existente.
- **Cuerpo de la solicitud (JSON - Modelo T):**
```json
{
    "primer_nombre" : "Hernesto",
    "primer_apellido" : "Jaramillo",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```
- **Respuesta esperada (Entidad F actualizada):**
```json
{
    "id_administrador": 3,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Hernesto",
    "segundo_nombre": null,
    "primer_apellido": "Jaramillo",
    "segundo_apellido": null
}
```

---

### ❌ DELETE `/api/v1/admins/{id}` - Eliminar admin

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api/v1/admins/{id}` - Obtener por ID

- **Descripción:** Devuelve los datos de una entidad específica.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
    "id_administrador": 3,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Hernesto",
    "segundo_nombre": null,
    "primer_apellido": "Jaramillo",
    "segundo_apellido": null
}
```

---

### 📋 GET `/api/v1/admins/get_admins` - Obtener todos los administradores

- **Descripción:** Lista todos los elementos de la tabla.
- **Respuesta (lista de DTOs):**
```json
[
    {
        "id_administrador": 2,
        "correo": "telefono",
        "telefono": "334445511",
        "primer_nombre": "Hernesto",
        "segundo_nombre": null,
        "primer_apellido": "Jaramillo",
        "segundo_apellido": null
    },
    {
        "id_administrador": 3,
        "correo": "telefono",
        "telefono": "334445511",
        "primer_nombre": "Hernesto",
        "segundo_nombre": null,
        "primer_apellido": "Jaramillo",
        "segundo_apellido": null
    }
]
```

## Admin general

### ✅ POST `/api/v1/admin_general/save_admin_general` - Crear nuevo admin general

- **Descripción:** Crea una nueva entidad de admin general en la base de datos, pidiendo en esta el modelo asignado a la entidad
- **Cuerpo de la solicitud (JSON):**
```json
{
    "primer_nombre" : "Administrado",
    "primer_apellido" : "General",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```
- **Respuesta esperada (Entidad :**
```json
{
    "id_administrador_general": 2,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Administrado",
    "segundo_nombre": null,
    "primer_apellido": "General",
    "segundo_apellido": null
}
```

---

### 📝 PUT `/api/v1/admin_general/update_admin_general` - Actualizar admin general

- **Descripción:** Modifica los datos de una entidad existente.
- **Cuerpo de la solicitud (JSON - Modelo T):**
```json
{
    "primer_nombre" : "Administrado",
    "primer_apellido" : "General",
    "correo" : "telefono",
    "telefono" : "334445511"
}
```
- **Respuesta esperada (Entidad F actualizada):**
```json
{
    "id_administrador_general": 2,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Administrado",
    "segundo_nombre": null,
    "primer_apellido": "General",
    "segundo_apellido": null
}
```

---

### ❌ DELETE `/api//api/v1/admin_general/{id}` - Eliminar admin general

- **Descripción:** Elimina un recurso por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

---

### 🔍 GET `/api//api/v1/admin_general/{id}` - Obtener por ID

- **Descripción:** Devuelve los datos de una entidad específica.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO - E):**
```json
{
    "id_administrador_general": 2,
    "correo": "telefono",
    "telefono": "334445511",
    "primer_nombre": "Administrado",
    "segundo_nombre": null,
    "primer_apellido": "General",
    "segundo_apellido": null
}
```

---

### 📋 GET `/api//api//api/v1/admin_general/get_all` - Obtener todos los admins generales

- **Descripción:** Lista todos los elementos de la tabla.
- **Respuesta (lista de DTOs):**
```json
[
    {
        "id_administrador_general": 1,
        "correo": "telefono",
        "telefono": "334445511",
        "primer_nombre": "Administrado",
        "segundo_nombre": null,
        "primer_apellido": "General",
        "segundo_apellido": null
    },
    {
        "id_administrador_general": 2,
        "correo": "telefono",
        "telefono": "334445511",
        "primer_nombre": "Administrado",
        "segundo_nombre": null,
        "primer_apellido": "General",
        "segundo_apellido": null
    }
]
```


---

<<<<<<< lorax

## Habitacion

### ✅ POST `/api/v1/habitaciones/save_habitacion` - Crear nueva Habitación

- **Descripción:** Crea una nueva entidad de habitación en la base de datos, usando el modelo HabitacionModel.
- **Cuerpo de la solicitud (JSON):**

```json
{
  "numeroHabitacion": 101,
  "idTipoHabitacion": 1,
  "precioDia": 150000,
  "disponible": true,
  "idHotel": 1
}
```

- **Respuesta esperada (Entidad):**

```json
{
  "id_habitacion": 1,
  "numeroHabitacion": 101,
  "tipoHabitacion": { "idTipoHabitacion": 1, ... },
  "precioDia": 150000,
  "disponible": true,
  "hotel": { "idHotel": 1, ... }
}
```


### 📝 PUT `/api/v1/habitaciones/update_habitacion` - Actualizar Habitación

- **Descripción:** Modifica los datos de una habitación existente.
- **Cuerpo de la solicitud (JSON - Modelo HabitacionModel):**

```json
{
  "idHabitacion": 1,
  "numeroHabitacion": 102,
  "idTipoHabitacion": 2,
  "precioDia": 160000,
  "disponible": false,
  "idHotel": 1
}
```

- **Respuesta esperada (Entidad actualizada):**

```json
{
  "id_habitacion": 1,
  "numeroHabitacion": 102,
  "tipoHabitacion": { "idTipoHabitacion": 2, ... },
  "precioDia": 160000,
  "disponible": false,
  "hotel": { "idHotel": 1, ... }
}
```


### ❌ DELETE `/api/v1/habitaciones/{id}` - Eliminar Habitación

- **Descripción:** Elimina una habitación por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.


### 🔍 GET `/api/v1/habitaciones/{id}` - Obtener Habitación por ID

- **Descripción:** Devuelve los datos de una habitación específica.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO HabitacionDTO):**

```json
{
  "idHabitacion": 1,
  "numeroHabitacion": 101,
  "idTipoHabitacion": 1,
  "precioDia": 150000,
  "disponible": true,
  "idHotel": 1
}
```


### 📋 GET `/api/v1/habitaciones/get_all_habitaciones` - Obtener todas las Habitaciones

- **Descripción:** Lista todas las habitaciones.
- **Respuesta (lista de DTOs HabitacionDTO):**

```json
[
  {
    "idHabitacion": 1,
    "numeroHabitacion": 101,
    "idTipoHabitacion": 1,
    "precioDia": 150000,
    "disponible": true,
    "idHotel": 1
  },
  {
    "idHabitacion": 2,
    "numeroHabitacion": 102,
    "idTipoHabitacion": 2,
    "precioDia": 160000,
    "disponible": false,
    "idHotel": 1
  }
]
```

## TipoHabitacion

### ✅ POST `/api/v1/tipos-habitacion/save_tipo-habitacion` - Crear nuevo Tipo de Habitación

- **Descripción:** Crea un nuevo tipo de habitación en la base de datos.
- **Cuerpo de la solicitud (JSON):**

```json
{
  "nombre": "Suite Presidencial",
  "cantidad": 5
}
```

- **Respuesta esperada (Entidad):**

```json
{
  "idTipoHabitacion": 1,
  "nombre": "Suite Presidencial",
  "cantidad": 5,
  "Habitacion": null
}
```


### 🔍 GET `/api/v1/tipos-habitacion/{id}` - Obtener Tipo de Habitación por ID

- **Descripción:** Devuelve los datos de un tipo de habitación específico.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO):**

```json
{
  "idTipoHabitacion": 1,
  "idHotel": null,
  "nombre": "Suite Presidencial",
  "cantidad": 5
}
```


### 📋 GET `/api/v1/tipos-habitacion/get_all_tipos_habitacion` - Obtener todos los Tipos de Habitación

- **Descripción:** Lista todos los tipos de habitación disponibles.
- **Respuesta (lista de DTOs):**

```json
[
  {
    "idTipoHabitacion": 1,
    "idHotel": null,
    "nombre": "Suite Presidencial",
    "cantidad": 5
  },
  {
    "idTipoHabitacion": 2,
    "idHotel": null,
    "nombre": "Habitación Familiar",
    "cantidad": 10
  }
]
```


### 📝 PUT `/api/v1/tipos-habitacion/{id}` - Actualizar Tipo de Habitación

- **Descripción:** Modifica los datos de un tipo de habitación existente.
- **Cuerpo de la solicitud (JSON):**

```json
{
  "idTipoHabitacion": 1,
  "nombre": "Suite Presidencial Deluxe",
  "cantidad": 7
}
```

- **Respuesta esperada (Entidad actualizada):**

```json
{
  "idTipoHabitacion": 1,
  "nombre": "Suite Presidencial Deluxe",
  "cantidad": 7,
  "Habitacion": null
}
```


### ❌ DELETE `/api/v1/tipos-habitacion/{id}` - Eliminar Tipo de Habitación

- **Descripción:** Elimina un tipo de habitación por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

## Hotel

### ✅ POST `/api/v1/hoteles/save_hotel` - Crear nuevo Hotel

- **Descripción:** Crea un nuevo hotel en la base de datos.
- **Cuerpo de la solicitud (JSON):**

```json
{
  "nombre": "Hotel Plaza",
  "ciudad": "Bogotá",
  "telefono": "6011234567",
  "correo": "reservas@hotelplaza.com",
  "direccion": "Calle 100 # 7-20"
}
```

- **Respuesta esperada (Entidad):**

```json
{
  "idHotel": 1,
  "nombre": "Hotel Plaza",
  "ciudad": "Bogotá",
  "telefono": "6011234567",
  "correo": "reservas@hotelplaza.com",
  "direccion": "Calle 100 # 7-20"
}
```


### 🔍 GET `/api/v1/hoteles/{id}` - Obtener Hotel por ID

- **Descripción:** Devuelve los datos de un hotel específico.
- **Parámetro:** `id` (Long)
- **Respuesta (DTO):**

```json
{
  "idHotel": 1,
  "nombre": "Hotel Plaza",
  "ciudad": "Bogotá",
  "telefono": "6011234567",
  "correo": "reservas@hotelplaza.com",
  "direccion": "Calle 100 # 7-20"
}
```


### 📋 GET `/api/v1/hoteles/get_all_hoteles` - Obtener todos los Hoteles

- **Descripción:** Lista todos los hoteles disponibles.
- **Respuesta (lista de DTOs):**

```json
[
  {
    "idHotel": 1,
    "nombre": "Hotel Plaza",
    "ciudad": "Bogotá",
    "telefono": "6011234567",
    "correo": "reservas@hotelplaza.com",
    "direccion": "Calle 100 # 7-20"
  },
  {
    "idHotel": 2,
    "nombre": "Hotel Caribe",
    "ciudad": "Cartagena",
    "telefono": "6059876543",
    "correo": "info@hotelcaribe.com",
    "direccion": "Avenida del Mar # 5-60"
  }
]
```


### 📝 PUT `/api/v1/hoteles/update_hotel` - Actualizar Hotel

- **Descripción:** Modifica los datos de un hotel existente.
- **Cuerpo de la solicitud (JSON):**

```json
{
  "idHotel": 1,
  "nombre": "Hotel Plaza Premium",
  "ciudad": "Bogotá",
  "telefono": "6017654321",
  "correo": "reservas@plazapremium.com",
  "direccion": "Calle 100 # 7-25"
}
```

- **Respuesta esperada (Entidad actualizada):**

```json
{
  "idHotel": 1,
  "nombre": "Hotel Plaza Premium",
  "ciudad": "Bogotá",
  "telefono": "6017654321",
  "correo": "reservas@plazapremium.com",
  "direccion": "Calle 100 # 7-25"
}
```


### ❌ DELETE `/api/v1/hoteles/{id}` - Eliminar Hotel

- **Descripción:** Elimina un hotel por su ID.
- **Parámetro:** `id` (Long)
- **Respuesta:** `204 No Content` si se elimina correctamente.

=======
> 📅 Última actualización: 2025-06-27
>>>>>>> main

