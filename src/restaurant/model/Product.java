package restaurant.model;

import javafx.scene.image.Image;
import restaurant.Main;

public class Product {

    // CONSTANTS

    public static final Product PIZZA_WITH_SHIT = new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Пиццуха с гавнецом", "А вот из чего эта я догадываюсь...", 2600, 0);
    public static final Product DEFAULT_PIZZA = new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Какая-то рандомная пицца", "Я ебу из чего она состоит?", 2500, 1);

    // FIELDS

    private Image productImage;
    private String name;
    private String description;
    private int price;
    private int id;

    // CONSTRUCTOR

    public Product(Image productImage, String name, String description, int price, int id){
        this.productImage = productImage;
        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    // GETTERS


    public Image getProductImage() { return productImage; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getPrice() { return price; }

    public int getId() { return id; }

    // TO STRING METHOD

    @Override
    public String toString() {
        return name + "\n" + description + "\n" + price;
    }
}
