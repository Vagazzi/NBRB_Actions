import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestHandler {
    private final String query;

    public HttpRequestHandler(String query) {

        this.query = query;

    }


    public StringBuilder executeHttpRequest (String query, String requestMethod, int connectTimeout, int readTimeout){

        HttpURLConnection connection = null;

        StringBuilder sb = new StringBuilder();

        try{

            connection = (HttpURLConnection) new URL(query).openConnection();
            connection.setRequestMethod(requestMethod);
            connection.setUseCaches(true);
            connection.setConnectTimeout(connectTimeout);
            connection.setReadTimeout(readTimeout);

            connection.connect();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()){
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;

                while ((line = in.readLine()) != null){
                    sb.append(line);
                    sb.append("\n");
                }

                System.out.println(sb);
            } else {
                System.out.println("Connection failed, error " + connection.getResponseCode() + ": " + connection.getResponseMessage());
            }


        }
        catch (Throwable cause){
            cause.printStackTrace();
        }
        finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return sb;
    }
}
