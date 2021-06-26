import java.util.Scanner;


public class Television extends ServiceCommunicator {
   private static  String serviceURL = "http://api.tvmaze.com/singlesearch/shows?q=";
   String tvShow;

    public Television(String tvShow) {
        super(serviceURL);
        this.tvShow = tvShow;
    }

    public Television() {
        super(serviceURL);
    }

    //TODO: COME UP WITH METHOD THAT TAKES USER INPUT

    public void search() {

        System.out.println(new ServiceCommunicator( serviceURL + tvShow).get());
    }

    public void run(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String userInput = input.nextLine();
        Television newSearch = new Television(userInput);
        newSearch.search();
    }

    public static void main(String[] argv) {
        Television show = new Television();
        show.run(" Enter Tv show: \n");
    }
}
