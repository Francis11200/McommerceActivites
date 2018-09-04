package com.mcommerce.microserviceexpedition.web.controller;

import com.mcommerce.microserviceexpedition.dao.ExpeditionDao;
import com.mcommerce.microserviceexpedition.model.Expedition;
import com.mcommerce.microserviceexpedition.web.exceptions.ExpeditionNotFoundException;
import com.mcommerce.microserviceexpedition.web.exceptions.ImpossibleAjouterExpeditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    private ExpeditionDao expeditionDao;

    @PostMapping(value="/Expedition/{id}")
    public void modifierExpedition(int id) {
        expeditionDao.update(id);
    }

    @PostMapping(value="/Expedition")
    public ResponseEntity<Expedition> ajoutExpedition(@RequestBody Expedition expedition) {
       Expedition nouvelleExpedition = expeditionDao.save(expedition);
       
       if (nouvelleExpedition == null) throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter une nouvelle expedition");
       return new ResponseEntity<Expedition>(expedition, HttpStatus.CREATED);
    }

    @GetMapping(value="/Expedition/{id}")
    public Optional<Expedition> afficherUneExpedition(@PathVariable int id) {
       Optional<Expedition> expedition = expeditionDao.findById(id);
       if (!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expédition n'existe pas");
       return expedition;
    }
}
