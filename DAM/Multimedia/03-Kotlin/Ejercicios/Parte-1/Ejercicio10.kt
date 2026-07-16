fun main(){
    try {
        println("Primera nota")
        val nota1 = readln().toDouble()

        println("Segunda nota")
        val nota2 = readln().toDouble()

        println("Tercera nota")
        val nota3 = readln().toDouble()

        val promedio = (nota1 + nota2 + nota3) / 3
        if (promedio >= 7) {
            println("Promocionado")
        }
    }catch (e: Exception){
        println("Introduce un formato valido")
    }
}