import java.util.HashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {

        HashMapAssin appTest = new HashMapAssin();

        // get song using title
        String theSong = appTest.getSong("good");
        System.out.print(theSong);


        // get all songs
        HashMap<String, String> allSongs = new HashMap<String, String>();
        allSongs = appTest.allSongs();
        Set<String> keys = allSongs.keySet();
        for(String i : keys) {
            System.out.println(i + " : " + allSongs.get(i)+ "\n");
        }
    }
}