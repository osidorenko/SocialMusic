package by.bsuir.spp_project.dao.secure;

import by.bsuir.spp_project.entity.secure.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "clientPostgreSQLDAO")
public class ClientPostgreSQLDAO {

    private ClientRepository clientRepository;

    @Autowired
    public ClientPostgreSQLDAO(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;

    }
    public long count(){
        return clientRepository.count();
    }

    public boolean create(Object object) {
        Client client = (Client) object;
        if (!clientIsExist("login", client.getLogin())) {
            client.setOnline(false);
            clientRepository.save((Client) object);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public boolean updateStatus(String login, boolean setOnline) {
        Client client = clientRepository.readByLogin(login);
        if (setOnline && !client.isOnline()) {
            clientRepository.logIn(login);
            return true;
        }
        if (!setOnline && client.isOnline()) {
            clientRepository.logOut(login);
            return true;
        }
        return false;
    }

    public void logOutAll() {
        clientRepository.logOutAll();
    }

    private boolean clientIsExist(String column, String value) {
        if (column.equals("login")) {
            return clientRepository.readByLogin(value) != null;
        }
        return false;
    }

    public String getHash(String login) {
        Client client = clientRepository.readByLogin(login);
        return client.getHpass();
    }
}
