fun main(){
   try {
       println("Número entero")
       val num1 = readln().toInt()

       println("Otro número entero")
       val num2 = readln().toInt()

       if (num1 > num2){
           println("${num1} es mayor que ${num2}")
       }else if (num1 < num2){
           println("${num2} es mayor que ${num1}")
       }else{
           println("Son iguales")
       }
   }catch (e: Exception){
       println("Introduce números enteros")
   }
}