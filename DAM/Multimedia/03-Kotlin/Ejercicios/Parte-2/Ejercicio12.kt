fun main() {
    var entre = 0
    var mas = 0
    var menos = 0
    var total = 0

    println("Ingresar pesos (0 para terminar):")
    while (true) {
        val peso = readln().toDoubleOrNull() ?: 0.0
        if (peso == 0.0) break
        total++

        when {
            peso in 9.8..10.2 -> entre++
            peso > 10.2 -> mas++
            else -> menos++
        }
    }

    println("Entre 9.8 y 10.2 kg: $entre")
    println("Más de 10.2 kg: $mas")
    println("Menos de 9.8 kg: $menos")
    println("Total: $total")
}