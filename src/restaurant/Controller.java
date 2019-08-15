package restaurant;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import restaurant.model.Product;

public class Controller {

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
    private ListView<Product> productsList;


    @FXML
    void initialize() {
        Main.products.add(new Product(new Image(Main.class.getResourceAsStream("randomPizza.png")), "Какая-то рандомная пицца", "Я ебу из чего она состоит?", 2500));
        ObservableList<Product> products = FXCollections.observableList(Main.products);
        System.out.println(Main.products);
        productsList.setItems(products);
        productsList.setCellFactory(callback -> new Cell());


        pizzaButton.setOnAction(event -> {
            rectangle.setFill(Color.web("#f85656"));
        });
        burgerButton.setOnAction(event -> {
            rectangle.setFill(Color.web("555AF0"));
        });
        drinkButton.setOnAction(event -> {
            rectangle.setFill(Color.web("6187EF"));
        });
        snackButton.setOnAction(event -> {
            rectangle.setFill(Color.web("EFC746"));
        });
        sauceButton.setOnAction(event -> {
            rectangle.setFill(Color.web("86EC53"));
        });
        paymentButton.setOnAction(event -> {
            rectangle.setFill(Color.web("9053EC"));
        });
    }

    static class Cell extends ListCell<Product>{
        VBox vbox = new VBox();
        Label name = new Label();
        Label descr = new Label();
        Label price = new Label();
        Pane pane = new Pane();
        ImageView img = new ImageView();

        Cell(){
            super();
            img.setFitHeight(200);
            img.setFitWidth(200);
            vbox.getChildren().addAll(img, name, descr, price);
            vbox.setAlignment(Pos.CENTER);
        }

        @Override
        protected void updateItem(Product product, boolean b) {
            super.updateItem(product, b);
            if(product != null && !b){
                name.setText(product.getName());
                descr.setText(product.getDescription());
                price.setText(Integer.toString(product.getPrice()));
                img.setImage(product.getProductImage());
                setGraphic(vbox);
            }
        }
    }
}
