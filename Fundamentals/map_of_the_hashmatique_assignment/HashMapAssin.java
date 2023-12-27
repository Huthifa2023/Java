import java.util.HashMap;

public class HashMapAssin {
    public HashMap<String,String> songs(){
    HashMap<String, String> trackList = new HashMap<String, String>();
    trackList.put("dump", "When we go down When kingdom come Don't look at me, don't look at me I'm just too dumb");
    trackList.put("good", "Let me tell you what I wish I'd known when I was young and dreamed of glory");
    trackList.put("Delivery","Dont worry where we end up. Ending-ups not real. The life we build, we never stop creating");
    trackList.put("peace", "Our coming of age has come and gone");
    return trackList;
    }

    public String getSong(String name) {
        String theSong = songs().get(name);
        return theSong;
    }


    public HashMap<String,String> allSongs() {
        return songs();
    }

}