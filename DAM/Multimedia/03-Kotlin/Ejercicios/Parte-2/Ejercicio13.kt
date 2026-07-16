fun main() {
    print("Cantidad de triángulos: ")
    val n = readln().toInt()
    var eq = 0
    var iso = 0
    var esc = 0

    repeat(n) {
        val l1 = readln().toInt()
        val l2 = readln().toInt()
        val l3 = readln().toInt()

        val tipo = when {
            l1 == l2 && l2 == l3 -> { eq++; "equilátero" }
            l1 == l2 || l2 == l3 || l1 == l3 -> { iso++; "isósceles" }
            else -> { esc++; "escaleno" }
        }
        println("Triángulo $tipo")
    }

    println("Equiláteros: $eq, Isósceles: $iso, Escalenos: $esc")
}