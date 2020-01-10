
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Sebastian Calderon
 */
public class Pregunta2 {

    public static void main(String[] args) {
        //Variables necesarias para consultar API
        URL url;
        HttpURLConnection conn;
        InputStreamReader in;
        BufferedReader br;
        String output;
        try {
            
            //Primero se consultan todos los seguros
            url = new URL("https://hack.kunderlabs.com/exam/insurance/api/insurance");//your url i.e fetch data from .
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            in = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(in);
            output = br.readLine();
            //System.out.println(output);
            conn.disconnect();

            //Se mapea el JSON obtenido a un objeto de la clase InsuranceResponse
            InsuranceResponse insuranceResponse = new Gson().fromJson(output, InsuranceResponse.class);

            //Luego se consultan todas las contrataciones de las ultimas 24 hrs
            url = new URL("https://hack.kunderlabs.com/exam/insurance/api/insurance/contracted/today");
            conn = (HttpURLConnection) url.openConnection();

            in = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(in);
            output = br.readLine();
            //System.out.println(output);
            conn.disconnect();

            //Se mapea el JSON obtenido a un objeto de la clase contractedResponse
            ContractedResponse contractedResponse = new Gson().fromJson(output, ContractedResponse.class);
            
            //Por cada seguro contratado, se aumenta en 1 el contador del seguro, para obtener el total de cada uno.
            contractedResponse.getContracted().results.stream().map((result) -> {
                Insurance insurance = new Insurance();
                insurance.setId(result.getInsuranceId());
                return insurance;
            }).forEachOrdered((insurance) -> {
                int index = insuranceResponse.insurance.indexOf(insurance);
                int count = insuranceResponse.insurance.get(index).getCount();
                insuranceResponse.insurance.get(index).setCount(count+1);
            });
            
            //Luego de tener todos los contadores, se ordena la lista de seguros
            insuranceResponse.sort(0, insuranceResponse.getInsurance().size()-1);
            System.out.println("-----------------------");
            //Se muestra
            insuranceResponse.getMostHiredInsuranceLast24Hrs();
        
        } catch (IOException | RuntimeException e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
    
}
