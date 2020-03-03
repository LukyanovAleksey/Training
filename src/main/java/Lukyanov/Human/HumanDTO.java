package Lukyanov.Human;

import lombok.Data;

@Data
public class HumanDTO {
    private long id;
    private String name;
    private AddressDTO address;
    private String birthDate;

    @Data
    public class AddressDTO {
        private String country;
        private String city;
        private String street;
        private String home;
        private String flat;
        private int index;
    }
}
