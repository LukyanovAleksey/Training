import java.util.List;

public interface MyInterface<T> {
    T getEntity();
    List<T> getAllEntities();
    void saveEntity();
    void saveAllEntities();
}
