package by.bsuir.spp_project.service.rest;

import java.util.List;

public interface RestService {

    public void create(Object object);

    public List<Object> readAll();

    public Object readById(int id);

    public boolean update(Object object, int id);

    public boolean delete(int id);
}
