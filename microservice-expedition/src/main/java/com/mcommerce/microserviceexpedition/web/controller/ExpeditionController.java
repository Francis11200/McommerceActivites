package com.mcommerce.microserviceexpedition.web.controller;

import com.mcommerce.microserviceexpedition.model.Expedition;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpeditionController {

    @GetMapping(value="/Expeditions")
    public String listeExpeditions() {
        return "liste des expeditions";
    }

    @PostMapping(value="/Expedition")
    public void ajoutExpedition() {

    }

    @GetMapping(value="/Expedition/{id}")
    public Expedition afficherUneExpedition(@PathVariable int id) {
        Expedition expedition=new Expedition(id, 1);
        return expedition;
    }
}
