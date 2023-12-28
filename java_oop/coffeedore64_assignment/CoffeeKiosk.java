import java.util.ArrayList;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk() {              //consrtuctor initializes items and orders to empty arrays
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    //methods
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        this.menu.add(newItem);
        newItem.setItemIndex(this.menu.indexOf(newItem));
    }

    public void displayMenu() {
        for(Item i : this.menu) {
            System.out.println(i.getItemIndex() +" "+ i.getItemName() +" -- $"+ i.getItemPrice());
        }
    }

    public void newOrder() {
    System.out.println("Please enter customer name for new order:");
    String name = System.console().readLine();
    // Create a new order with the given input string
    Order order = new Order(name);
    // Show the user the menu, so they can choose items to add.
    this.displayMenu();
    // Prompts the user to enter an item number
    System.out.println("Please enter a menu item index or q to quit:");
    String itemNumber = System.console().readLine();
    // Write a while loop to collect all user's order items
    while(!itemNumber.equals("q")) {
        Item orderdItem = this.menu.get(Integer.parseInt(itemNumber));
        order.addItem(orderdItem);
        System.out.println("item orderd succefully,enter a new item index or q to exit!");
        this.displayMenu();
        itemNumber = System.console().readLine();

        // Get the item object from the menu, and add the item to the order
        // Ask them to enter a new item index or q again, and take their input
    }
    order.display();
    // After you have collected their order, print the order details 
    }

}