package Lukyanov.Human;

import lombok.Data;

import java.util.Date;

@Data
public class HumanDTO {
    private long id;
    private String name;
    private AddressDTO address;
    private Date birthDate;

    @Override
    public String toString(){
        return "Human{" +
                "id: " + id +
                ", name: " + name +
                ", birthDate: " + birthDate + "}";
    }

    @Data
    public class AddressDTO {
        private String country;
        private String city;
        private String street;
        private String home;
        private String flat;
        private int index;

        @Override
        public String toString() {
            return "Address: " +
                    "{Country: " + country +
                    ", City: " + city +
                    ", Street: " + street +
                    ", Home: " + home +
                    ", Flat: " + flat +
                    ", Index: " + index +"}";
        }
    }
}
