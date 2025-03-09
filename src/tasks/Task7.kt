package tasks

//Создайте функцию inline, которая принимает два числа и выполняет операцию сложения через лямбду.

fun main() {
    println(calculate(2, 3) { a, b -> a + b })
}

inline fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)
