package Lukyanov;

import Lukyanov.Human.Human;
import Lukyanov.Human.HumanDTO;

import java.util.List;

public class HumanService implements HumanStorage<HumanDTO>{
    private HumanStorage<Human> storage = new HumanStorageImpl();
    //Mapper

    @Override
    public HumanDTO getEntity(long id) {
        return null;
    }

    @Override
    public List<HumanDTO> getAllEntities() {
        return null;
    }

    @Override
    public void saveEntity(HumanDTO humanDTO) {

    }

    @Override
    public void saveAllEntities(List<HumanDTO> list) {

    }
}
