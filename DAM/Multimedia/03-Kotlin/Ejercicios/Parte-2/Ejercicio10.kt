fun main() {
    var neg = 0
    var pos = 0
    var mult15 = 0
    var sumaPares = 0

    println("Ingrese 10 valores enteros:")
    repeat(10) {
        val x = readln().toInt()
        if (x < 0) neg++
        if (x > 0) pos++
        if (x % 15 == 0 && x != 0) mult15++  // 0 es múltiplo
        if (x % 2 == 0) sumaPares += x
    }

    println("Negativos: $neg")
    println("Positivos: $pos")
    println("Múltiplos de 15: $mult15")
    println("Suma de pares: $sumaPares")
}