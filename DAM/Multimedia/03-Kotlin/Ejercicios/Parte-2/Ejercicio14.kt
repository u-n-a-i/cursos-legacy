fun main() {
    var c0 = 0
    var c1 = 0
    var c2 = 0
    var c3plus = 0

    repeat(10) {
        print("Cantidad de hijos en familia ${it + 1}: ")
        val hijos = readln().toInt()
        when (hijos) {
            0 -> c0++
            1 -> c1++
            2 -> c2++
            else -> c3plus++
        }
    }

    println("0 hijos: $c0")
    println("1 hijo: $c1")
    println("2 hijos: $c2")
    println("3 o más hijos: $c3plus")
}