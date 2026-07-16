fun main() {
    print("Nota 1: ")
    val n1 = readln().toDouble()
    print("Nota 2: ")
    val n2 = readln().toDouble()
    print("Nota 3: ")
    val n3 = readln().toDouble()

    val prom = (n1 + n2 + n3) / 3

    val mensaje = when {
        prom >= 7 -> "Promocionado"
        prom >= 4 -> "Regular"
        else -> "Suspenso"
    }

    println("Promedio: $mensaje")
}