package com.mexpeditions.dao;

import com.mexpeditions.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpeditionDao extends JpaRepository <Expedition, Integer>{

    public Optional<Expedition> findByIdCommandeLike(int idCommande);
}
