public class ZipCode extends ServiceCommunicator {
   static String serviceURL = "http://api.zippopotam.us/us/";
    String zipcode;

    public ZipCode(String serviceURL, String zipcode) {
        super(serviceURL + zipcode);
        this.serviceURL = serviceURL;
        this.zipcode = zipcode;
    }

    //TODO: COME UP WITH METHOD THAT TAKES USER INPUT


    public static void main(String[] argv) {
        System.out.println(new ServiceCommunicator(serviceURL + "10011").get());

    }
}

