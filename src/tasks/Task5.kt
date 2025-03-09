package tasks

/* Используя asSequence, выполните последовательную фильтрацию и
возведение в квадрат для списка четных чисел, но только после того как вы
преобразуете его в Sequence.*/

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val sequence = list.asSequence()
    val result = sequence
        .filter { it % 2 == 0 }
        .map { it * it }
        .toList()
    println(result)
}