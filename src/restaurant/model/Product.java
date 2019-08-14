package restaurant.model;

import javafx.scene.image.Image;

public class Product {

    private Image productImage;
    private String name;
    private String description;
    private int price;

    Product(Image productImage, String name, String description, int price){
        this.productImage = productImage;
        this.name = name;
        this.description = description;
        this.price = price;
    }


}
