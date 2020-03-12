package Lukyanov;

import Lukyanov.Exceptions.HumanServiceException;
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
    public HumanDTO getEntity(long id) throws HumanServiceException {

        if (id < 0) {
            log.error("Id should be positive, requested id: " + id);
            throw new HumanServiceException(this.getClass().toString() + " The entity is not exist");
        }
        Human human = storage.getEntity(id);
        HumanDTO humanDTO = new HumanDTO();
        mapper.toDto(human, humanDTO);
        log.info("Get entity: " + humanDTO.toString());
        return humanDTO;
    }

    @Override
    public List<HumanDTO> getAllEntities() {
        List<HumanDTO> humanDTOList = new ArrayList<>();
        List<Human> humans = storage.getAllEntities();
        log.info("Get all entities:");
        for(Human human:humans) {
            HumanDTO humanDTO = new HumanDTO();
            mapper.toDto(human, humanDTO);
            humanDTOList.add(humanDTO);
            log.info(humanDTO.toString());
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
