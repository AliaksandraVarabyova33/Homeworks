package tasks

// Используя map, создайте новый список строк,где каждая строка — это строковое представление квадратов чисел из списка.

fun main() {
    val list = listOf(1, 2, 3, 4)
    val resultList = list.map { (it * it).toString() }
    println(resultList)
}