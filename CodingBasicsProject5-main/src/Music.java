import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Music extends ServiceCommunicator {
     static String songTitle;
     static String serviceURL = "https://itunes.apple.com/search?term=";
     static String query;

     public Music(String songTitle, String query) {
        super(serviceURL);
        this.songTitle = songTitle;
        this.query = query;
    }

  public Music(){
         super(serviceURL);
  }

    public void search() {


        System.out.println(new ServiceCommunicator( serviceURL+ songTitle + "&limit=" + query).get());
    }

    public void run(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String userInput = input.nextLine();
        String replaceString = userInput.replaceAll("\\s", "-");
        Music newSearch = new Music(replaceString, "2");
        newSearch.search();
    }

    public static void main(String[] argv) {
        Music runSearch = new Music();
        runSearch.run(" Enter a song: \n");
    }
}
