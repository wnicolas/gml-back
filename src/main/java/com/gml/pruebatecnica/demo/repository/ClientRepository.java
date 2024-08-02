package com.gml.pruebatecnica.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.gml.pruebatecnica.demo.Entity.Client;

public interface ClientRepository extends JpaRepository<Client, String>, JpaSpecificationExecutor<Client> {
}
