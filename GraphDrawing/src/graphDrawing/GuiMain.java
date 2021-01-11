package graphDrawing;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.canvas.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class GuiMain extends Application {
	
	
	private EuclideanDrawing test = new EuclideanDrawing(500, 300, 40);
	
	private Button redraw = new Button("Redraw!");
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	public void start(Stage stage) {
		
		test.drawBoundingBox();
				
		BorderPane root = new BorderPane();
		root.setCenter(test.getDrawingSpace());
		root.setBottom(redraw);
		
		redraw.setOnAction(e -> {
			
			EuclideanDrawing nextTest = new EuclideanDrawing(500,300, 40);
			root.setCenter(nextTest.getDrawingSpace());
			
			
		});
		

		
		
		
		Scene scene = new Scene(root, 540, 540);
		
		stage.setScene(scene);
		stage.show();
		
		
		
		
	}
	
	

}
