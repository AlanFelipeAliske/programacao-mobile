import java.util.*

fun fact() {
    val reader = Scanner(System.`in`)
    print("Entre com um positivo: ")
    val num = reader.nextInt()
    if (num < 0) {
        println("Erro.")
        return
    }
    var factorial = 1
    for (i in 2..num) {
        factorial *= i
    }
    println("Fatorial de $num = $factorial")
}

fun fatorial() {
    val num = 10
    var i = 1
    var factorial: Long = 1
    while (i <= num) {
        factorial *= i.toLong()
        i += 1
    }
    println("Fatorial $num = $factorial")
}

fun numeros() {
    val numbers = mutableListOf<Double>()
    for (i in 1..3) {
        print("Digite um numero:  $i: ")
        numbers.add(readLine()?.toDouble() ?: 0.0)
    }
    numbers.sort()
    println("Os numeros em ordem crescente são:")
    for (num in numbers) {
        println(num)
    }
}

fun media() {
    print("Digite a nota 1 do aluno: ")
    val grade1 = readLine()?.toDouble() ?: 0.0
    print("Digite a nota 2 do aluno: ")
    val grade2 = readLine()?.toDouble() ?: 0.0
    print("Digite a nota 3 do aluno: ")
    val grade3 = readLine()?.toDouble() ?: 0.0
    val weightedAverage = (grade1 * 2 + grade2 * 3 + grade3 * 5) / 10
    if (weightedAverage >= 7) {
        println("Aprovado")
    } else if (weightedAverage >= 4) {
        println("Exame final")
    } else {
        println("Reprovado!")
    }
}

fun money() {
    print("Insira um valor monetário: ")
    val value = readLine()?.toDouble() ?: 0.0
    val coins = listOf(1.00, 0.50, 0.25, 0.10, 0.05, 0.01)
    var values = (value * 100).toInt()
    println("Moedas necessárias:")
    for (coin in coins) {
        val count = values / (coin * 100).toInt()
        values %= (coin * 100).toInt()
        println("$coin * $count")
    }
}

fun main() {
    println("Estudo dirigido 02")
    fact()
    fatorial()
    numeros()
    media()
    money()
}

