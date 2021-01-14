package graphDrawing;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GuiMain extends Application {
	
	
	private EuclideanDrawing test = new EuclideanDrawing(500, 300, 40);
	
	private Button redraw = new Button("Redraw!");
    
	static int numberOfNodes;
	static double connectionRadius;
	
	private Label nodeLabel = new Label("Number of Nodes:");
	private Label radiusLabel = new Label("Connection Radii:");
	
	
	private TextField nodeField = new TextField("300");
	private TextField radiusField = new TextField("40");
	
	public static void main(String[] args) {
		
		launch(args);
	}
	
	public void start(Stage stage) {
		
		
		HBox nodeBox = new HBox(10, nodeLabel, nodeField);
		HBox radiusBox = new HBox(10, radiusLabel, radiusField);
		
		HBox.setHgrow(nodeField, Priority.ALWAYS);
		nodeField.setMaxWidth(Double.POSITIVE_INFINITY);
		
		HBox.setHgrow(radiusField, Priority.ALWAYS);
		radiusField.setMaxWidth(Double.POSITIVE_INFINITY);
		
		VBox container = new VBox(20, nodeBox, radiusBox, redraw);
		
		
		BorderPane root = new BorderPane(test.getDrawingSpace(), null, container, null, null);
		
		
		redraw.setDefaultButton(true);
		
		redraw.setOnAction(e -> {
			
			onButtonPress(root);
		});
		

		
		
		
		Scene scene = new Scene(root, 800, 540);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Euclidean Random Graph");
}
	
	
	public void onButtonPress(BorderPane root) {
		
		
		if(Testing.setNumberofNodes(nodeField.getText()) && Testing.setConnectionRadius(radiusField.getText())) {
			
			EuclideanDrawing nextTest = new EuclideanDrawing(500, numberOfNodes, connectionRadius);
			root.setCenter(nextTest.getDrawingSpace());
			
			
		} else { return;}
		
		
		
	}
	
	
	
	public static class Testing{
		
		public static boolean setNumberofNodes(String s) {
			
			try {
				
			   numberOfNodes = Integer.parseInt(s);
				
			   
			   if(numberOfNodes <= 0) {return false;}
			   else {
			   return true;}
			} catch(NumberFormatException e) {
				
			System.out.println("Input must be an Integer");	
				
				
			}
			
			return false;
			
			
			
		}
		
        public static boolean setConnectionRadius(String s) {
			
			try {
				
			   connectionRadius = Double.parseDouble(s);
				
			   return true;
			} catch(NumberFormatException e) {
				
			System.out.println("Input must be a Double");	
				
				
			}
			
			return false;
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	

}
