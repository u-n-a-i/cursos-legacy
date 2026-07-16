fun main() {
   try {
       println("Primer número")
       val num1 = readln().toInt()

       println("Segundo Número")
       val num2 = readln().toInt()

       println("Suma: ${num1 + num2}")
       println("Producto: ${num1 * num2}")
   }catch (e: Exception){
       println("Introduce un número entero")
   }
}