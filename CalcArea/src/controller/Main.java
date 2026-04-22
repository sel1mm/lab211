package controller;
import java.util.InputMismatchException;
import model.*;
import view.*;
import java.util.Scanner;

public class Main {
    public static double checkInputUser(){
        Scanner sc = new Scanner(System.in);
        do{
            try{
                double number = sc.nextDouble();
                if(number <= 0 && number > Double.MAX_VALUE) System.out.println("Re-try");
                else return number;
            } catch(InputMismatchException e){
                System.out.println("Re-try");
                sc.nextLine();
            }
        }while(true);
    }
    
    public static Triangle inputTriangle(){
        do{
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputUser();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputUser();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputUser();
            if(a + b > c && b + c > a && c + a > b) return new Triangle(a,b,c);
            else System.out.println("Re-try");
        }while(true);
    }
    
    public static Reactangle inputReactangle(){
        System.out.println("Please input side width of Reactangle: ");
        double width = checkInputUser();
        System.out.println("Please input side length of Reactangle: ");
        double length = checkInputUser();
        return new Reactangle(width, length);              
   }
    
    public static Circle inputCircle(){
        System.out.println("Please input radius of Circle: ");
        double radius = checkInputUser();
        return new Circle(radius);
    }
    
    public static void main(String[] args) {
        Reactangle reactangle = inputReactangle();
        Triangle triangle = inputTriangle();
        Circle circle = inputCircle();
        
        DisplayView view = new DisplayView();
        view.display(triangle, reactangle, circle);
    }
}
