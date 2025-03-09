package tasks

//Создайте объект класса Person с полем name, используя apply. Затем выведите имя через let.

fun main() {
    val person = Person().apply {
        name = "Charlie"
    }

    person.let {
        println(it.name)
    }
}

class Person(var name: String? = null)