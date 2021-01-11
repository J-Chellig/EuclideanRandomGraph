package graphStructure;

public class VertexWithPosition extends Vertex {
	
	private double[] coOrd = new double[2];
	
	public VertexWithPosition(int N, double boxSize) {
		
		super(N);
		
		coOrd[0] = Math.random()*(boxSize- 5);
		coOrd[1] = Math.random()*(boxSize - 5);
	}

	public double[] getCoOrd() {
		return coOrd;
	}
	
	
	
	

}
