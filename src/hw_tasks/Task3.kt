package hw_tasks

/*Создайте список чисел от 1 до 1,000,000, отфильтруйте четные числа,
затем возведите их в квадрат и посчитайте сумму всех этих чисел. Сделайте это с
использованием asSequence для ленивой обработки.*/
fun main() {
    val numbers = (1..1_000_000L).toList()
    println(calculateResult(numbers))
}

fun calculateResult(list: List<Long>): Long {
    return list.asSequence()
        .filter { it % 2 == 0.toLong() }
        .map { it * it }
        .reduce { sum, currentElement -> sum + currentElement }
}

