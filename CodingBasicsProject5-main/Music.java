import java.util.Scanner;

public class Music extends ServiceCommunicator {
     static String songTitle;
     static String serviceURL = "https://itunes.apple.com/search?term=";
     static String query;

     public Music(String songTitle, String query) {
        super(serviceURL);
        this.songTitle = songTitle;
        this.query = query;
    }

    public void search() {
        System.out.println(new ServiceCommunicator( serviceURL+ songTitle + "&limit=" + query).get());
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter a song. \n");
        String userInput = input.nextLine();
        String replaceString = userInput.replaceAll("\\s", "-");
        System.out.printf("replace string: %s", replaceString);
        Music newSearch = new Music(replaceString, "1");
        newSearch.search();

    }
}
