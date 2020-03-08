package Lukyanov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {
    private String fio;
    private int age;
    private Address address;

    @Data
    @AllArgsConstructor
    public class Address {
        private String city;
        private String street;
        private String home;
        private int flat;

        @Override
        public String toString() {
            return "{"+city+", "+street+", "+home+", "+flat+"}";
        }
    }

    @Override
    public String toString() {
        return "{"+fio+", "+age+", "+address.toString()+"}";
    }
}
