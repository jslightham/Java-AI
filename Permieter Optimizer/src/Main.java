import processing.core.PApplet;

public class Main extends PApplet{
	public static int targetPer = 1000;
	public static Generation currentGen = new Generation();
	
	public static void main(String[] args) {
		
		PApplet.main("Main");
		
	}
	
	public void settings() {
		size(1000, 1000);
	}
	public void setup() {
		frameRate(5);
	}
	public void draw() {
		
		Generation.Evolve();
		background(0);
		fill(255);
		stroke(255);
		rect(100, 100, Generation.getWorstWidth(), Generation.getWorstLength());
	}
}
