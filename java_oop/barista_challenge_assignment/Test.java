public class Test {
    public static void main(String[] args) {
        Order order1 = new Order();
        Order order2 = new Order();

        Order order3 = new Order("ALi");
        Order order4 = new Order("Mahm");
        Order order5 = new Order("kamal");

        Item item1 = new Item("mocca", 3.8);
        Item item2 = new Item("capi", 1.2);
        Item item3 = new Item("kola", 6.3);
        Item item4 = new Item("jjjj", 2.4);

        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item2);
        order2.addItem(item3);

        order3.addItem(item3);
        order3.addItem(item4);

        order4.addItem(item1);
        order4.addItem(item4);

        order1.setOrderIsReady(true);
        order3.setOrderIsReady(true);

        order1.getStatusMessage();
        order2.getStatusMessage();
        order3.getStatusMessage();
        order4.getStatusMessage();

        System.out.println(order1.getOrderTotal());
        System.out.println(order2.getOrderTotal());
        System.out.println(order3.getOrderTotal());
        System.out.println(order4.getOrderTotal());

        System.out.println("The Tooooooooooooooooooootallss:");

        order1.display();
        order2.display();
        order3.display();
        order4.display();
    }
}