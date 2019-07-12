
public class Node {
	private int width;
	private int length;
	private int fitness;
	private double offset = 0.008;
	private int name;
	private static int previousName = 0;
	public Node(int targetPer, int width) {
		this.width = width;
		this.length = targetPer - this.width;
		this.fitness = getFitness();
		this.name = previousName++;
	}
	public Node(int targetPer, int width, int name) {
		this.width = width;
		this.length = targetPer - this.width;
		this.fitness = getFitness();
		this.name = name;
	}
	//public Node mutate(){
	//	Node previousGen = Main.currentGen;
	//	
	//	return ; 
	//}
	
	/*
	 * This is sortof cheating, but it makes it more interesting to watch. 
	 * The algorithm will not allow random nodes to be created that are too similar to the actual shape so that the only way there is through evolution, 
	 * and not by it being generated in the first generation.
	 */
	public static int generateRandomData() {
		if(true) { // should get info from Main.onlyEvolution, but seems to be always false
		int num = Main.targetPer/2;
		int tollerance = 300;
		while(Math.abs(num-500) <=tollerance) {
			num = (int)(Math.random()*1000);
		}
		return num;
		}else {
			return (int)(Math.random()*1000);
		}
		
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
		return new Node(Main.targetPer, (int)(this.width - increment), this.name);
	}
	public int getName() {
		return this.name;
	}
}
