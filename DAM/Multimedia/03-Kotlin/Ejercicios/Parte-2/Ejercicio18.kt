fun mostrarOrdenados(a: Int, b: Int, c: Int) {
    val lista = listOf(a, b, c).sorted()
    println("Ordenados: ${lista.joinToString(", ")}")
}

fun main() {
    print("Valor 1: "); val x = readln().toInt()
    print("Valor 2: "); val y = readln().toInt()
    print("Valor 3: "); val z = readln().toInt()
    mostrarOrdenados(x, y, z)
}