public class Item {
    private String name;
    private double price;
    private int index;


    public Item(String name, double price) {    //constructor to set price and name at instantiation
        this.name = name;
        this.price = price;
    }
        //setters
    public void setItemIndex(int index) {
        this.index = index;
    }
    public void setItemName(String name) {
        this.name = name;
    }
    public void setItemPrice(double price) {
        this.price = price;
    }

    //getters
    public int getItemIndex() {
        return this.index;
    }
    public String getItemName(){
        return this.name;
    }
    public double getItemPrice(){
        return this.price;
    }
}