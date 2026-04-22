package view;
import model.*;

public class DisplayView {
    public static void display(Triangle triangle, Reactangle reactangle, Circle circle){
        reactangle.printResult();
        triangle.printResult();
        circle.printResult();
    }
}
