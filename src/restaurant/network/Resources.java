package restaurant.network;

import restaurant.Main;
import restaurant.model.Product;
import java.util.LinkedList;

public class Resources extends Main{

    // THESE ARE JUST EXAMPLES


    public static void addProducts(){
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());

        products.get(0).add(Product.DEFAULT_PIZZA);
        products.get(0).add(Product.PIZZA_WITH_SHIT);
        products.get(1).add(Product.SUSPICIOUS_BURGER);
    }

    public static void buySelectedProducts(){
        for(Product product : cart){
            switch (product.getType()){
                case "PIZZA" : products.get(0).add(product);
                    break;
                case "BURGER" : products.get(1).add(product);
                    break;
                case "DRINK" : products.get(2).add(product);
                    break;
                case "SNACK" : products.get(3).add(product);
                    break;
                case "SAUCE" : products.get(4).add(product);
                    break;
            }
        }
        cart.clear();
    }
}


