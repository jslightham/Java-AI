
public class Node {
	private int width;
	private int length;
	private int fitness;
	private double offset = 0.008;
	public Node(int targetPer, int width) {
		this.width = width;
		this.length = targetPer - this.width;
		this.fitness = getFitness();
	}
	
	//public Node mutate(){
	//	Node previousGen = Main.currentGen;
	//	
	//	return ; 
	//}
	
	public static int generateRandomData() {
		return (int)(Math.random()*1000);
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getFitness() {
		return this.length*this.width;
		
		
	}
	
	public Node mutate() {
		double increment = Math.random()*(2*offset*Main.targetPer)-(offset*Main.targetPer);
		return new Node(Main.targetPer, (int)(this.width - increment));
}
}
