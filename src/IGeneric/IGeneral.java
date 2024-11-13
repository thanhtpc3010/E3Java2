package IGeneric;

import java.util.List;

public interface IGeneral<T> {
    void create(T t);
    T read(int id);
    void update(T t);
    void delete(int id);
}

