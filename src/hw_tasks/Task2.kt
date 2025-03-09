package hw_tasks

/*Напишите программу, которая получает список людей, фильтрует только тех, кто старше 18 лет, затем сортирует их по возрасту в порядке
убывания и выводит на экран с помощью apply и let.*/


fun main() {
    val listOfCandidates = mutableListOf<Person>()

    listOfCandidates.apply {
        add(Person("Ivan", 36))
        add(Person("Vitalii", 57))
        add(Person("Andrey", 17))
        add(Person("Lubov", 25))
    }

    printQueueForBeer(listOfCandidates)
}

fun printQueueForBeer(listOfCandidates: List<Person>) {
    val queueForBeer = formQueueForBeer(listOfCandidates)
    queueForBeer.forEach { person ->
        person.let {
            println("${it.name}(${it.age} years)")
        }
    }
}

fun formQueueForBeer(listOfCandidates: List<Person>): List<Person> {
    return listOfCandidates
        .filter { it.age > 17 }
        .sortedByDescending { it.age }

}

class Person(val name: String, val age: Int)