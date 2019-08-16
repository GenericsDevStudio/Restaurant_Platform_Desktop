package restaurant;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import restaurant.model.Product;
import java.util.LinkedList;

public class Main extends Application {

    //

   static LinkedList<LinkedList<Product>> products = new LinkedList<>();
   static LinkedList<Product> cart = new LinkedList<>();

   //

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
        primaryStage.setTitle("Restaurant_Desktop");
        primaryStage.setScene(new Scene(root, 800, 500));
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

    // THESE ARE JUST EXAMPLES

    static void addProducts(){
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());
        products.add(new LinkedList<>());

        products.get(0).add(Product.DEFAULT_PIZZA);
        products.get(0).add(Product.PIZZA_WITH_SHIT);
        products.get(1).add(Product.SUSPICIOUS_BURGER);
    }

    static void buySelectedProducts(){
        for(Product product : cart){
            switch (product.getType()){
                case "PIZZA" : Main.products.get(0).add(product);
                    break;
                case "BURGER" : Main.products.get(1).add(product);
                    break;
                case "DRINK" : Main.products.get(2).add(product);
                    break;
                case "SNACK" : Main.products.get(3).add(product);
                    break;
                case "SAUCE" : Main.products.get(4).add(product);
                    break;
            }
            cart.remove(product);
        }
    }
}
