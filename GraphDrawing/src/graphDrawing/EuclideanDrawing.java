package graphDrawing;

import javafx.scene.canvas.*;
import javafx.scene.paint.*;
import graphStructure.EuclideanGraph;
import graphStructure.VertexWithPosition;
import graphStructure.Vertex;

public class EuclideanDrawing {

	private Canvas drawingSpace;
	
	private EuclideanGraph mainGraph;
	
	private GraphicsContext g;
	
	private double sizeofBox;
	
	private double vertexRadius = 4;
	
	public Canvas getDrawingSpace() {
		return drawingSpace;
	}


	public EuclideanDrawing(double boxSize, int numberOfVertices, double connectionRadius) {
		
		drawingSpace = new Canvas(boxSize + 40, boxSize + 40);
		
		mainGraph = new EuclideanGraph(numberOfVertices, connectionRadius, boxSize);
		
		g = drawingSpace.getGraphicsContext2D();
		
		this.sizeofBox = boxSize;
		
		drawBoundingBox();
		drawAllEdges();
		drawVertices();
		
		
	}
	
	
	
	public void drawBoundingBox() {
		
		double newCord = 0.5*drawingSpace.getWidth() - 0.5*this.sizeofBox;
		
		g.strokeRect(newCord, newCord, sizeofBox, sizeofBox);
		
		
		
	}
	
	public void drawVertex(VertexWithPosition v) {
		
		g.setStroke(Color.BLACK);
		g.setFill(Color.BLUE);
		
		double conversionFactor = 0.5*drawingSpace.getWidth() - 0.5*this.sizeofBox;
		
		
		
		g.strokeOval(v.getCoOrd()[0] + conversionFactor, v.getCoOrd()[1] + conversionFactor, this.vertexRadius, this.vertexRadius);
		g.fillOval(v.getCoOrd()[0] + conversionFactor, v.getCoOrd()[1] + conversionFactor, this.vertexRadius, this.vertexRadius);
		}
	
	public void drawVertices() {
		
		for(Vertex v : mainGraph.getVertexList()) {
			
			drawVertex((VertexWithPosition) (v));
			
		}
		
		
	}
	
	public void drawEdges(VertexWithPosition v) {
		
		g.setStroke(Color.BLACK);
		
		double conversionFactor = 0.5*this.vertexRadius + 0.5*drawingSpace.getWidth() - 0.5*this.sizeofBox;
		
		for(Vertex u : v.getNeighbourhood()) {
			
			g.strokeLine(conversionFactor + ((VertexWithPosition) (u)).getCoOrd()[0],
					conversionFactor + ((VertexWithPosition) (u)).getCoOrd()[1], 
					conversionFactor + ((VertexWithPosition) (v)).getCoOrd()[0], 
					conversionFactor + ((VertexWithPosition) (v)).getCoOrd()[1]);
			
			
		}
	}
	
		public void drawAllEdges() {
			
			
			for(Vertex u : mainGraph.getVertexList()) {
				
				drawEdges((VertexWithPosition) (u));

			}
			
		}
		
		
		
	
	
}
	

