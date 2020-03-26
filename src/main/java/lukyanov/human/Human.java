package lukyanov.human;

import lombok.Data;

import java.util.Date;

@Data
public class Human {

    //fields for DTO
    private long id;
    private String name;
    private Address address;
    private Date birthDate;

    private long editedBy;
    private Date modifiedDate;

    @Data
    public class Address {
        //fields for Dto
        private String country;
        private String city;
        private String street;
        private String home;
        private String flat;
        private int index;

        private long editedBy;
        private Date modifiedDate;

        @Override
        public String toString() {
            return "Address: " +
                    "{Country: " + country +
                    ", City: " + city +
                    ", Street: " + street +
                    ", Home: " + home +
                    ", Flat: " + flat +
                    ", Index: " + index +
                    ", editedBy: " + editedBy +
                    ", modifiedDate: " + modifiedDate + "}";
        }
    }

    @Override
    public String toString() {
        return "human{" +
                "id: " + id +
                ", name: " + name +
                ", birthDate: " + birthDate +
                ", editedBy: " + editedBy +
                ", modifiedDate: " + modifiedDate + "}";
    }
}
