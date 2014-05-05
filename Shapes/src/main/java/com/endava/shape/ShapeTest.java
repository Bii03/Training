package com.endava.shape;

/**
 * Hello world!
 *
 */
public class ShapeTest 
{
	public static double computeShapeArea(Shape shape){
		return shape.computeArea();
	}
	
    public static void main( String[] args )
    {
        Shape circle = new Circle(2.2);
        System.out.println("Circle area "+computeShapeArea(circle));
        circle.helloWorld();
        
        Shape rectangle = new Rectangle(2.2, 2.3);
        System.out.println("Rectangle area "+computeShapeArea(rectangle));
        rectangle.helloWorld();
        
        Shape triangle = new Triangle(2.1, 3);
        System.out.println("Triangle area "+computeShapeArea(triangle));
        triangle.helloWorld();
        
    }
}
