package by.bsuir.spp_project.controller.secure;

import by.bsuir.spp_project.entity.secure.Client;
import by.bsuir.spp_project.service.secure.ClientService;
import jdk.net.SocketFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecureController {
    @Autowired
    @Qualifier(value = "clientServiceImpl")
    private ClientService clientService;

    @PostMapping("/clients")
    public ResponseEntity<?> save(@RequestBody Client client) {
        StringBuilder builder = new StringBuilder();
        builder.append(client.getHpass());
        return clientService.save(client, builder.toString()) ?
                new ResponseEntity<>(HttpStatus.CREATED) :
                new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }

    @PostMapping("/clients/login")
    public ResponseEntity<?> logIn(@RequestParam("login") String login, @RequestParam("password") String password) {
        return clientService.logIn(new Client(login), password) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/clients/logout")
    public ResponseEntity<?> logOut(@RequestParam("login") String login, @RequestParam("password") String password) {
        return clientService.logOut(new Client(login), password) ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
