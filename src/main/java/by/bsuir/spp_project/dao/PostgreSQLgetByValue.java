package by.bsuir.spp_project.dao;

import java.util.List;

public interface PostgreSQLgetByValue<E> {
    public List<E> getByValue(String column, Integer value);
}
