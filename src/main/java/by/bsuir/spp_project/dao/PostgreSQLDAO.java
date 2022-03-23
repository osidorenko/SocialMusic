package by.bsuir.spp_project.dao;

import by.bsuir.spp_project.entity.social.Comment;

import java.util.List;

public interface PostgreSQLDAO<E> {

    public int count();

    public boolean create(E object);

    public List<E> readAll();

    public E readById(int id);

    public boolean update(E object, int id);

    public boolean delete(int id);

    public List getByValue(String column, Integer value);
}
