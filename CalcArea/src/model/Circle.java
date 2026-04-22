package model;

public class Circle implements Shape {
    private double radius;
    
    public Circle(){
        
    }
    
    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void printResult() {
        System.out.println("Radius: " + this.radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
    
    
}
