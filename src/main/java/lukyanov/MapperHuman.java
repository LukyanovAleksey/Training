package lukyanov;

import lombok.extern.slf4j.Slf4j;
import lukyanov.exceptions.MapperHumanException;
import lukyanov.exceptions.AddressMapperException;
import lukyanov.human.Human;
import lukyanov.human.HumanDto;

import java.util.Date;
import java.util.Random;

@Slf4j
public class MapperHuman implements Mapper<Human, HumanDto> {

    @Override
    public void toDto(Human human, HumanDto humanDto) {
        try {
            if (human == null) throw new MapperHumanException("Trying to map null value of human");
            if (humanDto == null) throw new MapperHumanException("Trying to map null value of humanDTO");
            humanDto.setId(human.getId());
            humanDto.setName(human.getName());
            humanDto.setBirthDate(human.getBirthDate());
            humanDto.setAddress(humanDto.new AddressDto());
            addressDtoMapper(human.getAddress(), humanDto.getAddress());
            log.info("human " + human + " was successfully mapped to HumanDto " + humanDto);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void toEntity(Human human, HumanDto humanDto) {
        try {
            if (human == null) throw new MapperHumanException("Trying to map null value of human");
            if (humanDto == null) throw new MapperHumanException("Trying to map null value of humanDTO");
            human.setId(humanDto.getId());
            human.setName(humanDto.getName());
            human.setBirthDate(humanDto.getBirthDate());
            human.setAddress(human.new Address());
            addressMapper(human.getAddress(), humanDto.getAddress());

            Random random = new Random();
            human.setEditedBy(random.nextLong());

            human.setModifiedDate(new Date(System.currentTimeMillis()));
            log.info("HumanDto " + humanDto + " was successfully mapped to human " + human);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addressMapper(Human.Address address, HumanDto.AddressDto addressDto) throws AddressMapperException {
        if (address == null)
            throw new AddressMapperException("Failed to convert addressDTO to address. Address is null");
        if (addressDto == null)
            throw new AddressMapperException("Failed to convert addressDTO to address. AddressDto is null");
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setHome(addressDto.getHome());
        address.setFlat(addressDto.getFlat());
        address.setIndex(addressDto.getIndex());

        Random random = new Random();
        address.setEditedBy(random.nextLong());
        address.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
        log.info("Address " + address + " was successfully mapped to AddressDto " + addressDto);
    }

    private void addressDtoMapper(Human.Address address, HumanDto.AddressDto addressDto) throws AddressMapperException {
        if (address == null)
            throw new AddressMapperException("Failed to convert address to addressDTO. Address is null");
        if (addressDto == null)
            throw new AddressMapperException("Failed to convert address to addressDTO. AddressDto is null");
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setHome(address.getHome());
        addressDto.setFlat(address.getFlat());
        addressDto.setIndex(address.getIndex());
        log.info("AddressDto " + addressDto + " was successfully mapped to Address " + address);
    }
}
