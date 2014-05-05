package com.endava.shape;

public class Circle extends Shape{
	
	private static final String FIGURE_NAME = "Circle";
	private double radius;




	public Circle(){
		
	}
	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public double computeArea() {
		// TODO Auto-generated method stub
		return Math.pow(this.radius, 2) * Math.PI;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public void helloWorld() {
		// TODO Auto-generated method stub
		super.helloWorld();
		System.out.println("Hello world from a "+FIGURE_NAME);
	}
	

}
