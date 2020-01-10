import java.util.Objects;

/**
 *
 * @author Sebastian Calderon
 */

//Clase Seguro 
public class Insurance {
    //Variables registradas desde la API
    String id;
    String name;
    String codeType;
    String type;
    String initDate;
    String endDate;
    //Nueva variable para contar la cantidad de veces que se contrató el seguro 
    int count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    //Para mostrar el seguro en pantalla y cuantas veces fue contratado
    @Override
    public String toString(){
        return ("id: "+getId()+"\n"+"name: "+getName()
                    +"\n"+"codetype: "+getCodeType()
                    +"\n"+"type: "+getType()
                    +"\n"+"initDate: "+getInitDate()
                    +"\n"+"endDate: "+getEndDate()
                    +"\n"+"count: "+getCount()
                    +"\n"+"------------------------\n");
    }
    
    //Métodos sobrescritos para poder buscar un seguro según un id dado
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || getClass()!= o.getClass())return false;
        Insurance insurance = (Insurance) o;
        return insurance.getId().equals(id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
