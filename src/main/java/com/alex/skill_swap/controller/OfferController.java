package com.alex.skill_swap.controller;

import com.alex.skill_swap.model.Offer;
import com.alex.skill_swap.service.OfferService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api/offers")
public class OfferController {
    private final  OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public ResponseEntity<Offer> create(@RequestBody Offer offer) {
        Offer createOffer = offerService.createOffer(offer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createOffer);
    }

}
