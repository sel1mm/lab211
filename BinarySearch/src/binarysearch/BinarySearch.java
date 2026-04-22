package binarysearch;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
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
    
    public static int searchByBinarySearch(int[] arr, int key){
        int l = 0;
        int h = arr.length - 1;
        while(l <= h){
            int mid = (l + h)/2;
            if(key == arr[mid]) return mid;
            if(key > arr[mid]){
                l = mid + 1;
            }
            else h = mid - 1;
        }
        return -1;
    }
    
    public static int searchByBinarySearch2(int[] arr, int l, int h, int key){
        if(l <= h){
            int mid = (l + h)/2;
            if(arr[mid] == key) return mid;
            
            if(arr[mid] < key) return searchByBinarySearch2(arr, mid + 1, h, key);
            else return  searchByBinarySearch2(arr, l, mid - 1, key);
        }
        return -1;
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
    
    public static int[] findAllOccurrences(int[] arr, int key){
        int number = searchByBinarySearch(arr, key);
        if(number != -1){
            int left = number, right = number;
            
            while(left >= 0 && arr[left] == key){
                left--;
            }
            
            while(right < arr.length && arr[right] == key){
                right++;
            }
            
            int[] result = new int[right - left - 1];
            for(int i = left + 1; i < right; i++){
                result[i - (left + 1)] = i;
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
        sortbyInsertionSort(a);
        displayArr(a);
        System.out.println("The index of number that want to find is: ");
        displayArr(findAllOccurrences(a, 10));
    }
    
}
