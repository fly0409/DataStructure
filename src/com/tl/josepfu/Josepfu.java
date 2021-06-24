package com.tl.josepfu;

public class Josepfu {

	public static void main(String[] args) {
		JosepfulCircleDemo joseCircle = new JosepfulCircleDemo(41);
		//joseCircle.showCicle();
		int[] count = joseCircle.startCircle(0, 3);
		
		for(int i:count) {
			System.out.print(i+",");
		}

	}

}
