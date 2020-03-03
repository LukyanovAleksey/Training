package Human;

import Human.Address.Address;
import lombok.Data;

@Data
public class Human {
    private int id;
    private String name;
    private Address address;
    private String birthDate;
    private String editedBy;
}
