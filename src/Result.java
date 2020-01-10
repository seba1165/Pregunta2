/**
 *
 * @author Sebastian Calderon
 */
//Clase resultado. Permite guardar las instancias de los seguros contratados.
public class Result {
    //Variables dadas por la API de contratados
    String insuranceId;
    String clientRut;
    String comments;
    String status;
    
    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public String getClientRut() {
        return clientRut;
    }

    public void setClientRut(String clienteRut) {
        this.clientRut = clienteRut;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    //Muestra el contratado
    @Override
    public String toString(){
        return ("insuranceId: "+getInsuranceId()+"\n"+"clientRut: "+getClientRut()
                    +"\n"+"comments: "+getComments()
                    +"\n"+"status: "+getStatus()
                    +"\n"+"------------------------\n");
    }
}
