package java_hw;

public class Clothing extends Item implements Product {

    public Clothing(double price) {
        super(price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.85;
    }
}
