package carsharing.model.dao;

import java.util.List;

public interface CarShareDAO<T> {
    List<T> findAll();

    T findById(int id);

    void add(T newEntity);


}
