public class Item {
    private String name;
    private double price;


    public Item(String name, double price) {    //constructor to set price and name at instantiation
        this.name = name;
        this.price = price;
    }
        //setters 
    public void setItemName(String name) {
        this.name = name;
    }
    public void setItemPrice(double price) {
        this.price = price;
    }

    //getters
    public String getItemName(){
        return this.name;
    }
    public double getItemPrice(){
        return this.price;
    }
}