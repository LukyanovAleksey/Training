package Lukyanov;

import java.util.List;

public interface HumanStorage<T> {
    T getEntity(long id);
    List<T> getAllEntities();
    void saveEntity(T t);
    void saveAllEntities(List<T> list);
}
