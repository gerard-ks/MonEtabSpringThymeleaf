package ci.atos.monetab.services.Impl;

import ci.atos.monetab.models.Address;
import ci.atos.monetab.repositories.AddressRepository;
import ci.atos.monetab.services.AddressService;
import ci.atos.monetab.services.dto.AddressDTO;
import ci.atos.monetab.services.mapper.AddressMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public AddressDTO save(AddressDTO addressDTO) {
        log.info("Saving address: {}", addressDTO);
        Address address = AddressMapper.toEntity(addressDTO);
        address = addressRepository.save(address);
        return AddressMapper.toDto(address);
    }


    @Override
    public List<AddressDTO> getAllAddresses() {

        List<Address> addresses = addressRepository.findAll();

        return addresses.stream()
                .map(AddressMapper::toDto)
                .toList();
    }

    @Override
    public Optional<AddressDTO> getAddressById(Long id) {
        return addressRepository.findById(id).
                map(AddressMapper::toDto);
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {
        return getAddressById(addressDTO.getId()).map(existingAddress -> {
            existingAddress.setCity(addressDTO.getCity());
            return save(existingAddress);
        }).orElseThrow(() -> new IllegalArgumentException("Address not found"));
    }
}
