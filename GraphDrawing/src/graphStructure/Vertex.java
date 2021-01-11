package graphStructure;

import java.util.ArrayList;

public class Vertex {
	
	private int vertexLabel;
	
	private ArrayList<Vertex> neighbourhood = new ArrayList<Vertex>();
	
	
	public Vertex(int N) {
		
		vertexLabel = N;
	}
	
	public void addVertex(Vertex u) {
		
		if(neighbourhood.contains(u) || u.vertexLabel == this.vertexLabel) {return;}
		else {
		
		neighbourhood.add(u);
		}
	}

	public void setVertexLabel(int vertexLabel) {
		this.vertexLabel = vertexLabel;
	}

    public ArrayList<Vertex> getNeighbourhood() {
		return this.neighbourhood;
	}

	public int getVertexLabel() {
		return vertexLabel;
	}
	
	
	public void printNeighbours() {
		
		for(Vertex v : this.neighbourhood) {
			
			System.out.println(" " + v.vertexLabel + " ");
			
		}
		
		
	}




}
