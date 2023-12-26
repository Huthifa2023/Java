public class FirstJavaProgram{
    public static void main(String[] args){
        String myName = "Coding Dojo";
        double myAge = 100;
        String homeTown = "Burbank";

        System.out.println("My name is " + myName);
        String dd = String.format("I am %.8f years old", myAge);
        System.out.println(dd);
        System.out.println("My hometown is Burbank, CA");

    } 
}