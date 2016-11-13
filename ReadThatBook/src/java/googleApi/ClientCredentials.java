package googleApi;


public class ClientCredentials {

  /** Value of the "API key" shown under "Simple API Access". */
  static final String API_KEY = "AIzaSyAQtL-T66XXXVYhbSDXO5v-Q6mJjd5VnhU";
     // + ClientCredentials.class;
//"Enter API Key from https://code.google.com/apis/console/?api=books into API_KEY in "
  static void errorIfNotSpecified() {
    if (API_KEY.startsWith("Enter ")) {
      System.err.println(API_KEY);
      System.exit(1);
    }
  }
}
