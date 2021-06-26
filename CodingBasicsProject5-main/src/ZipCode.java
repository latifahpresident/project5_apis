import java.util.Scanner;

public class ZipCode extends ServiceCommunicator {
   static String serviceURL = "http://api.zippopotam.us/us/";
    String zipcode;

    public ZipCode(String zipcode) {
        super(serviceURL);
        this.zipcode = zipcode;
    }

    public ZipCode() {
        super(serviceURL);
    }
    //TODO: COME UP WITH METHOD THAT TAKES USER INPUT

    public void search() {
        System.out.println(new ServiceCommunicator( serviceURL + zipcode).get());
    }

    public void run(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        String userInput = input.nextLine();
        ZipCode newSearch = new ZipCode(userInput);
        newSearch.search();
    }

    public static void main(String[] argv) {
        ZipCode zip = new ZipCode();
        zip.run(" Enter zip code: \n");
    }
}

