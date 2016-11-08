package api;

/**
 * Created by user on 07.11.2016.
 */

public interface IBaseModelDAO<T> {
    String name = "jpaModule";
    void create(T object);

    T find(String id);

    void delete(String id);

    T update(String id, T object);
}
