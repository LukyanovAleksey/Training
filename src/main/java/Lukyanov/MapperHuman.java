package Lukyanov;

import Lukyanov.Human.Human;
import Lukyanov.Human.HumanDTO;

import java.util.Date;
import java.util.Random;

public class MapperHuman implements Mapper<Human, HumanDTO> {
    @Override
    public void toDto(Human human, HumanDTO humanDTO) {
        humanDTO.setId(human.getId());
        humanDTO.setName(human.getName());
        humanDTO.setBirthDate(human.getBirthDate());
        addressDtoMapper(human.getAddress(), humanDTO.getAddress());
    }

    @Override
    public void toEntity(Human human, HumanDTO humanDTO) {


        human.setId(humanDTO.getId());
        human.setName(humanDTO.getName());
        human.setBirthDate(humanDTO.getBirthDate());
        addressMapper(human.getAddress(), humanDTO.getAddress());

        Random random = new Random();
        human.setEditedBy(random.nextLong());

        human.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
    }

    public void addressMapper(Human.Address address, HumanDTO.AddressDTO addressDTO) {
        address.setCountry(addressDTO.getCountry());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setHome(addressDTO.getHome());
        address.setFlat(addressDTO.getFlat());
        address.setIndex(addressDTO.getIndex());

        Random random = new Random();
        address.setEditedBy(random.nextLong());
        address.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
    }

    public void addressDtoMapper(Human.Address address, HumanDTO.AddressDTO addressDTO) {
        addressDTO.setCountry(address.getCountry());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setHome(address.getHome());
        addressDTO.setFlat(address.getFlat());
        addressDTO.setIndex(address.getIndex());
    }
}
