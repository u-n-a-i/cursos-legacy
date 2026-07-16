from pymongo import MongoClient

# A)
# 1. Conexión al clúster (reemplaza con tu URI si usas Atlas)
client = MongoClient("mongodb+srv://unai_dam:v2rSUlEHvkummGdB@cluster0.z3rb8wp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0")  # o tu URI de MongoDB Atlas

# 2. Mostrar todas las bases de datos disponibles
print("Bases de datos disponibles:")
print(client.list_database_names())

# ----------------------

# B)

# 1. Crear base de datos y colección
db = client["empresa"]
empleados = db["empleados"]

# 2. Insertar documentos
documentos = [
    {"nombre": "Ana", "edad": 28, "departamento": "Ventas"},
    {"nombre": "Luis", "edad": 35, "departamento": "TI"},
    {"nombre": "Marta", "edad": 41, "departamento": "Finanzas"},
    {"nombre": "Jorge", "edad": 30, "departamento": "TI"},
    {"nombre": "Laura", "edad": 25, "departamento": "Marketing"}
]

empleados.insert_many(documentos)
print("Documentos insertados correctamente.")

# ----------------------

# C)
# 1. Empleados del departamento "TI"
print("Empleados del departamento TI:")
for doc in empleados.find({"departamento": "TI"}):
    print(doc)

# 2. Empleados con edad mayor a 30
print("Empleados con edad > 30:")
for doc in empleados.find({"edad": {"$gt": 30}}):
    print(doc)

# ----------------------

# D)
# 1. Cambiar departamento de Luis
empleados.update_one({"nombre": "Luis"}, {"$set": {"departamento": "Soporte Técnico"}})

# 2. Aumentar edad en 1 año a empleados de TI
empleados.update_many({"departamento": "TI"}, {"$inc": {"edad": 1}})

# ----------------------

# E)

# 1. Eliminar empleados del departamento "Ventas"
empleados.delete_many({"departamento": "Ventas"})

# 2. Eliminar empleados con edad menor a 28
empleados.delete_many({"edad": {"$lt": 28}})

# ----------------------