from pymongo import MongoClient, errors

uri = "mongodb+srv://unai_dam:v2rSUlEHvkummGdB@cluster0.z3rb8wp.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"

# Conectarse al cluster
client = MongoClient(uri)
print("Conexión MongoDB Atlas OK")

# Seleccionar BBDD y colección
db = client["miempresa"]
empleados = db["empleados"]

# Inserta 5 documentos nuevos a la colección de empleados
# Comentado para que no me duplique 
# TODO Evitar duplicados
# empleados.insert_many([
#   { "nombre": "Javier", "edad": 40, "cargo": "Director de Proyectos", "salario": 62000 },
#   { "nombre": "María", "edad": 26, "cargo": "Diseñadora UX", "salario": 38000 },
#   { "nombre": "Sofía", "edad": 32, "cargo": "Desarrolladora Backend", "salario": 47000 },
#   { "nombre": "Tomás", "edad": 29, "cargo": "Especialista en QA", "salario": 40000 },
#   { "nombre": "Elena", "edad": 34, "cargo": "Scrum Master", "salario": 51000 }
# ])

# print("Documentos insertados en la colección 'empleados'")

# Consulta: Muestra todos los empleados
print("\n Todos los empleados:")
for empleado in empleados.find():
    print(empleado)

# Consulta: Muestra solo los empleados mayores de 30 años
print("\nEmpleados mayores de 30 años:")
for empleado in empleados.find({ "edad": { "$gt": 30 } }):
    print(empleado)


# Actualiza el salario de Ana
result = empleados.update_one(
{ "nombre": "Ana" },
{ "$set": { "salario": 36000 } }
)
print(f"\n Documentos modificados: {result.modified_count}")

# Consulta: Muestra los datos después de la actualización
print("\n Empleados después de la actualización:")
for empleado in empleados.find():
    print(empleado)