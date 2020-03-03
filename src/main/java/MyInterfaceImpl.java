import Human.Human;

import java.util.ArrayList;
import java.util.List;

public class MyInterfaceImpl implements MyInterface<Human> {
    private List<Human> humans = new ArrayList<Human>();

    public Human getEntity() {
        System.out.println();
        return null;
    }

    public List<Human> getAllEntities() {
        return null;
    }

    public void saveEntity() {

    }

    public void saveAllEntities() {

    }
}
