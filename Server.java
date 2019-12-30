import java.io.*;
import java.net.InetSocketAddress;
import java.net.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.*;
public class Server {
     private static final String USER_AGENT = "Mozilla/5.0";
     public static void StartServer(String params) throws Exception{

    HttpURLConnection urlConn = null;
    BufferedReader in;

    try{
      System.out.println("Trying connection");
      URL url = new URL("http://192.168.1.8:8000/api");
      urlConn = (HttpURLConnection)url.openConnection();
      urlConn.setRequestMethod("POST");
      urlConn.setRequestProperty("User-Agent", USER_AGENT);
      urlConn.setRequestProperty("Accept-Language", "en US,en;q=0.5");
      String urlParameters = params;
      
      urlConn.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(urlConn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
	wr.close();

	int responseCode = urlConn.getResponseCode();
	System.out.println("\nSending 'POST' request to URL : " + url);
	System.out.println("Post parameters : " + urlParameters);
	System.out.println("Response Code : " + responseCode);

	 in = new BufferedReader( new InputStreamReader(urlConn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());
      
     
    }catch(MalformedURLException e){
  
    }catch(IOException e){
   
    }catch(Exception e){
      System.out.println(e.getMessage());
      System.out.println(e.getStackTrace());
    }

}


}
