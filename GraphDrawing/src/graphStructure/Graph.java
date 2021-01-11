package graphStructure;

public abstract class Graph {
	
	protected Vertex[] vertexList;
	
	public Graph(int N) {
		
		vertexList = new Vertex[N];
	}		
		
	
public void populateGraph() {
	
		for(int i = 0; i < vertexList.length - 1; i++) {
			
			for(int j = i; j < vertexList.length; j++) {
				
				if(isConnected(vertexList[i], vertexList[j])) {
					
					addEdge(vertexList[i], vertexList[j]);
					}
				
				
				
			}
			
			
			
		}

}	
	
	public abstract boolean isConnected(Vertex v, Vertex u);
	
	public void addEdge(Vertex v, Vertex u) {
		
		v.addVertex(u);
		u.addVertex(v);
	}


	public Vertex[] getVertexList() {
		return vertexList;
	}
	
	
	
	
	
	
	

}
