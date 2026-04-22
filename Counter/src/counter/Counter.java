package counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Counter {
    public static HashMap<Character, Integer> charCounter = new HashMap<>();
    public static HashMap<String, Integer> wordCounter = new HashMap<>();
    public static int[] charCounter2 = new int[256];
    public static ArrayList<String> wordCounter2 = new ArrayList<>();
    public static ArrayList<Integer> wordCount = new ArrayList<>();
    
    public static void main(String[] args) {
        String content = getUserInput();
        analyze(content);
        display();
        System.out.println("");
        System.out.println("");
        analyze2(content);
        display2();
    }
    
    public static String getUserInput(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter your content: ");
            String content = sc.nextLine().trim();
            if(content.isEmpty()){
                System.out.println("Not Empty");
                System.out.println("Try Again");
            }
            else return content;
        }while(true);
    }
    
    public static void display(){
        System.out.println(wordCounter.toString());
        System.out.println(charCounter.toString());
    }
    
    public static void display2(){
        for(int i = 0; i < wordCounter2.size(); i++){
            if(i == 0) System.out.print("{");
            System.out.print(wordCounter2.get(i)+"="+wordCount.get(i));
            if(i + 1 != wordCounter2.size()) System.out.print(", ");
            else{
                System.out.println("}");
            }
        }
        
        System.out.print("{");
        boolean first = true;
        for(int i = 0 ; i < charCounter2.length; i++){
            if(charCounter2[i] > 0){
                if(first == false){
                    System.out.print(", ");
                }
                System.out.print((char) i + "=" + charCounter2[i]);
                first = false;
            }
        }
        System.out.println("}");
    }
    
    public static void analyze(String content){
        for(char ch : content.toCharArray()){
            if(Character.isSpaceChar(ch)) continue;
            incrementCount(ch, null);
        }
        
        StringTokenizer tokenizer = new StringTokenizer(content);
        while(tokenizer.hasMoreTokens()){
            String token = tokenizer.nextToken();
            incrementCount(null, token);
        }
    }
    
    public static void analyze2(String content){
        for(char ch : content.toCharArray()){
            if(Character.isSpaceChar(ch)) continue;
            charCounter2[ch]++;
        }
        
        StringTokenizer tokenizer = new StringTokenizer(content);
        while(tokenizer.hasMoreTokens()){
            boolean flag = false;
            String token = tokenizer.nextToken();
            for(int i = 0; i < wordCounter2.size(); i++){
                if(wordCounter2.get(i).equals(token)){
                    wordCount.set(i, wordCount.get(i) + 1);
                    flag = true;
                    break;
                }
                
            }
            if(flag == false){
                    wordCounter2.add(token);
                    wordCount.add(1);
                }
        }
    }
    
    public static void incrementCount(Character ch, String token){
        if(ch != null){
            if(!charCounter.containsKey(ch)){
                charCounter.put(ch, 1);
            }
            else{
                charCounter.put(ch, charCounter.get(ch) + 1);
            }
        }
        
        if(token != null){
            if(!wordCounter.containsValue(token)){
                wordCounter.put(token, 1);
            }
            else{
                wordCounter.put(token, wordCounter.get(token) + 1);
            }
        }
    }
}

