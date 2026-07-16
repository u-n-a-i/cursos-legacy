fun validarClaves(clave1: String, clave2: String) {
    if (clave1 == clave2) println("Las claves coinciden.")
    else println("Las claves no coinciden.")
}

fun main() {
    print("Ingrese clave: "); val k1 = readLine()!!
    print("Repita la clave: "); val k2 = readLine()!!
    validarClaves(k1, k2)
}