fun cuadrado() {
    print("Ingrese un entero: ")
    val x = readln().toInt()
    println("Cuadrado: ${x * x}")
}

fun producto() {
    print("Ingrese valor 1: "); val a = readln().toInt()
    print("Ingrese valor 2: "); val b = readln().toInt()
    println("Producto: ${a * b}")
}

fun main() {
    cuadrado()
    producto()
}