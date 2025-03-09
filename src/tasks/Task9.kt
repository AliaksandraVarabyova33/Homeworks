package tasks

//Напишите расширение для List<Int>, которое возвращает среднее значение.

fun main() {
    print(listOf(1, 2, 3, 4).calculeteAverage())
}

fun List<Int>.calculeteAverage(): Double = this.sum().toDouble() / this.size
