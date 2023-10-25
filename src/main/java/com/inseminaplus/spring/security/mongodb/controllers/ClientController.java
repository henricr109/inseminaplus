package com.inseminaplus.spring.security.mongodb.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inseminaplus.spring.security.mongodb.models.Client;
import com.inseminaplus.spring.security.mongodb.repository.ClientRepository;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cli")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClients(@RequestParam(required = false) String name) {
        try {
            List<Client> clients = new ArrayList<>();

            if (name == null)
                clientRepository.findAll().forEach(clients::add);
            else
                clients.addAll(clientRepository.findByNameContaining(name));

            if (clients.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(clients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") long id) {
        Optional<Client> clientData = clientRepository.findById(id);

        if (clientData.isPresent()) {
            return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/clients")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        try {
            Client _client = clientRepository
                    .save(new Client(client.getName(), client.getBirthDate(), client.getAddress(), client.getCertificateCode(), client.getEmail()));
            return new ResponseEntity<>(_client, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") Long id, @RequestBody Client client) {
        Optional<Client> clientData = clientRepository.findById(id);

        if (clientData.isPresent()) {
            Client _client = clientData.get();
            _client.setName(client.getName());
            _client.setBirthDate(client.getBirthDate());
            _client.setAddress(client.getAddress());
            _client.setCertificateCode(client.getCertificateCode());
            _client.setEmail(client.getEmail());
            return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<HttpStatus> deleteClients(@PathVariable("id") Long id) {
        try {
            clientRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/clients")
    public ResponseEntity<HttpStatus> deleteAllClients() {
        try {
            clientRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/testing")
    public String endpointTests() {
        return "Endpoint functionals";
    }

}
