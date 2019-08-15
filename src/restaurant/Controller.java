package restaurant;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
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
    private TilePane tilePane;

    private Label selectedLabel;

    @FXML
    void initialize() {
        Main.addProducts();
        tilePane.setPrefColumns(5);
        tilePane.setStyle("-fx-background-color: white ;");
        tilePane.setVgap(30);
        tilePane.setHgap(30);
        for(Product temp : Main.products.get(0)){
            addTileNode(temp);
        }


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

    private void addTileNode(Product product) {
        ImageView current = new ImageView(product.getProductImage());
        current.setFitWidth(150);
        current.setFitHeight(150);
        Label name = new Label(product.getName() + "\n" + product.getDescription() + "\n" + product.getPrice(), current);
        name.setContentDisplay(ContentDisplay.TOP);
        name.setOnMouseClicked(e -> {
            if (selectedLabel != name) {
                clearSelection();
                selectLabel(name);
            } else {
                clearSelection();
            }
        });
        tilePane.getChildren().add(name);
    }

    private void selectLabel(Label label) {
        label.setStyle("-fx-background-color: #f85656 ;");
        selectedLabel = label;
    }

    private void clearSelection() {
        if (selectedLabel != null)
            selectedLabel.setStyle("-fx-background-color: white ;");
    }

}
