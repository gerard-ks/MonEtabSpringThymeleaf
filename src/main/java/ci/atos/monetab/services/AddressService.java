package ci.atos.monetab.services;

import ci.atos.monetab.services.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    AddressDTO save(AddressDTO addressDTO);

    List<AddressDTO> getAllAddresses();

    Optional<AddressDTO> getAddressById(Long id);

    AddressDTO updateAddress(AddressDTO addressDTO);
}
