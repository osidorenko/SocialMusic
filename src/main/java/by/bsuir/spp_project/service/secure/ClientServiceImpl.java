package by.bsuir.spp_project.service.secure;

import by.bsuir.spp_project.dao.secure.ClientPostgreSQLDAO;
import by.bsuir.spp_project.entity.secure.Client;
import by.bsuir.spp_project.entity.social.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService, UserDetailsService {
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();

    @Autowired
    @Qualifier("clientPostgreSQLDAO")
    private ClientPostgreSQLDAO clientDAO;

    @PersistenceContext
    private EntityManager em;

    @PostConstruct
    private void init() {
        CLIENT_ID_HOLDER.set((int)clientDAO.count());
    }

    @PreDestroy
    private void destroy() {
        clientDAO.logOutAll();
    }

    @Override
    public boolean save(Client client, String pass) {

        client.setHpass(generateHashCode(pass));
        return clientDAO.create(client);
    }

    @Override
    public boolean logIn(Client client, String pass) {
        String a = clientDAO.getHash(client.getLogin());
        String c = generateHashCode(pass);

        if (a.equals(c)) {
            return clientDAO.updateStatus(client.getLogin(), true);
        }
        return false;
    }

    @Override
    public boolean logOut(Client client, String pass) {
        if (clientDAO.getHash(client.getLogin()).equals( generateHashCode(pass))) {
            return clientDAO.updateStatus(client.getLogin(), false);
        }
        return false;
    }

    public String generateHashCode(String password) {
        char[] arr = new char[50];
        char[] pass = password.toCharArray();
        long h = 1000;
        int x = 0;
        for (int i = 0; i < pass.length; i++) {
            h += ((((long) Math.pow((int) pass[i], ((i) % 10) + 1) + h * (i + 1)) % 10256) * ((long) pass[i] * (i + 1))) % (Long.MAX_VALUE - 1);
            int a = (int) (h % 1000);
            char[] s = (a + "").toCharArray();
            arr[x++] = s[0];
            arr[x++] = s[1];
        }
        char[] s = (h + "").toCharArray();
        for (int i = 0; i < s.length && x < 50; i++) {
            arr[x++] = s[i];
        }
        while (x < 50) {
            arr[x++] = ' ';
        }
        return String.valueOf(arr);
    }
    public Client findById(Integer id){
        return em.find(Client.class, id);
    }

    public Client byLogin(String login){
        List<Client> all = em.createQuery("select u from Client u where u.login =:login ").setParameter("login", login).getResultList();
        if(all.size() != 1){
            throw new UsernameNotFoundException("var1");
        }
        return all.get(0);
    }

    public UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {
        return byLogin(var1).details();
    }
}
