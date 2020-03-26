package lukyanov;

import lukyanov.human.Human;
import lukyanov.human.HumanDto;

import java.util.Date;
import java.util.Random;

public class MapperHuman implements Mapper<Human, HumanDto> {
    @Override
    public void toDto(Human human, HumanDto humanDto) {
        humanDto.setId(human.getId());
        humanDto.setName(human.getName());
        humanDto.setBirthDate(human.getBirthDate());
        humanDto.setAddress(humanDto.new AddressDto());
        addressDtoMapper(human.getAddress(), humanDto.getAddress());
    }

    @Override
    public void toEntity(Human human, HumanDto humanDto) {


        human.setId(humanDto.getId());
        human.setName(humanDto.getName());
        human.setBirthDate(humanDto.getBirthDate());
        human.setAddress(human.new Address());
        addressMapper(human.getAddress(), humanDto.getAddress());

        Random random = new Random();
        human.setEditedBy(random.nextLong());

        human.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
    }

    private void addressMapper(Human.Address address, HumanDto.AddressDto addressDto) {
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHome(addressDto.getHome());
        address.setFlat(addressDto.getFlat());
        address.setIndex(addressDto.getIndex());

        Random random = new Random();
        address.setEditedBy(random.nextLong());
        address.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
    }

    private void addressDtoMapper(Human.Address address, HumanDto.AddressDto addressDto) {
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHome(address.getHome());
        addressDto.setFlat(address.getFlat());
        addressDto.setIndex(address.getIndex());
    }
}
