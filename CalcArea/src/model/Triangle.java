package model;

public class Triangle implements Shape {
    public double a;
    public double b;
    public double c;
    
    public Triangle(){
        
    }
    
    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    @Override
    public void printResult() {
        System.out.println("Side A: " + this.a);
        System.out.println("Side B: " + this.b);
        System.out.println("Side C: " + this.c);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
    
    
}
