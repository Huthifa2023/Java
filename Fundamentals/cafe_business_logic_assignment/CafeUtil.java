import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int sum = 0;
        int numWeeks = 3;
        for(int i=1; i <= numWeeks; i++) {
            sum += i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices) {
        double total = 0;
        for(double i : prices) {
            total += i;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for(int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + "  " + menuItems.get(i));
        }
    }


    public void addCustomer(ArrayList<String> customers) {

        System.out.println("Please enter your name:");
        String username = System.console().readLine();
        System.out.println("hello" +" "+ username);
        int peopleAhead = customers.size();
        customers.add(username);
        System.out.println(String.format("There are %d people in front of you", peopleAhead));
        System.out.println(customers);
    }
}