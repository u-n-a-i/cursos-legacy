fun menorDeTres(): Int {
    print("Ingrese valor 1: "); val a = readln().toInt()
    print("Ingrese valor 2: "); val b = readln().toInt()
    print("Ingrese valor 3: "); val c = readln().toInt()
    return minOf(a, b, c)
}

fun main() {
    println("Primer grupo:")
    println("Menor: ${menorDeTres()}")

    println("Segundo grupo:")
    println("Menor: ${menorDeTres()}")
}