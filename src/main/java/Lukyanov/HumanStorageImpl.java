package Lukyanov;

import Lukyanov.Human.Human;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class HumanStorageImpl implements HumanStorage<Human> {
    private Logger log = LoggerFactory.getLogger(HumanStorageImpl.class);

    @Override
    public Human getEntity(long id) {
        return createHuman(id);
    }

    @Override
    public List<Human> getAllEntities() {
        List<Human> humans = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i<5; i++) {
            humans.add(createHuman(random.nextLong()));
        }
        return humans;
    }

    @Override
    public void saveEntity(Human human) {
        System.out.println("Save entity:");
        System.out.println(human);
    }

    @Override
    public void saveAllEntities(List<Human> humans) {
        System.out.println("Save all entities:");
        for (Human human:humans) {
            System.out.println(human);
        }
    }

    private Human createHuman(long UUID){
        Human human = new Human();

        human.setId(UUID);
        human.setName("human"+UUID);
        human.setAddress(createAddress(human, UUID));

        // -946771200000L = January 1, 1940
        // Add up to 80 years to it
        long ms = -946771200000L + (Math.abs(UUID) % (80L * 365 * 24 * 60 * 60 * 1000));
        human.setBirthDate(new Date(ms));

        human.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
        Random random = new Random();
        human.setEditedBy(random.nextLong());

        log.info("Human " + human + " has been created");
        return human;
    }

    private Human.Address createAddress(Human human, long id) {
        Random random = new Random();
        Human.Address address = human.new Address();
        address.setCountry("Country"+id);
        address.setCity("City"+id);
        address.setStreet("Street"+id);
        address.setHome("Home"+id);
        address.setFlat("Flat"+id);
        address.setIndex(random.nextInt());
        address.setEditedBy(random.nextLong());
        address.setModifiedDate(new Date(java.lang.System.currentTimeMillis()));
        log.info("Address " + address + " has been created for Human " + human);
        return address;
    }
}
