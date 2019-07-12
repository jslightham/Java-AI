import processing.core.PApplet;

public class Main extends PApplet{
	public static int targetPer = 1000;
	public static Generation currentGen = new Generation();
	private int genNumber = 0;
	public static boolean onlyEvolution = true;
	
	public static void main(String[] args) {
		
		PApplet.main("Main");
		
	}
	
	public void settings() {
		size(1000, 1000);
	}
	public void setup() {
		frameRate(5);
	}
	
	public double fitness() {
		return (Generation.getBestFitness()-Generation.getAverageFitness())/Generation.getBestFitness();
	}
	public void draw() {
		genNumber++;
		
		Generation.Evolve();
		fitness();
		System.out.println(fitness());
		background(0);
		fill(255);
		stroke(255);
		text("Generation: " + genNumber, 0, height-10);
		textSize(32);
		text("Worst: " + Generation.getWorstFitness(), 0, 25);
		text("Name: " + Generation.getWorstName(), 0, 60);
		text("Average: " + Generation.getAverageFitness(), width/3, 25);
		text("Best: " + Generation.getBestFitness(), width*2/3, 25);
		text("Name: " + Generation.getBestName(), width*2/3, 60);
		rect(100, (height/2)-(int)(Generation.getWorstLength()*0.3), (int)(Generation.getWorstWidth()*0.3), (int)(Generation.getWorstLength()*0.3));
		rect(width/3+100, (height/2)-(int)(Generation.getAverageLength()*0.3), (int)(Generation.getAverageWidth()*0.3), (int)(Generation.getAverageLength()*0.3));
		rect(width-100-(int)(Generation.getBestWidth()*0.3), (height/2)-(int)(Generation.getBestWidth()*0.3), (int)(Generation.getBestWidth()*0.3), (int)(Generation.getBestLength()*0.3));
		rect(width/3-5, 0, 5, height);
		rect(width*2/3-5, 0, 5, height);
		//System.out.println("Worst WidthxLength: " + Generation.getWorstLength() + " " + Generation.getWorstWidth());
	}
	
	public static boolean getEvolutionStatus() {
		return onlyEvolution;
	}
}
