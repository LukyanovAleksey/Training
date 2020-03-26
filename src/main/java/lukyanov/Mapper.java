package lukyanov;

public interface Mapper<T, E> {
    void toDto(T t, E e);
    void toEntity(T t, E e);
}
