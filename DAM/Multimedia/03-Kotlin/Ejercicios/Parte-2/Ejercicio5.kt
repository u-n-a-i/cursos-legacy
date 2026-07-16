fun main() {
    val lista1 = mutableListOf<Int>()
    val lista2 = mutableListOf<Int>()

    println("Cargar 5 valores para la Lista 1:")
    for (i in 1..5) {
        print("Valor $i: ")
        val valor = readln().toIntOrNull()
        if (valor == null) {
            println("Entrada inválida, se asigna 0.")
            lista1.add(0)
        } else {
            lista1.add(valor)
        }
    }

    println("Cargar 5 valores para la Lista 2:")
    for (i in 1..5) {
        print("Valor $i: ")
        val valor = readln().toIntOrNull()
        if (valor == null) {
            println("Entrada inválida, se asigna 0.")
            lista2.add(0)
        } else {
            lista2.add(valor)
        }
    }

    val suma1 = lista1.sum()
    val suma2 = lista2.sum()

    println("Suma Lista 1: $suma1")
    println("Suma Lista 2: $suma2")

    if (suma1 > suma2) {
        println("Lista 1 mayor")
    } else if (suma2 > suma1) {
        println("Lista 2 mayor")
    } else {
        println("Listas iguales")
    }
}
