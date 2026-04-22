package mergesort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {
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
                System.out.println("Error! Try again");
                sc.nextLine();
            }
        } while(true);
        return number;
    } 
    
    public static int[] generateRandomArr(int number){
        Random rand = new Random();
        int[] arr = new int[number];
        for(int i = 0; i < number; i++){
            arr[i] = rand.nextInt(50)+1;
        }
        return arr;
    }
    
    public static void merge(int[] arr, int l, int m, int r){
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for(i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        for(j = 0; j < n2; j++){
            R[j] = arr[m + 1 + j];
        }
        
        i = 0;
        j = 0;
        k = l;
        
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    
    public static void sortByMergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = l + (r - l)/ 2;
            
            sortByMergeSort(arr, l, m);
            sortByMergeSort(arr, m + 1, r);
            
            merge(arr, l, m, r);
        }
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
        System.out.println("Unsorted Array: ");
        displayArr(a);
        sortByMergeSort(a, 0, number - 1);
        System.out.println("Sorted Array: ");
        displayArr(a);
    }
    
}
