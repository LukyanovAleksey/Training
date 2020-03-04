package Lukyanov;

import Lukyanov.Human.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanStorageImpl implements HumanStorage<Human> {
    @Override
    public Human getEntity(long id) {
        return createHuman();
    }

    @Override
    public List<Human> getAllEntities() {
        List<Human> humans = new ArrayList<>();
        for (int i=0; i<5; i++) {
            humans.add(createHuman());
        }
        return humans;
    }

    @Override
    public void saveEntity(Human human) {
        System.out.println(human);
    }

    @Override
    public void saveAllEntities(List<Human> humans) {

    }

    public Human createHuman(){
        Human human = new Human();
        Random random = new Random();
        long UUID = random.nextLong();

        human.setId(random.nextLong());
        human.setName("human"+UUID);
        //Human.Address address = new Human.Address();

        // -946771200000L = January 1, 1940
        // Add up to 80 years to it
        long ms = -946771200000L + (Math.abs(UUID) % (80L * 365 * 24 * 60 * 60 * 1000));
        human.setBirthDate(new Date(ms));

        human.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
        human.setEditedBy(random.nextLong());

        return human;
    }
}
