package com.onetech.service;
import com.onetech.entity.Client;
import com.onetech.entity.Demande;
import com.onetech.repository.ClientRepository;
import com.onetech.repository.DemandeRepository;
import com.onetech.repository.GestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DemandeRepository demandeRepository;
    @Autowired
    private GestionnaireRepository gestionnaireRepository;

    @Override
    public Client createClient(Client client) {
        Demande demande=new Demande();
        demandeRepository.save(demande);
        client.setDemandes(demande);
        client.setGestionnaire(gestionnaireRepository.findById(1L).orElse(null));
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client updateClient(Long id, Client client) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        client.setId(id);  // Make sure to set the ID for the update
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new RuntimeException("Client not found");
        }
        clientRepository.deleteById(id);
    }
}