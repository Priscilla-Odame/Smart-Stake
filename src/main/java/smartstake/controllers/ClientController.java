package smartstake.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import smartstake.entities.Client;
import smartstake.repositories.ClientRepository;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/clients")
    public List<Client> listAll(Model model) {
        List<Client> listClients = clientRepository.findAll();
        model.addAttribute("listClients", listClients);

        return listClients;
    }

}