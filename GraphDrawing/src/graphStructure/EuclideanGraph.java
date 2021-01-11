package graphStructure;

public class EuclideanGraph extends Graph {
	
	public double connectionRadius;
	
	public EuclideanGraph(int N, double radius, double boxSize) {
		
		super(N);
		
		this.connectionRadius = radius;
		
		for(int i = 0; i < vertexList.length; i++) {
			
			vertexList[i] = new VertexWithPosition(i, boxSize);
			
		}
		
		super.populateGraph();
		
		
	}
	
	public boolean isConnected(Vertex v, Vertex u) throws IllegalArgumentException {
		
		if(v instanceof VertexWithPosition && u instanceof VertexWithPosition) {
			
			double[] testCords1 = ((VertexWithPosition) (v)).getCoOrd();
			
			double[] testCords2 = ((VertexWithPosition) (u)).getCoOrd();
			
			
			if(EuclideanMath.l2Norm(testCords1, testCords2) < this.connectionRadius) {return true;}
			else {return false;}
			
			
		} else {
			
			throw new IllegalArgumentException("This vertex does not have co-ordinates!");
		
		}
	
	}
	
	
	
	
	
	static class EuclideanMath{
		
		private static double l2Norm(double[] v, double[] u) throws IllegalArgumentException {
			
			if(v.length != 2 || u.length != 2) {
				 
				throw new IllegalArgumentException("The CoOrds are the wrong size!");
				
			} else {
				
				
				return 
						Math.sqrt((v[0] - u[0])*(v[0] - u[0]) + (v[1] - u[1])*(v[1] - u[1]));
				}
			
			
			
		}
		
		
	}
	

}
