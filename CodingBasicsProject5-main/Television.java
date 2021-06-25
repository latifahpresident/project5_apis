public class Television extends ServiceCommunicator {
   private static  String serviceURL = "http://api.tvmaze.com/singlesearch/shows?q=";
    private static String tvShow;

    public Television(String serviceURL, String tvShow) {
        super(serviceURL + tvShow);
        this.serviceURL = serviceURL;
        this.tvShow = tvShow;
    }

    //TODO: COME UP WITH METHOD THAT TAKES USER INPUT

    public static void main(String[] argv) {
        System.out.println(new ServiceCommunicator(serviceURL + "supernatural").get());

    }
}
