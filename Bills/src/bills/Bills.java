package bills;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bills {
    
    public static int getUserInput(){
        Scanner sc = new Scanner(System.in);
        do{
            try{
                int number = sc.nextInt();
                if(number < 0 || number > Integer.MAX_VALUE) System.out.println("Please input a integer number again");
                else return number;
            }catch(InputMismatchException e){
                System.out.println("Please input a integer number");
                sc.nextLine();
            }
        }while(true);
    }
    
    public static int[] inputBills(){
        System.out.print("Input number of the bill: ");
        int size = getUserInput();
        int[] bills = new int[size];
        
        for(int i = 0; i < bills.length; i++){
            System.out.print("Input value of bill " + (i + 1) + ": ");
            bills[i] = getUserInput();
        }
        return bills;
    }
    
    public static int inputWallet(){
        System.out.print("Input value of Wallet: ");
        int wallet = getUserInput();
        return wallet;
    }
    
    public static int calcTotal(int[] bills){
        int total = 0;
        for(int i = 0; i < bills.length; i++){
            total += bills[i];
        }
        return total;
    }
    
    public static boolean payMoney(int total, int wallet){
        if(total > wallet) return false;
        else return true;
    }
    
    public static void printTotalAndResult(int[] bills, int wallet){
        int total = calcTotal(bills);
        System.out.println("This is total of bill: " + total);
        if(payMoney(total, wallet) == true) System.out.println("You can buy it");
        else System.out.println("You cannot buy it");
    }

    public static void main(String[] args) {
        int[] bills = inputBills();
        int wallet = inputWallet();
        
        printTotalAndResult(bills, wallet);
    }
    
}
