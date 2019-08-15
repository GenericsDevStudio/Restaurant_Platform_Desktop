package restaurant.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Product {

    // FIELDS

    private Image productImage;
    private String name;
    private String description;
    private int price;

    // CONSTRUCTOR

    public Product(Image productImage, String name, String description, int price){
        this.productImage = productImage;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // GETTERS


    public Image getProductImage() { return productImage; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getPrice() { return price; }


    // TO STRING METHOD

    @Override
    public String toString() {
        return name + "\n" + description + "\n" + price;
    }
}
