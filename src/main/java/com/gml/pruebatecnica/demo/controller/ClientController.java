package com.gml.pruebatecnica.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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

import com.gml.pruebatecnica.demo.Entity.Client;
import com.gml.pruebatecnica.demo.repository.ClientRepository;

import jakarta.persistence.criteria.Predicate;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable String id) {
        return clientRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client clientDetails) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            client.setBusinessId(clientDetails.getBusinessId());
            client.setEmail(clientDetails.getEmail());
            client.setPhone(clientDetails.getPhone());
            client.setDateAdded(clientDetails.getDateAdded());
            logger.info("Funcionó el guardado");
            return clientRepository.save(client);
        } else {
            logger.info("No fue posible actualizar el cliente");
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id) {
        clientRepository.deleteById(id);
    }

     @GetMapping("/advanced-search")
        public List<Client> search(@RequestParam Map<String, String> allParams) {
            Specification<Client> specification = (root, query, criteriaBuilder) -> {
                List<Predicate> predicates = new ArrayList<>();
                for (Map.Entry<String, String> entry : allParams.entrySet()) {
                    if (entry.getValue() != null && !entry.getValue().equalsIgnoreCase("")
                            && !entry.getValue().equalsIgnoreCase("null")) {
                                predicates
                                .add(criteriaBuilder.like(criteriaBuilder.upper(root.get(entry.getKey()).as(String.class)),
                                        "%" + entry.getValue().toUpperCase() + "%"));
                    }
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            };

            // Ejecutar la consulta y devolver los resultados.
            return clientRepository.findAll(specification);
        }
}
