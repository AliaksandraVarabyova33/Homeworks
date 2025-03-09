package hw_tasks

/*Напишите функцию, которая принимает список целых чисел и
возвращает их сумму. Используйте лямбду в качестве параметра для определения операции.*/
fun main() {
    val list = listOf(1, 2, 3, 4)
    val emptyList = listOf<Int>()
    println(sumListElements(list) { sum, currentElement -> sum + currentElement })
    println(sumListElements(emptyList) { acc, num -> acc + num })
}

fun sumListElements(list: List<Int>, operation: (acc: Int, Int) -> Int): Int {
    return list.reduceOrNull(operation) ?: 0
}