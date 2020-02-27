package Human;

import Human.Address.Address;
import lombok.Data;

@Data
public class HumanDTO {
    private int id;
    private String name;
    private Address address;
    private String birthDate;
}
