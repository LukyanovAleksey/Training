package Lukyanov;

import Lukyanov.Exceptions.MapperHumanException;
import Lukyanov.Exceptions.AddressMapperException;
import Lukyanov.Human.Human;
import Lukyanov.Human.HumanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Random;

public class MapperHuman implements Mapper<Human, HumanDTO> {
    private Logger log = LoggerFactory.getLogger(MapperHuman.class);

    @Override
    public void toDto(Human human, HumanDTO humanDTO) {
        try {
            if (human == null) throw new MapperHumanException("Trying to map null value of human");
            if (humanDTO == null) throw new MapperHumanException("Trying to map null value of humanDTO");
            humanDTO.setId(human.getId());
            humanDTO.setName(human.getName());
            humanDTO.setBirthDate(human.getBirthDate());
            humanDTO.setAddress(humanDTO.new AddressDTO());
            addressDtoMapper(human.getAddress(), humanDTO.getAddress());
            log.info("Human " + human + " was successfully mapped to HumanDTO " + humanDTO);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void toEntity(Human human, HumanDTO humanDTO) {
        try {
            if (human == null) throw new MapperHumanException("Trying to map null value of human");
            if (humanDTO == null) throw new MapperHumanException("Trying to map null value of humanDTO");
            human.setId(humanDTO.getId());
            human.setName(humanDTO.getName());
            human.setBirthDate(humanDTO.getBirthDate());
            human.setAddress(human.new Address());
            addressMapper(human.getAddress(), humanDTO.getAddress());

            Random random = new Random();
            human.setEditedBy(random.nextLong());

            human.setModifiedDate(new Date(System.currentTimeMillis()));
            log.info("HumanDTO " + humanDTO + " was successfully mapped to Human " + human);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addressMapper(Human.Address address, HumanDTO.AddressDTO addressDTO) throws AddressMapperException {
        if (address == null) throw new AddressMapperException("Failed to convert addressDTO to address. Address is null");
        if (addressDTO == null) throw new AddressMapperException("Failed to convert addressDTO to address. AddressDTO is null");
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHome(addressDTO.getHome());
        address.setFlat(addressDTO.getFlat());
        address.setIndex(addressDTO.getIndex());

        Random random = new Random();
        address.setEditedBy(random.nextLong());
        address.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
        log.info("Address " + address + " was successfully mapped to AddressDTO " + addressDTO);
    }

    private void addressDtoMapper(Human.Address address, HumanDTO.AddressDTO addressDTO) throws AddressMapperException {
        if (address == null) throw new AddressMapperException("Failed to convert address to addressDTO. Address is null");
        if (addressDTO == null) throw new AddressMapperException("Failed to convert address to addressDTO. AddressDTO is null");
        addressDTO.setCountry(address.getCountry());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setHome(address.getHome());
        addressDTO.setFlat(address.getFlat());
        addressDTO.setIndex(address.getIndex());
        log.info("AddressDTO " + addressDTO + " was successfully mapped to Address " + address);
    }
}
