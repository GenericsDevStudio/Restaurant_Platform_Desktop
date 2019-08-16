package restaurant;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import restaurant.model.Product;

public class Controller {

    // FIELDS

    @FXML
    private Button pizzaButton;

    @FXML
    private Button burgerButton;

    @FXML
    private Button sauceButton;

    @FXML
    private Button drinkButton;

    @FXML
    private Button snackButton;

    @FXML
    private Button paymentButton;

    @FXML
    private Rectangle rectangle;

    @FXML
    private TilePane tilePane;

    private Label selectedLabel;


    ////////
    // STARTING METHODS & BUTTON IMPLEMENTING
    ////////

    @FXML
    void initialize() {
        Main.addProducts();
        tilePane.setPrefColumns(5);
        tilePane.setStyle("-fx-background-color: white ;");
        tilePane.setVgap(30);
        tilePane.setHgap(30);
        tilePane.setMaxWidth(Region.USE_PREF_SIZE);
        System.out.println(Main.products.get(0));
        System.out.println(Main.products.get(1));
        showPizzas();

        pizzaButton.setOnAction(event -> {
            rectangle.setFill(Color.web("#f85656"));
            tilePane.getChildren().clear();
            showPizzas();
        });
        burgerButton.setOnAction(event -> {
            rectangle.setFill(Color.web("555AF0"));
            tilePane.getChildren().clear();
            showBurgers();
        });
        drinkButton.setOnAction(event -> {
            rectangle.setFill(Color.web("6187EF"));
            tilePane.getChildren().clear();
            showDrinks();
        });
        snackButton.setOnAction(event -> {
            rectangle.setFill(Color.web("EFC746"));
            tilePane.getChildren().clear();
            showSnacks();
        });
        sauceButton.setOnAction(event -> {
            rectangle.setFill(Color.web("86EC53"));
            tilePane.getChildren().clear();
            showSauces();
        });
        paymentButton.setOnAction(event -> {
            rectangle.setFill(Color.web("9053EC"));
            tilePane.getChildren().clear();
            showCart();
        });
    }

    // FIRST METHOD - FOR ALL PRODUCTS

    private void addTileNodes(Product product) {
        ImageView current = new ImageView(product.getProductImage());
        current.setFitWidth(150);
        current.setFitHeight(150);
        Label main = new Label(product.getName() + "\n" + product.getDescription() + "\n" + product.getPrice(), current);
        main.setContentDisplay(ContentDisplay.TOP);
        main.setOnMouseClicked(e -> {
            if (selectedLabel != main) {
                clearSelection();
                selectLabel(main);
            } else {
                if(e.getButton().equals(MouseButton.PRIMARY)){
                    if(e.getClickCount() >= 2){
                        switch (product.getType()){
                            case "PIZZA" :  Main.products.get(0).remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                                break;
                            case "BURGER" : Main.products.get(1).remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                                break;
                            case "DRINK" : Main.products.get(2).remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                                break;
                            case "SNACK" : Main.products.get(3).remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                                break;
                            case "SAUCE" : Main.products.get(4).remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                                break;
                        }
                        tilePane.getChildren().remove(main);
                        Main.cart.add(product);
                        clearSelection();
                    }
                }
            }
        });
        tilePane.getChildren().add(main);
    }

    // SECOND METHOD FOR CART - TO AVOID REDUNDANT CHECKS

    private void addTileNodesForCart(Product product){
        ImageView current = new ImageView(product.getProductImage());
        current.setFitWidth(150);
        current.setFitHeight(150);
        Label main = new Label(product.getName() + "\n" + product.getDescription() + "\n" + product.getPrice(), current);
        main.setContentDisplay(ContentDisplay.TOP);
        main.setOnMouseClicked(e -> {
            if(selectedLabel != main){
                clearSelection();
                selectLabel(main);
            }else{
                if(e.getButton().equals(MouseButton.PRIMARY)){
                    if(e.getClickCount() >= 2){
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
                        Main.cart.remove(tilePane.getChildrenUnmodifiable().indexOf(main));
                        tilePane.getChildren().remove(main);
                        clearSelection();
                    }
                }
            }
        });
        tilePane.getChildren().add(main);
    }

    // TILE PANE METHODS



    private void selectLabel(Label label) {
        label.setStyle("-fx-background-color: #f85656 ;");
        selectedLabel = label;
    }

    private void clearSelection() {
        if (selectedLabel != null)
            selectedLabel.setStyle("-fx-background-color: white ;");
    }

    private void showPizzas(){
        for(Product temp : Main.products.get(0)){
            addTileNodes(temp);
        }
    }

    private void showBurgers(){
        for(Product temp : Main.products.get(1)){
            addTileNodes(temp);
        }
    }

    private void showDrinks(){
        for(Product temp : Main.products.get(2)){
            addTileNodes(temp);
        }
    }

    private void showSnacks(){
        for(Product temp : Main.products.get(3)){
            addTileNodes(temp);
        }
    }

    private void showSauces(){
        for(Product temp : Main.products.get(4)){
            addTileNodes(temp);
        }
    }

    private void showCart(){
        for(Product temp : Main.cart){
            addTileNodesForCart(temp);
        }
    }
}
