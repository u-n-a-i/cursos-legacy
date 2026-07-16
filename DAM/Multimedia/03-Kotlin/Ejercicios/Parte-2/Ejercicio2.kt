fun main(){
    print("Total de preguntas: ")
    val totalPreguntas = readln().toIntOrNull()

    print("Total de respuestas acertadas: ")
    val respuestasCorrectas = readln().toIntOrNull()

    if (totalPreguntas == null || respuestasCorrectas == null || totalPreguntas <= 0 || respuestasCorrectas < 0 || respuestasCorrectas > totalPreguntas) {
        println("Error: revisa datos")
    }else{
        val porcentaje = (respuestasCorrectas.toDouble() / totalPreguntas.toDouble()) * 100

        when{
            porcentaje >= 90 -> println("Nivel máximo")
            porcentaje >= 75 -> println("Nivel medio")
            porcentaje >= 50 -> println("Nivel regular")
            else -> println("Fuera del nivel")
        }
    }



}