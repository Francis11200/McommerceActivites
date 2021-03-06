package com.mexpeditions.web.controller;

import com.mexpeditions.dao.ExpeditionDao;
import com.mexpeditions.model.Expedition;
import com.mexpeditions.web.exceptions.ExpeditionNotFoundException;
import com.mexpeditions.web.exceptions.ImpossibleAjouterExpeditionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
public class ExpeditionController {

    @Autowired
    private ExpeditionDao expeditionDao;

    @PutMapping(value="/Expedition/{id}")
    public Expedition modifierExpedition(@RequestBody Expedition expedition) {

        Expedition expeditionModifiee = expeditionDao.save(expedition);
        if (expeditionModifiee == null) throw new ImpossibleAjouterExpeditionException( "Impossible de modifier l'expedition");
        return expeditionModifiee;
    }

    @PostMapping(value="/Expedition")
    public ResponseEntity<Expedition> ajouterUneExpedition(@RequestBody Expedition expedition) {
        Expedition nouvelleExpedition = expeditionDao.save(expedition);

        if (nouvelleExpedition == null) throw new ImpossibleAjouterExpeditionException("Impossible d'ajouter une nouvelle expedition");

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(nouvelleExpedition.getId()).toUri();

        ResponseEntity<Expedition> expeditionAjout = ResponseEntity.created(location).build();
        return expeditionAjout;
    }


    @GetMapping(value="/Expedition/{id}")
    public Expedition afficherUneExpedition(@PathVariable int id) {
        Optional<Expedition> expedition = expeditionDao.findById(id);
        if (!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expédition n'existe pas");
        return expedition.get();
    }

    @GetMapping(value = "/suivi/{idCommande}")
    public Optional<Expedition> etatExpedition(@PathVariable int idCommande) {

        Optional<Expedition> expedition = expeditionDao.findByIdCommandeLike(idCommande);

        if (!expedition.isPresent()) throw new ExpeditionNotFoundException("Cette expedition n'existe pas");

        else return expedition;
    }

}
