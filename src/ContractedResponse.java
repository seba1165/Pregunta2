/**
 *
 * @author Sebastian Calderon
 */

//Clase que permite registrar la respuesta completa de la API de seguros contratados
public class ContractedResponse {
    //Contiene la fecha y la lista de los contratados
    Contracted contracted;

    public Contracted getContracted() {
        return contracted;
    }

    public void setContracted(Contracted contracted) {
        this.contracted = contracted;
    }
    
    @Override
    public String toString(){
        return contracted.toString();
    }

}
