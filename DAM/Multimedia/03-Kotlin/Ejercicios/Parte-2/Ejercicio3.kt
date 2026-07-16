fun main() {
    print("Primer número: ")
    val num1 = readln().toIntOrNull()

    print("Segundo número: ")
    val num2 = readln().toIntOrNull()

    print("Tercero número: ")
    val num3 = readln().toIntOrNull()

    if (num1 == null || num2 == null || num3 == null){
        println("El número no es valido")
    }else{
        val mayor = if (num1 >= num2 && num1 >= num3){
            num1
        }else if (num2 >= num1 && num2 >= num3){
            num2
        }else{
            num3
        }

        val menor = if (num1 <= num2 && num1 <= num3){
            num1
        }else if (num2 <= num1 && num2 <= num3){
            num2
        }else{
            num3
        }

        println("El mayor de los tres números es: $mayor")
        println("El menor de los tres números es: $menor")
    }




}