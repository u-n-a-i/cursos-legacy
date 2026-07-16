from pymongo import MongoClient

# Cambia aquí tu URI de MongoDB Atlas
uri="mongodb+srv://unai_dam:v2rSUlEHvkummGdB@cluster0.z3rb8wp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

# Conectar al cluster
client = MongoClient(uri)
print("Conexión exitosa a MongoDB Atlas")

# Seleccionar base de datos y colección
db = client["miempresa"]
empleados = db["empleados"]

# Insertar 3 documentos en la colección
empleados.insert_many([
{ "nombre": "Ana", "edad": 28, "cargo": "Ingeniera", "salario": 35000 },
{ "nombre": "Luis", "edad": 35, "cargo": "Analista", "salario": 42000 },
{ "nombre": "Carla", "edad": 30, "cargo": "Gerente", "salario": 55000 }
])
print("Documentos insertados en la colección 'empleados'")

# Consulta: mostrar todos los empleados
print("\n Todos los empleados:")
for empleado in empleados.find():
    print(empleado)

# Consulta: empleados mayores de 30 años
print("\n Empleados mayores de 30 años:")
for empleado in empleados.find({"edad": {"$gt": 30}}):
    print(empleado)

# Actualizar el salario de Ana
result = empleados.update_one(
{ "nombre": "Ana" },
{ "$set": { "salario": 36000 } }
)
print(f"\n Documentos modificados: {result.modified_count}")

# Ver datos después de la actualización
print("\n Empleados después de la actualización:")
for empleado in empleados.find():
    print(empleado)