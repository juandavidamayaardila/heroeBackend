package co.com.sofka.model.heroe;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Heroe {
    private String id;
    private String name;


    public Heroe(){}

    public Heroe(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
