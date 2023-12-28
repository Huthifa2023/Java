public class Test {
    public static void main(String[] args) {

        CoffeeKiosk kiosk = new CoffeeKiosk();
        
        kiosk.addMenuItem("Mocha" , 4.75);
        kiosk.addMenuItem("Latte" , 2.35);
        kiosk.addMenuItem("MilkShake" , 8.5);
        kiosk.addMenuItem("XL" , 2.6);

        // kiosk.displayMenu();

    kiosk.newOrder();


    }
}