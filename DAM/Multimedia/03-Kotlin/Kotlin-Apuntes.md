# Kotlin

```kotlin

```

## Teoría

Es un lenguaje moderno y multiplataforma, se puede usar para front/back/móvil.

### Características

- **Interoperatividad con otros lenguajes**: Se puede usar junto a Java en un mismo proyecto. Usar las librerías de Java. También se puede usar para JavaScript(con Kotlin/JS).
- **Sintaxis concisa**: Reduce el código repetitivo. Eje. clases Data.
- **Inferencia de datos**: No es necesario declarar el tipo de dato, lo infiere solo.
- **Null Safety(seguridad contra null)**: Evita el NullPointerException. El sistema distingue entre variables que pueden ser nulas.
- **Multiplataforma**: Android,iOS, back y web.
- **Corrutinas**: Manejo sencillo y eficiente de concurrencia y asincronía. Se puede usar lazy loading(lazy{}) para evitar trabajo innecesario.

### Kotlin nativo

- Se ejecuta sin una JVM, gracias a la utilización de una máquina virtual de bajo nivel (LLVM).
- Al no haber la necesidad de una JVM se puede ejecutar en entornos como iOS.
- Tiene la capacidad de producir un ejecutable autónomo.

### Android/Kotlin

- Soporte de Google.
- Método findViewById() se puede evitar y acceder directamente con el identificador del XML.

### Null Safety

- La Null Safety es una de las características más importantes de Kotlin.
- En Java cualquier referencia puede ser null.
- Si intentas acceder a un objeto que es null, obtienes el famoso NullPointerException.
- En Kotlin, las variables por defecto no pueden ser nulas.
- Si quieres que una variable pueda contener null, debes declararlo explícitamente con ?.
- **Safe Call (?.)**: Permite acceder a una propiedad o método solo si no es null:
- **Elvis Operator (?:)**: Permite dar un valor por defecto si la variable es null:
- **Not-null Assertion (!!)**: Le dices al compilador: “confía en mí, no es null”.

## Básico

### Main

```kotlin
fun main {

}
```

### Variables

- Solo lectura(constante): `val saludo = "Hola"`
- Mutables (variable): `var saludo = "Hola"`

### Mostrar datos

- Misma linea: `print()`
- Salto de linea: `println()`
- Template String: `print("Texto ${variable}")`

### Rangos

#### Rango inclusivo (..)

```kotlin
val rango = 1..5
println(rango)        // 1,2,3,4,5
for (i in rango) {
    println(i)        // imprime del 1 al 5
}
```

#### Rango descendente (downTo)

```kotlin
for (i in 5 downTo 1) {
    println(i)        // imprime 5,4,3,2,1
}
```

#### Rango con paso (step)

```kotlin
for (i in 1..10 step 2) {
    println(i)        // imprime 1,3,5,7,9
}
```

#### Rango exclusivo (until)

```kotlin
for (i in 1 until 5) {
    println(i)        // imprime 1,2,3,4 (el 5 no se incluye)
}
```

#### Rangos de caracteres

```kotlin
for (c in 'a'..'e') {
    println(c)        // imprime a, b, c, d, e
}
```

## Colecciones

### Lists

```kotlin
// Inmutable
val inmutable = listOf(“manzan”, “limon”, “leche”)

// Mutable
val mutable = mutableListOf("leche", "galletas")
println(mutable)
mutable.add("manzana")
println(mutable)
```

### Set

Lista sin duplicados

`setOf()` y `mutableSetOf()`

### Map

Clave -> Valor

```kotlin
val provincias = mapOf(
    "EUS" to "Euskadi",
    "GAL" to "Galicia"
)
println(provincias["EUS"])
```

## Condicionales

```kotlin

```

## Bucles

```kotlin

```

## Funciones

```kotlin

```

## Seguridad nula(Null safety)

```kotlin

```

## Teclado

- `readLine()`: más seguro y flexible, ideal si procesas datos donde puede faltar entrada.
- `readln()`: más simple y directo, ideal para programas interactivos donde siempre esperas que el usuario escriba algo.

> readln().toIntOrNull()

## Tips

### Leer por teclado(preventiva)

```kotlin
fun main(){
    println("Introduce un numero")
    val num = readln().toIntOrNull()

    if(num != null){
        val longitud = num.toString().length

        when(longitud){
            1 -> println("1 cifra")
            2 -> println("2 cifras")
            3 -> println("3 cifras")
            else -> println("Error: es mayor")
        }
    }else{
        println("Mete un número entero positivo")
    }
}

// Mayor y Menor
val mayor = maxOf(num1, num2, num3)
val menor = minOf(num1, num2, num3)

Se puede comparar cadenas con ==. No hace falta equals.

//Validar Por teclado
if (num == null) return println("Debe ser un num entero")


```
