package com.onetech.service;

import com.onetech.entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {

    Client createClient(Client client);

    Optional<Client> getClientById(Long id);

    List<Client> getAllClients();

    Client updateClient(Long id, Client client);

    void deleteClient(Long id);
}