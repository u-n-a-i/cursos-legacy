from pymongo import MongoClient, errors

#Con captura de errores
try:
    # Cambia aquí tu URI de MongoDB Atlas
    uri = "mongodb://admin:admin123@localhost:27017/?authSource=admin"
    # Conectar al cluster
    client = MongoClient(uri)
    print(" Conexión exitosa a Locahost (Docker)")

    # Seleccionar base de datos y colección
    db = client["ejemplodb"]
    usuarios = db["usuarios"]

    if usuarios.count_documents({}) == 0:
        usuarios.insert_one({"nombre": "Sandra", "edad": 19, "email": "sandra@ejemplo.com"})
        print("Usuario de prueba insertado.")
    else:
        print("Ya tenemos documentos creados, no hace falta crear a Sandra!!")

    # Consulta: mostrar todos los empleados
    print("\n Todos los usuarios:")
    for usuario in usuarios.find():
        print(usuario)

    '''
    Si solo quieres mostrar los campos nombre y cargo de cada documento en tu colección usuarios, 
    puedes hacerlo fácilmente con MongoDB usando 1.proyección o 
    2.simplemente accediendo a los campos específicos en el bucle.
    '''
    # 1.Proyección:
    #   Nota: El "_id": 0 sirve para ocultar el campo _id que Mongo agrega automáticamente.
    print("\n ******* Proyección *********")
    for usuario in usuarios.find({}, {"nombre": 1, "cargo": 1, "_id": 0}):
        print(usuario)
    
    # 2.accediendo a los campos
    print("\n ******* Accediendo campos *********")
    for usuario in usuarios.find():
        print(f"Nombre: {usuario.get('nombre', 'N/A')}, Cargo: {usuario.get('cargo', 'N/A')}")

    # 3.Si queremos ordenar por nombre
    #   Nota: (1 = ascendente, -1 = descendente)
    print("\n ******* Ordenando por nombre en ascendente *********")
    for usuario in usuarios.find({}, {"nombre": 1, "cargo": 1, "_id": 0}).sort("nombre", 1):
        print(usuario)

    # 4.Si quieres filtrar los resultados, mostrar solo los usuarios con un cierto cargo
    print("\n ******* Filtrando por cargo, solo Gerente *********")
    for usuario in usuarios.find({"cargo": "Gerente"}, {"nombre": 1, "cargo": 1, "_id": 0}):
        print(usuario)

    # 5. Filtrar por varios cargos
    #   Nota: Puedes usar operadores de MongoDB, como $in (pertenencia a lista):
    print("\n ******* Filtrando por varios cargos, solo Gerente y Técnico *********")
    filtros = {"cargo": {"$in": ["Gerente", "Técnico"]}}
    for usuario in usuarios.find(filtros, {"nombre": 1, "cargo": 1, "_id": 0}):
        print(usuario)

except errors.ServerSelectionTimeoutError:
    print("No se pudo conectar al servidor MongoDB. ¿Está corriendo el contenedor?")
except Exception as e:
    print("Error inesperado:", e)