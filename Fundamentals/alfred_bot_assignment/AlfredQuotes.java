import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        String helloName = String.format("Hello, %s. Lovely to see you.", name);
        return helloName;
    }
    
    public String dateAnnouncement() {
        // YOUR CODE HERE
        Date date = new Date();
        String nowDate = String.format("It is currently %s.", date);
        return nowDate;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        int alexis = conversation.indexOf("Alexis"); 
        int alfred = conversation.indexOf("Alfred"); 
        if (alexis != -1){
            return "Right away";
        } else if (alfred != -1){
            return "As you wish";
        } else {
            return "Right. And with that I shall retire";
        }
        
    }
    
	// NINJA BONUS
	// See the specs to overload the guestGreeting method
        // SENSEI BONUS
        // Write your own AlfredQuote method using any of the String methods you have learned!

    public String guestGreeting(String name , String dayPeriod){
        // YOUR CODE HERE
        String GuestGreetingDayPeriod = String.format("Good %s, %s. Lovely to see you.", dayPeriod,name );
        return GuestGreetingDayPeriod;
    }
}

