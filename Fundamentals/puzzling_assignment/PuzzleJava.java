import java.util.Random;
import java.util.ArrayList;

public class PuzzleJava {
    public ArrayList<Integer> getTenRolls() {
        Random rand = new Random();
        ArrayList<Integer> rollsArray = new ArrayList<Integer>();

        for(int i=0; i<10; i++) { 
            rollsArray.add(rand.nextInt(20));
        }
        return rollsArray;
    }

    public char getRandomLetter() {
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for(Character i = 'A'; i <= 'Z'; i++) {
            alphabet.add(i);
        }
        Random rand = new Random();
        int randomNumber = rand.nextInt(26);
        return alphabet.get(randomNumber);
    }

    public String generatePassword() {
        String password="";
        for(int i=0; i<=8; i++) {
            password = password + getRandomLetter();
        }
        return password;
    }

    public ArrayList<String> getNewPasswordSet(int count) {
        ArrayList<String> passwordsSet = new ArrayList<String>();
        for(int i=0; i <= count; i++) {
            passwordsSet.add(generatePassword());
        }
        return passwordsSet;
    }
}