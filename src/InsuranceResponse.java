import java.util.List;

/**
 *
 * @author Sebastian Calderon
 */
//Clase que permite registrar la respuesta completa de la API de seguros existentes
public class InsuranceResponse {
    //Lista de todos los seguros
    List<Insurance> insurance;

    public List<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(List<Insurance> insurance) {
        this.insurance = insurance;
    }
    
    @Override
    public String toString(){
        return insurance.toString();
    }

    //Para ordenar con quicksort luego de tener todos los seguros y cuantas veces se contrató cada uno
    public void sort(int low, int high) {
        if (low<high) {
            int pi = partition(low,high);
            
            sort(low, pi-1); 
            sort(pi+1, high); 
        }
    }

    private int partition(int low, int high) {
        int pivot = insurance.get(high).getCount();
        int i = (low-1);
        for (int j=low; j<high; j++){
            //Si el elemento actual tiene menos contratos que el pivot 
            if (insurance.get(j).getCount() < pivot){ 
                i++; 
                //Se cambia el seguro[i] y el seguro[j]
                Insurance temp = insurance.get(i);
                insurance.set(i, insurance.get(j));
                insurance.set(j, temp);
            } 
        } 
        //Se cambiar el seguro[i+1] y el seguro[high] (o pivot)
        Insurance temp = insurance.get(i+1);
        insurance.set(i+1, insurance.get(high));
        insurance.set(high, temp);  
        return i+1; 
    }

    //Muestra los 5 seguros mas contratados
    public void getMostHiredInsuranceLast24Hrs() {
        for (int i = 0; i < 5; i++) {
            System.out.println(insurance.get(insurance.size()-1-i));
        }
    }

    
}
