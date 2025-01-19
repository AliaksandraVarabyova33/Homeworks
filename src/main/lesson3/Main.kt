fun main() {
    checkPalindromeNumber()
    checkPrimeNumber()
    calculateUntilSingleDigit()
    createInvertedLadder()
}

//Task1: Число палиндром
fun checkPalindromeNumber() {
    val number = getNumberFromKeyboard()
    val numberStr = number.toString()
    var left = 0
    var right = numberStr.length - 1

    while (left < right) {
        if (numberStr[left] != numberStr[right]) {
            println("Number is not a palindrome")
            return
        }
        left++
        right--
    }

    println("Number is a palindrome")
}

//Task2: Проверка простого числа
fun checkPrimeNumber() {
    val number = getNumberFromKeyboard()
    if (number <= 1) {
        println("Number is not a prime number")
        return
    }
    for (i in 2..Math.sqrt(number.toDouble()).toInt()) {
        if (number % i == 0) {
            println("Number is not a prime number")
            return
        }
    }
    println("Number is a prime number")
}

//Task3: Вычисление суммы цифр числа до единичного разряда
fun calculateUntilSingleDigit() {
    var number = getNumberFromKeyboard()
    while (number >= 10) {
        var sum = 0
        while (number > 0) {
            sum += number % 10
            number /= 10
        }
        number = sum
    }
    println(number)
}

//Task4: Перевёрнутая лесенка
fun createInvertedLadder() {
    val height = getNumberFromKeyboard()
    for (i in height downTo 1) {
        for (j in i downTo 1) {
            print("#")
        }
        println()
    }
}

//Additional reusable method to get data from console
fun getNumberFromKeyboard(): Int {
    println("Enter the number")
    val number = readln()
    return number.toInt()
}