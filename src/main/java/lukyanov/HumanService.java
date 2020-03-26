package lukyanov;

import lukyanov.human.Human;
import lukyanov.human.HumanDto;

import java.util.ArrayList;
import java.util.List;

public class HumanService implements HumanStorage<HumanDto> {
    private HumanStorage<Human> storage = new HumanStorageImpl();
    private Mapper<Human, HumanDto> mapper = new MapperHuman();

    @Override
    public HumanDto getEntity(long id) {
        Human human = storage.getEntity(id);
        HumanDto humanDto = new HumanDto();
        mapper.toDto(human, humanDto);
        System.out.println("Get entity:");
        System.out.println(humanDto.toString());
        return humanDto;
    }

    @Override
    public List<HumanDto> getAllEntities() {
        List<HumanDto> humanDtoList = new ArrayList<>();
        List<Human> humans = storage.getAllEntities();
        System.out.println("Get all entities:");
        for (Human human : humans) {
            HumanDto humanDto = new HumanDto();
            mapper.toDto(human, humanDto);
            humanDtoList.add(humanDto);
            System.out.println(humanDto.toString());
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
