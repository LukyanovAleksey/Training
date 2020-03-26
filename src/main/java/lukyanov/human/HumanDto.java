package lukyanov.human;

import lombok.Data;

import java.util.Date;

@Data
public class HumanDto {
    private long id;
    private String name;
    private AddressDto address;
    private Date birthDate;

    @Override
    public String toString() {
        return "human{" +
                "id: " + id +
                ", name: " + name +
                ", address: " + address.toString() +
                ", birthDate: " + birthDate + "}";
    }

    @Data
    public class AddressDto {
        private String country;
        private String city;
        private String street;
        private String home;
        private String flat;
        private int index;

        @Override
        public String toString() {
            return "{Country: " + country +
                    ", City: " + city +
                    ", Street: " + street +
                    ", Home: " + home +
                    ", Flat: " + flat +
                    ", Index: " + index + "}";
        }
    }
}
