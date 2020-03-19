package Lukyanov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Plant {
    private String common;
    private String botanical;
    private String zone;
    private String light;
    private String price;
    private String availability;
}