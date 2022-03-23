package by.bsuir.spp_project.service.rest;

import java.util.List;

public interface RestService<E> {

    public void create(E object);

    public List<E> readAll();

    public E readById(int id);

    public boolean update(E object, int id);

    public boolean delete(int id);

    public List<E> getByValue(String column, Integer value);

}
