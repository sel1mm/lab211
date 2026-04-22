package controller;

import java.util.ArrayList;
import java.util.Scanner;
import model.Fruit;
import model.Order;

public class Validation {
    private static Scanner sc = new Scanner(System.in);

    public static int checkInputIntLimit(int min, int max) {
        do {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    System.out.println("Please input number in rage [" + min + ", " + max + "]");
                    System.out.print("Enter again: ");

                }
                else return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        } while(true);
    }

    public static String checkInputString() {
        do {
            String result = sc.nextLine().trim();
            if (result.isEmpty()) {
                System.out.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                String[] words = result.split("\\s+");
                StringBuilder sb = new StringBuilder();
                for(String word : words){
                    sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1).toLowerCase()).append(" ");
                }
                result = sb.toString().trim();
                return result;
            }
        } while(true);
    }

    public static boolean checkInputYN() {
        do {
            System.out.println("Do you want to continue Y/N: ");
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        } while(true);
    }
    
    public static int checkInputInt() {
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }

    public static double checkInputDouble() {
        while (true) {
            try {
                double result = Double.parseDouble(sc.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }

    public static boolean checkIdExist(ArrayList<Fruit> lf, String id) {
        for (Fruit fruit : lf) {
            if (id.equalsIgnoreCase(fruit.getFruitId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkItemExist(ArrayList<Order> lo, String id) {
        for (Order order : lo) {
            if (id.equalsIgnoreCase(order.getFruitId())) {
                return true;
            }
        }
        return false;
    }
}
