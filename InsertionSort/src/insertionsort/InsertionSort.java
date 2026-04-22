package insertionsort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {
    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        int number;
        do{
            try{
                System.out.print("Enter number of elements: ");
                number = sc.nextInt();
                if(number <= 0 || number > Integer.MAX_VALUE) System.out.println("Error! Try Again");
                else break;
            } catch (InputMismatchException e){
                System.out.println("Error! Try Again");
                sc.nextLine();
            }
        } while(true);
        return number;
    }
    
    public static int[] generateRandomArr(int number){
        Random rand = new Random();
        int[] arr = new int[number];
        for(int i = 0; i < number; i++){
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
    
    public static void sortbyInsertionSort(int[] arr){
        int key, j;
        for(int i = 1; i < arr.length; i++){
            key = arr[i];
            j = i;
            while(j > 0 && key < arr[j - 1]){
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

    public static void main(String[] args) {
        int number = getUserInput();
        int[] a = new int[number];
        a = generateRandomArr(number);
        System.out.println("Random array before use Insertion sort: ");
        displayArray(a);
        sortbyInsertionSort(a);
        System.out.println("Array after used Insertion sort: ");
        displayArray(a);
    }
    
}
