import java.util.ArrayList;

public class Order {
    private String name;
    // private double total;
    private boolean ready;
    private ArrayList<Item> items;

    public Order() {            //default constructor
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }
    public Order(String name) {     //overload constructor, added specific name
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    //setters
    public void setOrderName(String name) {
        this.name = name;
    }
    public void setOrderIsReady(boolean ready) {
        this.ready = ready;
    }

    //getters
    public String getOrderName(){
        return this.name;
    }
    public ArrayList<Item> getOrderItems(){
        return this.items;
    }

    //methods
    public void addItem(Item item){
        this.items.add(item);
    }
    public void getStatusMessage(){
        System.out.println(ready? "Your order is ready" : "Thank you for waiting. Your order will be ready soon.");
    }
    public double getOrderTotal() {
        double total = 0.0;
        for(Item i : this.items){
            total += i.getItemPrice();
        }
        return total;
    }
    public void display(){
        System.out.println("customer Name:" + this.name);
        for(Item i : this.items){
            System.out.println(i.getItemName() +"-"+ i.getItemPrice());
        }
        System.out.println("Total: " + this.getOrderTotal());
        System.out.println("***************************************************");
    }
}