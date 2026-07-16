fun main(){
    try {
        println("Lado del cuadrado")
        val lado = readln().toInt()

        println("El perimetro del cuadrado es: ${lado * 4}")

    }catch (e : Exception){
        println("Introduce un entero")
    }
}