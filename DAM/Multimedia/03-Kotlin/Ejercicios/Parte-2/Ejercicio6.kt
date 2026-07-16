fun main() {
    var peso: Double
    var entre98y102 = 0
    var mayores102 = 0
    var menores98 = 0
    var total = 0

    do {
        // Todo: controlar texto
        print("Ingrese el peso de la pieza (0 para terminar): ")
        peso = readln().toDouble()

        if (peso != 0.0) {
            total++
            when {
                peso in 9.8..10.2 -> entre98y102++
                peso > 10.2 -> mayores102++
                peso < 9.8 -> menores98++
            }
        }
    } while (peso != 0.0)

    println("Resultados:")
    println("Piezas entre 9.8 Kg y 10.2 Kg: $entre98y102")
    println("Piezas con más de 10.2 Kg: $mayores102")
    println("Piezas con menos de 9.8 Kg: $menores98")
    println("Total de piezas procesadas: $total")
}
