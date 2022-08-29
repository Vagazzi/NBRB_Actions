import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.SQLException;


public class main extends Config{
    public static void main(String[] args) throws SQLException, ClassNotFoundException, JsonProcessingException {

       DatabaseHandler dh = new DatabaseHandler();
        
        String query = "https://www.nbrb.by/api/exrates/rates/431";

        HttpRequestHandler rq = new HttpRequestHandler(query);

        ObjectMapper objectMapper = new ObjectMapper();

        String res = rq.executeHttpRequest(query, "GET", 1000, 1000).toString();

        Currency currency = objectMapper.readValue(res,Currency.class);

        for (int i = 0; i <1;i++) {
            dh.writeData( currency.getCurrencyDate(), currency.getCurrencyScale().toString(), currency.getCurrencyOfficialRate().toString());
        }


        //dh.deleteData();


    }

}
