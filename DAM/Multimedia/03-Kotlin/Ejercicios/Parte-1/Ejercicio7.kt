fun main() {
//    println("Num-1")
//    val num1 = readln().toInt()
//
//    println("Num-2")
//    val num2 = readln().toInt()
//
//    println("Num-3")
//    val num3 = readln().toInt()
//
//    println("Num-4")
//    val num4 = readln().toInt()
//
//    val suma = num1 + num2 + num3 + num4
//    val promedio = (num1 + num2 + num3 + num4) / 4.0;
//
//    println("Suma: ${suma}")
//    println("Promedio: ${promedio}")

    var suma = 0;

    for (i in 1..4){
        println("(Introduce) Número-${i}")
        suma += readln().toInt()
    }
    println("Suma: ${suma}")

    val promedio = suma / 4.0
    println("Promedio: ${promedio}")


}