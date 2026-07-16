fun main() {
    val notas = IntArray(10)
    var mayoresIguales7 = 0
    var menores7 = 0

    for (i in 0 until 10) {
        print("Ingrese la nota ${i + 1}: ")
        val nota = readln().toInt()
        notas[i] = nota

        if (nota >= 7) {
            mayoresIguales7++
        } else {
            menores7++
        }
    }

    println("Cantidad de alumnos con nota >= 7: $mayoresIguales7")
    println("Cantidad de alumnos con nota < 7: $menores7")


    /*
    Mirar función repeat
    fun main() {
    var mayoresIgual7 = 0
    var menores7 = 0

    println("Ingrese 10 notas:")
    repeat(10) {
        val nota = readLine()!!.toDouble()
        if (nota >= 7) mayoresIgual7++ else menores7++
    }

    println("Notas ≥7: $mayoresIgual7")
    println("Notas <7: $menores7")
    }
     */
}

