package java_hw;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Product> productsCatalog = new ArrayList<>();
        productsCatalog.add(new Clothing(150));
        productsCatalog.add(new Clothing(90));
        productsCatalog.add(new Electronics(200));
        productsCatalog.add(new Food(30));
        productsCatalog.add(new Food(10));

        for (Product product : productsCatalog) {
            System.out.println(product.getFinalPrice());
        }
    }
}
