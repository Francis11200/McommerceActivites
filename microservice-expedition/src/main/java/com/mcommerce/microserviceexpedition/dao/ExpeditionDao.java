package com.mcommerce.microserviceexpedition.dao;

import com.mcommerce.microserviceexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpeditionDao extends JpaRepository <Expedition, Integer>{

    public void update(int id);
    public Optional<Expedition> findById(int id);
    public void save(int id, int idCommande, int etat);
}
