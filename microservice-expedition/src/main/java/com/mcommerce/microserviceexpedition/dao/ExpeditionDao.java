package com.mcommerce.microserviceexpedition.dao;

import com.mcommerce.microserviceexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpeditionDao extends JpaRepository <Expedition, Integer>{

   /* public List<Expedition>findAll();
    public ExpeditionfindById(int id);
    public ExpeditionSave(Expedition expedition);*/
}
