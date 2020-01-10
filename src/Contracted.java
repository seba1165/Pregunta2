
import java.util.List;

/**
 *
 * @author Sebastian Calderon
 */

//Clase que permite guardar la la fecha y los resultados obtenidos desde la API para los seguros contratados en las ultimas 24HRS
public class Contracted {
    String date;
    //Lista de todos los contratados
    List<Result> results;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
    
    @Override
    public String toString(){
        return (results.toString());
    }
}
