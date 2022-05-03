package by.bsuir.spp_project.dao.social;

import java.util.List;

public interface PostgreSQLPost {
    public List<Object> getPostsByUser(Integer user_id);

    public int getLast();
}
