package com.alex.skill_swap.controller;

import com.alex.skill_swap.model.Offer;
import com.alex.skill_swap.service.OfferService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


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

    @GetMapping
    public ResponseEntity<List<Offer>> getAll() {
        List<Offer> offers = offerService.getAllOffers();
        return ResponseEntity.ok(offers);
    }

}
