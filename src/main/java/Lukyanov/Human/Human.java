package Lukyanov.Human;

import lombok.Data;

@Data
public class Human {
    //fields for DTO
    private long id;
    private String name;
    private Address address;
    private String birthDate;

    private String editedBy;
    private String createdDate;
    private String modifiedDate;

    @Data
    public class Address {
        //fields for DTO
        private String country;
        private String city;
        private String street;
        private String home;
        private String flat;
        private int index;

        private String editedBy;
        private String createdDate;
        private String modifiedDate;
    }
}
