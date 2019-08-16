package restaurant.model;

import javafx.scene.image.Image;
import restaurant.Main;

public class Product {

    // CONSTANTS

    public static final Product PIZZA_WITH_SHIT = new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Пиццуха с гавнецом", "А вот из чего эта я догадываюсь...", 2600, "PIZZA");
    public static final Product DEFAULT_PIZZA = new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Какая-то рандомная пицца", "Я ебу из чего она состоит?", 2500,"PIZZA");
    public static final Product SUSPICIOUS_BURGER = new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Бургер", "отвечаю, это бургер", 228,"BURGER");

    // FIELDS

    private Image productImage;
    private String name;
    private String description;
    private int price;
    private String type;

    // CONSTRUCTOR

    private Product(Image productImage, String name, String description, int price, String type){
        this.productImage = productImage;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    // GETTERS


    public Image getProductImage() { return productImage; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getPrice() { return price; }

    public String getType() { return type; }

    // TO STRING METHOD

    @Override
    public String toString() {
        return name + " "+ description + " " + price;
    }
}
