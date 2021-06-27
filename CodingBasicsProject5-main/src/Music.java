import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

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

    public void search() throws IOException {
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        String res = new ServiceCommunicator(serviceURL + songTitle + "&limit=" + query).get();
        Object json = mapper.readValue(res, Object.class); // bind json as an Object
        String indented = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(json); // pretty print it
        System.out.println(indented);

//        System.out.println(new ServiceCommunicator( serviceURL+ songTitle + "&limit=" + query).get());
    }

    public void run(String message) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String userInput = input.nextLine();
        String replaceString = userInput.replaceAll("\\s", "-");
        Music newSearch = new Music(replaceString, "1");
        newSearch.search();
    }

    public void setSongName(String title) {
          this.songTitle = title;
    }

    public void getField(String title, String fieldName) throws IOException {
         setSongName(title);
        String res = new ServiceCommunicator(serviceURL + songTitle + "&limit=1").get();

        JsonNode node = new ObjectMapper().readValue(res, JsonNode.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode content =  node.get(fieldName);
        String prettyPrint = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(content.get(0).get("artistName"));
        System.out.println(fieldName + ": " + prettyPrint);
    }

    public static void main(String[] argv) throws IOException {

        Music runSearch = new Music();
        runSearch.getField("happy", "results");
//        runSearch.run(" Enter a song: \n");
    }
}
