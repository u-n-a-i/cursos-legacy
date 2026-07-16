fun main() {
    try {
        println("Ingrese un número entre 1 y 99: ")
        val numero = readLine()!!.toInt()
        if (numero in 1..99) {
            if (numero < 10) {
                println("Tiene un dígito")
            } else {
                println("Tiene dos dígitos")
            }
        } else {
            println("Número fuera de rango")
        }
    }catch (e: Exception){}
}
