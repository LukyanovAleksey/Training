package lukyanov;

import lombok.extern.slf4j.Slf4j;
import lukyanov.exceptions.HumanServiceException;
import lukyanov.human.Human;
import lukyanov.human.HumanDto;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HumanService implements HumanStorage<HumanDto> {
    private HumanStorage<Human> storage = new HumanStorageImpl();
    private Mapper<Human, HumanDto> mapper = new MapperHuman();

    @Override
    public HumanDto getEntity(long id) throws HumanServiceException {

        if (id < 0) {
            log.error("Id should be positive, requested id: " + id);
            throw new HumanServiceException(this.getClass().toString() + " The entity is not exist");
        }
        Human human = storage.getEntity(id);
        HumanDto humanDto = new HumanDto();
        mapper.toDto(human, humanDto);
        log.info("Get entity: " + humanDto.toString());
        return humanDto;
    }

    @Override
    public List<HumanDto> getAllEntities() {
        List<HumanDto> humanDtoList = new ArrayList<>();
        List<Human> humans = storage.getAllEntities();
        log.info("Get all entities:");
        for (Human human : humans) {
            HumanDto humanDto = new HumanDto();
            mapper.toDto(human, humanDto);
            humanDtoList.add(humanDto);
            log.info(humanDto.toString());
        }
        return humanDtoList;
    }

    @Override
    public void saveEntity(HumanDto humanDto) {
        Human human = new Human();
        mapper.toEntity(human, humanDto);
        storage.saveEntity(human);
    }

    @Override
    public void saveAllEntities(List<HumanDto> list) {
        List<Human> humans = new ArrayList<>();
        for (HumanDto humanDto : list) {
            Human human = new Human();
            mapper.toEntity(human, humanDto);
            humans.add(human);
        }
        storage.saveAllEntities(humans);
    }
}
