package kotlin_hw

class Electronics(price: Double) : Item(price), Product {

    override fun getFinalPrice(): Double = price * 0.9
}