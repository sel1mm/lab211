package fibonacci;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Fibonacci {    
    public static int getUserInput(){
        Scanner sc = new Scanner (System.in);
        int number = 0;
        do{
            try{
                System.out.print("Enter the number of elements: ");
                number = sc.nextInt();
                if(number<=0||number>Integer.MAX_VALUE) System.out.println("Error! Try Again");
                else break;
            } catch(InputMismatchException e){
                System.out.println("Error! Try Again");
                sc.nextLine();
            }
        } while (true);
        return number;
    }
    
    public static long[] FibonacciRecursion(long[] arrFibo, int index){
        if (index == arrFibo.length) {
            return arrFibo;
        }
        if(index <= 1) {
            arrFibo[index] = index;
            return FibonacciRecursion(arrFibo, index + 1);
        }
        else {
            arrFibo[index] = arrFibo[index - 2] + arrFibo[index - 1];
            return FibonacciRecursion(arrFibo, index + 1);
        }
    }
    
    public static void displayArrFibo(long[] arrFibo, int length){
        for(int i = 0; i < length; i++){
            System.out.println(i+ ". " + arrFibo[i]);
        }
    }
    
    public static void main(String[] args) {
        int n = getUserInput();
        long[] arrFibo = new long[n];
        FibonacciRecursion(arrFibo, 0);
        displayArrFibo(arrFibo, n);
    }
    
}


