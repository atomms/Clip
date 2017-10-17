package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    class WingClipper {
        private Ellipse ellipse;
        private Circle circle;
    	
    	@FXML
        private ImageView imageView;
        

        @FXML
        public void initialize() {           
            ellipse = new Ellipse();
//            circle = new Circle((imageView.getFitWidth()));

            ellipse.centerXProperty().setValue(95);
            ellipse.centerYProperty().setValue(70);
            ellipse.radiusXProperty().setValue(70);
            ellipse.radiusYProperty().setValue(70);
            
//            importing and modifying sizes
//        	ellipse.radiusXProperty().setValue(imageView.getFitWidth()*0.1);
//        	ellipse.radiusYProperty().setValue(imageView.getFitHeight()*0.17);
//          ellipse.radiusXProperty().bind(root.widthProperty().multiply(0.8));
//          ellipse.radiusYProperty().bind(root.heightProperty().multiply(0.6));
            
            imageView.setClip(ellipse);

// apply a shadow effect.
            imageView.setEffect(new DropShadow(120, Color.BLACK));

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(
                "batmanlostinthemix.fxml"
            )
        );
        loader.setController(new WingClipper());

        Pane batman = loader.load();

        stage.setTitle("Where's Batman?");
        stage.setScene(new Scene(batman));
        stage.show();
    }
}