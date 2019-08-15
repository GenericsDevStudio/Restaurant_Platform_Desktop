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
        tilePane.setMaxWidth(Region.USE_PREF_SIZE);
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
        Label main = new Label(product.getName() + "\n" + product.getDescription() + "\n" + product.getPrice(), current);
        main.setContentDisplay(ContentDisplay.TOP);
        main.setOnMouseClicked(e -> {
            if (selectedLabel != main) {
                clearSelection();
                selectLabel(main);
            } else {
                if(e.getButton().equals(MouseButton.PRIMARY)){
                    if(e.getClickCount() == 2){
                        tilePane.getChildren().remove(main);
                        clearSelection();
                    }
                }
            }
        });
        tilePane.getChildren().add(main);
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
