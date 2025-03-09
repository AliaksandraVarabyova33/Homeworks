package tasks

// Используя filter, создайте новый список, содержащий только четные числа из исходного списка.

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6)
    val resultList = list.filter { it % 2 == 0 }
    println(resultList)
}