fun main() {
    print("Ingrese la cantidad de triángulos: ")
    val n = readln().toInt()

    var equilateros = 0
    var isosceles = 0
    var escalenos = 0

    repeat(n) { i ->
        println("Triángulo ${i + 1}:")
        print("Ingrese lado 1: ")
        val lado1 = readln().toInt()
        print("Ingrese lado 2: ")
        val lado2 = readln().toInt()
        print("Ingrese lado 3: ")
        val lado3 = readln().toInt()

        // Determinar tipo de triángulo
        if (lado1 == lado2 && lado2 == lado3) {
            println("Es un triángulo equilátero")
            equilateros++
        } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
            println("Es un triángulo isósceles")
            isosceles++
        } else {
            println("Es un triángulo escaleno")
            escalenos++
        }
    }

    println("Resumen:")
    println("Cantidad de triángulos equiláteros: $equilateros")
    println("Cantidad de triángulos isósceles: $isosceles")
    println("Cantidad de triángulos escalenos: $escalenos")
}
