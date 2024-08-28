package ci.atos.monetab.services.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String city;
    private String country;
}
