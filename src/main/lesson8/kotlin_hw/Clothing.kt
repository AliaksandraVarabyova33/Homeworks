package kotlin_hw

class Clothing(price: Double) : Item(price), Product {
    override fun getFinalPrice(): Double = price * 0.85
}