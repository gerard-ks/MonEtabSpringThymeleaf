package ci.atos.monetab.services.mapper;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.services.dto.AddressDTO;

public final class AddressMapper {

    private AddressMapper() {
    }

    public static AddressDTO toDto(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        addressDTO.setCountry(address.getCountry());
        return addressDTO;
    }

    public static Address toEntity(AddressDTO addressDTO) {
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        return address;
    }
}
