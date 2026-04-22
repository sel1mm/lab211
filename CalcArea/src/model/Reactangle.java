package model;

public class Reactangle implements Shape {
    public double width;
    public double length;
    
    public Reactangle(){
        
    }
    
    public Reactangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return 2*(this.width + this.length);
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public void printResult() {
        System.out.println("Width: " + width);
        System.out.println("Length: " + length);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }
}
