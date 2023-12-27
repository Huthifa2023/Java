import java.util.ArrayList;
import java.util.Random;
public class PuzzleTest {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();
        ArrayList<Integer> randomRolls = appTest.getTenRolls();
        System.out.println("Random 10 numbers between 0 and 20:");
        System.out.println(randomRolls);

        // getRandomLetter
        Character letter = appTest.getRandomLetter();
        System.out.println("Random alphapet character:");
        System.out.println(letter);


        // generatePassword
        String password = appTest.generatePassword();
        System.out.println("Random password:");
        System.out.println(password);
    

    // getNewPasswordSet
    int numberOfPasswords = 5;
    ArrayList<String> passwordsCollection = appTest.getNewPasswordSet(numberOfPasswords);
    System.out.println("Random passwords set:");
    System.out.println(passwordsCollection);

    }
}