package com.jslightham.perceptron;

import processing.core.PApplet;

public class Main extends PApplet{
	public Perceptron p;

	public static void main(String[] args) {
		PApplet.main("Main");

	}
	public void seup() {
		size(200, 200);
		p = new Perceptron();
		float[] inputs = {-1, 1};
		int guess = p.guess(inputs);
		System.out.println(guess);
	}

}
