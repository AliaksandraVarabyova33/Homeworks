package java_hw;

public class Food extends Item implements Product {

    public Food(double price) {
        super(price);
    }

    @Override
    public double getFinalPrice() {
        return price;
    }
}
