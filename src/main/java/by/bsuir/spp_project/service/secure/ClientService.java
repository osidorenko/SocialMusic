package by.bsuir.spp_project.service.secure;

import by.bsuir.spp_project.entity.secure.Client;

public interface ClientService {
    public boolean save(Client client, String pass);

    public boolean logIn(Client client,String pass);

    public boolean logOut(Client client, String pass);

}
