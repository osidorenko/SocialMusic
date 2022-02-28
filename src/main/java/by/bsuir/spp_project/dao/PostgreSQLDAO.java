package by.bsuir.spp_project.dao;

import java.util.List;

public interface PostgreSQLDAO {

    public void create(Object object);

    public List readAll();

    public Object readById(int id);

    public boolean update(Object object, int id);

    public boolean delete(int id);
}
