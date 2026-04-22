package Manager;
import controller.Validation;
import java.util.ArrayList;
import java.util.HashMap;
import model.Fruit;
import model.Order;

public class Manage {
    public static void menu() {
        System.out.println("1. Create Fruit");
        System.out.println("2. View orders");
        System.out.println("3. Shopping (for buyer)");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void createFruit(ArrayList<Fruit> listFruit) {
        do{
            System.out.printf("Enter fruit id: ");
            String id = Validation.checkInputString();
            if (Validation.checkIdExist(listFruit, id)) {
                System.out.println("This id has exists fruit! TRY ANOTHER ID");
                return;
            }
            System.out.printf("Enter fruit name: ");
            String name = Validation.checkInputString();
            System.out.printf("Enter price: ");
            double price = Validation.checkInputDouble();
            System.out.printf("Enter quantity: ");
            int quantity = Validation.checkInputInt();
            System.out.printf("Enter origin: ");
            String origin = Validation.checkInputString();
            listFruit.add(new Fruit(id, name, price, quantity, origin));
            if (!Validation.checkInputYN()) {
                return;
            }
        } while(true);
    }

    public static void viewOrder(HashMap<String, ArrayList<Order>> table) {
        if(table.isEmpty()){
            System.out.println("Nothing here!");
            return;
        }
        for (String name : table.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Order> listOrder = table.get(name);
            displayListOrder(listOrder);
        }
    }

    public static void shopping(ArrayList<Fruit> listFruit, HashMap<String, ArrayList<Order>> table) {
        if (listFruit.isEmpty()) {
            System.out.println("No have item.");
            return;
        }
        ArrayList<Order> listOrder = new ArrayList<>();
        do {
            Fruit fruit = getFruitByListFruit(listFruit);
            System.out.println("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if(fruit.getQuantity() == 0) listFruit.remove(fruit);
            if (Validation.checkItemExist(listOrder, fruit.getFruitId())) {
                updateOrder(listOrder, fruit.getFruitId(), quantity);
            } else {
                listOrder.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        } while(true);
        displayListOrder(listOrder);
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        if (table.containsKey(name)) {
            ArrayList<Order> existingOrders = table.get(name);
            for (Order newOrder : listOrder) {
                boolean found = false;
                for (Order existingOrder : existingOrders) {
                    if (existingOrder.getFruitId() == newOrder.getFruitId()) {
                        existingOrder.setQuantity(existingOrder.getQuantity() + newOrder.getQuantity());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    existingOrders.add(newOrder);
                }
            }
        } else {
            table.put(name, listOrder);
        }
        System.out.println("Add successfull");
    }
    
        public static Fruit getFruitByListFruit(ArrayList<Fruit> listFruit) {
        System.out.println("List Fruit found: ");
        int count = 1;
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
        for (Fruit fruit : listFruit) {
            System.out.printf("%-10d%-20s%-20s%-15.0f$\n", count,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            count++;
        }
        System.out.print("Enter number of item: ");
        int choice = Validation.checkInputIntLimit(1, listFruit.size());
        return listFruit.get(choice - 1);
    }

    public static void displayListOrder(ArrayList<Order> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Order order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    public static void updateOrder(ArrayList<Order> listOrder, String id, int quantity) {
        for (Order order : listOrder) {
            if (id.equalsIgnoreCase(order.getFruitId())) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
}