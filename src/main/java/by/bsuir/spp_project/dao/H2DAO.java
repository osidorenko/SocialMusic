package by.bsuir.spp_project.dao;

import java.util.List;

public interface H2DAO {

    public void create(Object object);

    public List<Object> readAll();

    public Object readById(int id);

    public boolean update(Object object, int id);

    public boolean delete(int id);
}
