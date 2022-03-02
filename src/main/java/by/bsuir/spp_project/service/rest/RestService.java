package by.bsuir.spp_project.service.rest;

import java.util.List;

public interface RestService {

    public void create(Object object);

    public List readAll();

    public Object readById(int id);

    public boolean update(Object object, int id);

    public boolean delete(int id);

    public List getByValue(String column, Integer value);
}
