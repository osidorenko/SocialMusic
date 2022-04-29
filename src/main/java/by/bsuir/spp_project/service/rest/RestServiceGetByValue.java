package by.bsuir.spp_project.service.rest;

import java.util.List;

public interface RestServiceGetByValue<E> {
    public List<E> getByValue(String column, Integer value);
}
