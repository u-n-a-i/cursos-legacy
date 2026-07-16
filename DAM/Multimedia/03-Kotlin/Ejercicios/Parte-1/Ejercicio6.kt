fun main(){
    try {
        println("Introduce un precio")
        val precio = readln().toDouble()
        println("Cantidad")
        val cantidad = readln().toInt()

        val total = precio * cantidad;
        println("Total: ${total}€")
    }catch (e: Exception){
        println("Tiene que se un número")
    }
}