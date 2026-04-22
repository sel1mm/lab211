package selectionsort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SelectionSort {
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
        }while(true);
        return number;
    }
    
    public static int[] generateRandomArr(int number){
        Random rand = new Random();
        int[] arr = new int[number];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rand.nextInt(100)+1;
        }
        return arr;
    }

    public static void displayArray(int[] arr){
        int length = arr.length;
        for(int i = 0; i < length; i++){
            System.out.print(arr[i]);
            if(i+1!=length) System.out.print(", ");
            else System.out.println("");
        }
    }
    
    public static void sortBySelectionSort(int arr[]){
        int min;
        for(int i = 0; i < arr.length; i++){
            min = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
    
    public static void main(String[] args) {
        int number = getUserInput();
        int[] a = new int[number];
        a = generateRandomArr(number);
        System.out.println("Random array when not use Selection Sort yet: ");
        displayArray(a);
        sortBySelectionSort(a);
        System.out.println("Array after used Selection Sort: ");
        displayArray(a);
    }
    
}
