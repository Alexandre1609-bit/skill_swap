package com.alex.skill_swap.service;
import java.util.List;
import com.alex.skill_swap.model.Offer;
import com.alex.skill_swap.repository.OfferRepository;
import org.springframework.stereotype.Service;


@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer createOffer(Offer offer) {
        offer.setId(null);
        return offerRepository.save(offer);
    }

    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }
}
