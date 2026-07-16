# pymongo_ejercicios.py
# Ejercicios típicos de examen sobre PyMongo — CRUD + consultas + agregaciones.

from pymongo import MongoClient
from pprint import pprint

# -------------------------------------------------------
# 1) Conectarse a MongoDB
# -------------------------------------------------------
# Normalmente en local el puerto por defecto es 27017.
# Si estás en un entorno de examen con Mongo Atlas, te darán una URL distinta.
client = MongoClient("mongodb://localhost:27017/")

# Crear / usar base de datos llamada 'tienda'
db = client["tienda"]

# Crear / usar colección llamada 'productos'
productos = db["productos"]

# -------------------------------------------------------
# 2) Limpiar colección (para no duplicar al repetir pruebas)
# -------------------------------------------------------
productos.delete_many({})

# -------------------------------------------------------
# 3) Insertar documentos (similares a filas de una tabla)
# -------------------------------------------------------
# Insertar varios documentos con insert_many
docs = [
    {"nombre": "Portátil", "categoría": "Electrónica", "precio": 850, "stock": 10},
    {"nombre": "Smartphone", "categoría": "Electrónica", "precio": 500, "stock": 25},
    {"nombre": "Silla Oficina", "categoría": "Mobiliario", "precio": 120, "stock": 15},
    {"nombre": "Mesa Escritorio", "categoría": "Mobiliario", "precio": 250, "stock": 8},
    {"nombre": "Auriculares", "categoría": "Electrónica", "precio": 80, "stock": 50}
]
productos.insert_many(docs)

print("Datos insertados correctamente.\n")

# -------------------------------------------------------
# 4) Consultas básicas (lectura)
# -------------------------------------------------------

print("Todos los productos:")
for p in productos.find():
    pprint(p)

print("\nProductos de la categoría Electrónica:")
for p in productos.find({"categoría": "Electrónica"}):
    pprint(p)

print("\nProductos con precio > 200:")
for p in productos.find({"precio": {"$gt": 200}}):
    pprint(p)

print("\nProductos con stock < 10:")
for p in productos.find({"stock": {"$lt": 10}}):
    pprint(p)

# -------------------------------------------------------
# 5) Insertar un producto adicional (insert_one)
# -------------------------------------------------------
nuevo_producto = {"nombre": "Impresora", "categoría": "Electrónica", "precio": 300, "stock": 12}
productos.insert_one(nuevo_producto)
print("\nNuevo producto insertado (Impresora).\n")

# -------------------------------------------------------
# 6) Actualizar documentos (update_one / update_many)
# -------------------------------------------------------
# Aumentar el precio de los productos de Electrónica un 10%
productos.update_many(
    {"categoría": "Electrónica"},
    {"$mul": {"precio": 1.10}}  # multiplica el campo precio por 1.10
)
print("Precios actualizados +10% para categoría Electrónica.\n")

# Mostrar los cambios
for p in productos.find({"categoría": "Electrónica"}):
    pprint(p)

# -------------------------------------------------------
# 7) Eliminar documentos (delete_one / delete_many)
# -------------------------------------------------------
# Eliminar productos cuyo stock < 10
productos.delete_many({"stock": {"$lt": 10}})
print("\nProductos con stock < 10 eliminados.\n")

# Ver cuántos quedan
print("Productos restantes:")
for p in productos.find():
    pprint(p)

# -------------------------------------------------------
# 8) Consultas con condiciones combinadas
# -------------------------------------------------------
print("\nProductos con stock >= 10 y precio <= 500:")
query = {"$and": [{"stock": {"$gte": 10}}, {"precio": {"$lte": 500}}]}
for p in productos.find(query):
    pprint(p)

# -------------------------------------------------------
# 9) Agregaciones (aggregate)
# -------------------------------------------------------
# Calcular precio promedio y total de stock por categoría
pipeline = [
    {"$group": {
        "_id": "$categoría",
        "precio_promedio": {"$avg": "$precio"},
        "stock_total": {"$sum": "$stock"}
    }}
]

print("\nAgregación — precio promedio y stock total por categoría:")
for r in productos.aggregate(pipeline):
    pprint(r)

# -------------------------------------------------------
# 10) Ordenación y proyección (sort, projection)
# -------------------------------------------------------
print("\nProductos ordenados por precio descendente (solo nombre y precio):")
for p in productos.find({}, {"_id": 0, "nombre": 1, "precio": 1}).sort("precio", -1):
    pprint(p)

# -------------------------------------------------------
# 11) Ejemplo de índice y búsqueda
# -------------------------------------------------------
productos.create_index("nombre")  # crea índice simple por campo nombre
print("\nÍndice creado en 'nombre'.\n")

# Buscar producto exacto
p = productos.find_one({"nombre": "Portátil"})
print("Búsqueda exacta por nombre:")
pprint(p)

# -------------------------------------------------------
# 12) Cerrar conexión
# -------------------------------------------------------
client.close()
print("\nConexión cerrada.")
