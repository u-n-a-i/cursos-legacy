fun main() {
    print("Ingrese un número del 1 al 10: ")
    val n = readln().toIntOrNull() ?: 0

    if (n !in 1..10) {
        println("Valor inválido.")
        return
    }

    println("Tabla del $n:")
    for (i in 1..12) {
        println("$n x $i = ${n * i}")
    }
}
