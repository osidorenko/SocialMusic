package by.bsuir.spp_project.controller.secure;

import by.bsuir.spp_project.controller.BasicController;
import by.bsuir.spp_project.entity.secure.Client;
import by.bsuir.spp_project.service.secure.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class SecureController extends BasicController {

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

    @GetMapping("/current")
    public ResponseEntity<?> current() {
        return ResponseEntity.ok(context());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public void doGet(HttpServletResponse response) throws Exception {//spring will put the response in for you
        response.sendRedirect("/index.html");
    }

    //todo: use standard spring-security login
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
