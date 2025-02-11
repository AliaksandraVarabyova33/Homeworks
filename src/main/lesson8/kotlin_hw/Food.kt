package kotlin_hw

class Food(price: Double) : Item(price), Product {
    override fun getFinalPrice(): Double = price
}