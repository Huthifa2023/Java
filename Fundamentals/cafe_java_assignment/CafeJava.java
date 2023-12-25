public class CafeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "your total is $";

        double mochaPrice = 39.5;
        double dripCoffe = 8.4;
        double latte = 3.5;
        double cappuucciono = 10.3;


        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";


        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 =false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
        
        // Cindhuri customer1
        System.out.println(generalGreeting + customer1);
        System.out.println(isReadyOrder1 ? readyMessage : pendingMessage);



        // Noah customer4
        System.out.println(generalGreeting + customer4);
        System.out.println(isReadyOrder4 ? readyMessage +" "+ displayTotalMessage + cappuucciono : pendingMessage);



        // Sam customer2
        System.out.println(generalGreeting + customer2);
        System.out.println(isReadyOrder2 ? readyMessage +" "+ displayTotalMessage + 2*latte : pendingMessage);


        // Jimmy customer3
        System.out.println(generalGreeting + customer3);
        System.out.println(displayTotalMessage + (dripCoffe - latte));
    }
}