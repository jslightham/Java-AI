package com.jslightham.perceptron;

public class Perceptron {
	float[] weights = new float[2];
	
	public Perceptron() {
		for(int i=0; i<weights.length; i++) {
			weights[i] = (float)(Math.random()*2 - 1);
		}
	}
	
	public int guess(float[] inputs) {
		float sum = 0;
		for(int i=0; i<weights.length; i++){
			sum+= inputs[i]*weights[i];
		}
		return sign(sum);
	}
	
	public int sign(float n) {
		if(n>0)
			return 1;
		else
			return 0;
	}
}
