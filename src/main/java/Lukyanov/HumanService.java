package Lukyanov;

import Lukyanov.Human.Human;
import Lukyanov.Human.HumanDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HumanService implements HumanStorage<HumanDTO>{
    private Logger log = LoggerFactory.getLogger(HumanService.class);

    private HumanStorage<Human> storage = new HumanStorageImpl();
    private Mapper<Human, HumanDTO> mapper = new MapperHuman();

    @Override
    public HumanDTO getEntity(long id) {
        Human human = storage.getEntity(id);
        HumanDTO humanDTO = new HumanDTO();
        mapper.toDto(human, humanDTO);
        System.out.println("Get entity:");
        System.out.println(humanDTO.toString());
        return humanDTO;
    }

    @Override
    public List<HumanDTO> getAllEntities() {
        List<HumanDTO> humanDTOList = new ArrayList<>();
        List<Human> humans = storage.getAllEntities();
        System.out.println("Get all entities:");
        for(Human human:humans) {
            HumanDTO humanDTO = new HumanDTO();
            mapper.toDto(human, humanDTO);
            humanDTOList.add(humanDTO);
            System.out.println(humanDTO.toString());
        }
        return humanDTOList;
    }

    @Override
    public void saveEntity(HumanDTO humanDTO) {
        Human human = new Human();
        mapper.toEntity(human, humanDTO);
        storage.saveEntity(human);
    }

    @Override
    public void saveAllEntities(List<HumanDTO> list) {
        List<Human> humans = new ArrayList<>();
        for (HumanDTO humanDTO:list) {
            Human human = new Human();
            mapper.toEntity(human, humanDTO);
            humans.add(human);
        }
        storage.saveAllEntities(humans);
    }
}
