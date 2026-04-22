package controller;

import Manager.Manage;
import java.util.ArrayList;
import java.util.HashMap;
import model.Fruit;
import model.Order;

public class FruitShop {
    public static void main(String[] args) {
        ArrayList<Fruit> listFruit = new ArrayList<>();
        listFruit.add(new Fruit("1", "Coconut", 10, 5, "Vietnam" ));
        listFruit.add(new Fruit("2", "Melon", 20, 5, "Vietnam" ));
        listFruit.add(new Fruit("3", "Banana", 4, 20, "Vietnam" ));
        HashMap<String, ArrayList<Order>> table = new HashMap<>();
        while (true) {
            Manage.menu();
            int choice = Validation.checkInputIntLimit(1, 4);
            switch (choice) {
                case 1:
                    Manage.createFruit(listFruit);
                    break;
                case 2:
                    Manage.viewOrder(table);
                    break;
                case 3:
                    Manage.shopping(listFruit, table);
                    break;
                case 4:
                    return;
            }
        }
    }
    
}
