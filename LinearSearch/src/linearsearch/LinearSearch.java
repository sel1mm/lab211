package linearsearch;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {
    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        int number;
        do{
            try{
                System.out.println("Enter number of elements: ");
                number = sc.nextInt();
                if(number <= 0 || number > Integer.MAX_VALUE) System.out.println("Error! Try Again");
                else break;
            } catch(InputMismatchException e){
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
            arr[i] = rand.nextInt(10)+1;
        }
        return arr;
    }
    
    public static int searchByLinearSearch(int[] arr, int number){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == number) return i;
        }
        return -1;
    }
    
    public static int[] findAllOccurences(int[] arr, int number){
        int key = searchByLinearSearch(arr, number);
        if(key != -1){
            int count = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == number) count++;
            }
            
            int[] result = new int[count];
            int index = 0;
            
            for(int i = 0; i < arr.length; i++){
                if(arr[i] == number){
                    result[index] = i;
                    index++;
                }
            }
            
            return result;
        }
        else return new int[0];
    }
    
    public static void displayArr(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(i == 0) System.out.print("[");
            System.out.print(arr[i]);
            if(i + 1 != arr.length) System.out.print(", ");
            else{
                System.out.print("]");
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int number = getUserInput();
        int[] a = new int[number];
        a = generateRandomArr(number);
        System.out.println("The array: ");
        displayArr(a);
        System.out.println("The index of number that want to find is: ");
        displayArr(findAllOccurences(a, 10));
    }
    
}
