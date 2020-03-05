package Lukyanov;

import Lukyanov.Human.Human;
import Lukyanov.Human.HumanDTO;

import java.util.ArrayList;
import java.util.List;

public class HumanService implements HumanStorage<HumanDTO>{
    private HumanStorage<Human> storage = new HumanStorageImpl();
    private Mapper<Human, HumanDTO> mapper = new MapperHuman();

    @Override
    public HumanDTO getEntity(long id) {
        Human human = storage.getEntity(id);
        HumanDTO humanDTO = new HumanDTO();
        mapper.toDto(human, humanDTO);
        return humanDTO;
    }

    @Override
    public List<HumanDTO> getAllEntities() {
        List<HumanDTO> humanDTOList = new ArrayList<>();
        List<Human> humans = storage.getAllEntities();
        for(Human human:humans) {
            HumanDTO humanDTO = new HumanDTO();
            mapper.toDto(human, humanDTO);
            humanDTOList.add(humanDTO);
        }
        return humanDTOList;
    }

    @Override
    public void saveEntity(HumanDTO humanDTO) {
        System.out.println(humanDTO.toString());
        Human human = new Human();
        mapper.toEntity(human, humanDTO);
        storage.saveEntity(human);
    }

    @Override
    public void saveAllEntities(List<HumanDTO> list) {
        List<Human> humans = new ArrayList<>();
        for (HumanDTO humanDTO:list) {
            Human human = new Human();
            System.out.println(humanDTO.toString());
            mapper.toEntity(human, humanDTO);
            humans.add(human);
        }
        storage.saveAllEntities(humans);
    }
}
