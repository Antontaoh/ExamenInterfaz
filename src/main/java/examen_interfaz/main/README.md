# Examen Interfaces Segundo Trimestre

## 🔧 Tecnologías Utilizadas
- **Backend:** Spring Boot 3.4.3
- **Base de Datos:** MongoDB
- **Frontend:** Thymeleaf + HTML + CSS
- **API REST:** Spring Web
- **Generación de Reportes:** JasperReports
- **Documentación:** JavaDoc

## 🚀 Cómo Ejecutar el Proyecto

### **Clonar y Ejecutar el Proyecto**
```sh
git clone https://github.com/tu-repositorio/ExamenInterfaz.git
cd ExamenInterfaz
```

## 📌 Endpoints de la API

### 🔹 **Obtener Todos los Ítems**
**GET** `/api/items`
#### 📌 **Respuesta Esperada:**
```json
[
  {
    "_id": "65f12b3c4d1f4c2a",
    "id": 1,
    "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
    "price": 109.95,
    "category": "men's clothing",
    "description": "Your perfect pack for everyday use...",
    "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
    "rate": 3.9,
    "count": 120
  }
]
```

### 🔹 **Obtener un Ítem por su ID**
**GET** `/api/items/{id}`
#### 📌 **Ejemplo de Respuesta:**
```json
{
  "_id": "65f12b3c4d1f4c2a",
  "id": 1,
  "title": "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
  "price": 109.95,
  "category": "men's clothing",
  "description": "Your perfect pack for everyday use...",
  "image": "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
  "rate": 3.9,
  "count": 120
}
```

### 🔹 **Añadir un Nuevo Ítem**
**POST** `/api/items`
#### 📌 **Ejemplo de Cuerpo de la Solicitud:**
```json
{
  "id": 21,
  "title": "Nuevo Producto",
  "price": 50.0,
  "category": "nueva categoria",
  "description": "Descripción del producto",
  "image": "https://via.placeholder.com/150",
  "rate": 4.5,
  "count": 10
}
```
#### 📌 **Respuesta:**
```json
{
  "_id": "65f12b3c4d1f4c2b",
  "id": 21,
  "title": "Nuevo Producto",
  "price": 50.0,
  "category": "nueva categoria",
  "description": "Descripción del producto",
  "image": "https://via.placeholder.com/150",
  "rate": 4.5,
  "count": 10
}
```

### 🔹 **Eliminar un Ítem**
**DELETE** `/api/items/{id}`
#### 📌 **Respuesta:**
```
200 OK
```

### 🔹 **Generar Informe PDF**
**GET** `/api/reports/items`
🔹 **Devuelve un archivo PDF con la lista de ítems.**

## 🌐 Descripción de la Web
- **📜 Página Principal:** `/items`
    - Muestra todos los ítems con **título, precio y categoría**.
    - Permite hacer clic en un ítem para ver su detalle.

- **🔍 Detalle de Ítem:** `/items/{id}`
    - Muestra **toda la información** del ítem, incluyendo su imagen.

- **➕ Añadir un Ítem:**
    - Formulario en `/items` para ingresar nuevos ítems.

- **🗑️ Eliminar un Ítem:**
    - Botón de eliminación en la lista de ítems.

- **📄 Generar Reporte:**
    - Botón en `/items` para descargar un **PDF con la lista de ítems**.

## 📌 Autor
**Antonio Pérez Anglada 2ºDAM**

