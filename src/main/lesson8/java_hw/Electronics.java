package java_hw;

public class Electronics extends Item implements Product {

    public Electronics(double price) {
        super(price);
    }

    @Override
    public double getFinalPrice() {
        return price * 0.90;
    }
}
