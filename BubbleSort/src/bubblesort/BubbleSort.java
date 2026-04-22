
package bubblesort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {
    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        int number;
        do{
            try{
                System.out.print("Enter number of elements: ");
                number = sc.nextInt();
                if(number <= 0 || number > Integer.MAX_VALUE) System.out.println("Error! Try Again");
                else break;
            } catch(InputMismatchException e){
                System.out.println("Error! Try Again");
                sc.nextLine();
            }
        } while (true);
        return number;
    }
    
    public static int[] generateRandomArr(int n){
        int[] arr = new int[n];
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(101);
        }
        return arr;
    }
    
    public static void displayArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if(i+1!=arr.length) System.out.print(", ");
            else System.out.println("");
        }
    }
    
    public static void sortByBubbleSort(int[] arr){
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int n = getUserInput();
        int[] a = new int[n];
        a = generateRandomArr(n);
        displayArr(a);
        sortByBubbleSort(a);
        System.out.println("After sorted by Bubble Sort: ");
        displayArr(a);
        
    }
    
}
