package IGeneric;

import java.util.List;

public interface IGeneral<T> {
    void add(T entity);
    T getById(String id);
    void deleteById(String id);
    List<T> getAll();
}

