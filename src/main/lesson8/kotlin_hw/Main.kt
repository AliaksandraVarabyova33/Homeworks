package kotlin_hw

fun main() {
    val productsCatalog = arrayListOf<Product>()
    productsCatalog.add(Clothing(150.0))
    productsCatalog.add(Food(150.0))
    productsCatalog.add(Electronics(150.0))

    for (product in productsCatalog) {
        println(product.getFinalPrice())
    }

}