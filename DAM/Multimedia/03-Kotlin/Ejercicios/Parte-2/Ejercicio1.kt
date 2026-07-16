fun main(){
    print("Ingresa un número entero positivo: ")
    val numero = readln().toIntOrNull()

    if (numero == null || numero <=0){
        println("El número tiene que ser positivo")
    }else{
        val cifras = numero.toString().length

        when(cifras){
            1 -> println("El número tiene 1 cifra")
            2 -> println("El número tiene 2 cifra")
            3 -> println("El número tiene 3 cifra")
            else -> println("El número tiene más de 3 cifras")
        }
    }
}
