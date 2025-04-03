package com.SpringJpa.demo.repository;

import com.SpringJpa.demo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
