fun main() {
    println("cantidad de empleados:")
    val n = readLine()!!.toIntOrNull()

    if (n == null || n <= 0) {
        println("Cantidad inválida de empleados")
        return
    }

    var entre100y300 = 0
    var masDe300 = 0
    var gastoTotal = 0

    for (i in 1..n) {
        println("Ingresa el sueldo del empleado $i (entre 100 y 500):")
        val sueldo = readLine()!!.toIntOrNull()

        if (sueldo == null) {
            println("Entrada inválida, por favor ingrese un número")
            continue
        }

        if (sueldo < 100 || sueldo > 500) {
            println("Sueldo fuera de rango, debe estar entre 100 y 500")
            continue
        }

        if (sueldo <= 300) {
            entre100y300++
        } else {
            masDe300++
        }

        gastoTotal += sueldo
    }

    println("Empleados que cobran entre 100 y 300 euros: $entre100y300")
    println("Empleados que cobran más de 300 euros: $masDe300")
    println("Gasto total en sueldos: $gastoTotal euros")
}
