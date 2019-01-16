

public class Generation {
	public static int numInGen = 1000;
	public static Node[] currentGen = new Node[numInGen];
	public Generation() {
		for(int i = 0; i < currentGen.length; i++) {
			currentGen[i] = new Node(Main.targetPer, Node.generateRandomData());
		}
	
	}
	
	public static void Evolve() {
		boolean finished = true;	
		
		while(finished) {
			finished = false;
			Node temp = new Node(0, 0);
			for(int i = 0; i < currentGen.length - 1; i++) {
				if(currentGen[i].getFitness() < currentGen[i + 1].getFitness()) {
					temp = currentGen[i + 1];
					currentGen[i + 1] = currentGen[i];
					currentGen[i] = temp;
					finished = true;
				}
			}
		}
		Node[] newGen = new Node[numInGen];
		for(int k = 0; k < currentGen.length; k++) {
			newGen[k] = new Node(Main.targetPer, Node.generateRandomData());
		}
		for(int i = 0; i < currentGen.length/3; i++) {
			newGen[i] = currentGen[i].mutate();
			}
		
		currentGen = newGen;
		
		System.out.println("Done");
		for(int j = 0; j < currentGen.length - 1; j++) {
			System.out.println(currentGen[j].getFitness());
		}
	}
	
	
	public static int getBestLength() {
		return currentGen[0].getLength();
	}
	public static int getBestWidth() {
		return currentGen[0].getWidth();
	}
	
	public static int getWorstLength() {
		return currentGen[currentGen.length/3 - 1].getLength();
	}
	public static int getWorstWidth() {
		return currentGen[currentGen.length/3 - 1].getWidth();
	}
}
