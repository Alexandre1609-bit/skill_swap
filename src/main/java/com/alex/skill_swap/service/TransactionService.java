package com.alex.skill_swap.service;

import com.alex.skill_swap.model.Offer;
import com.alex.skill_swap.model.User;
import com.alex.skill_swap.repository.OfferRepository;
import com.alex.skill_swap.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class TransactionService {

    private final OfferRepository offerRepository;
    private final UserRepository userRepository;

    public TransactionService(OfferRepository offerRepository, UserRepository userRepository) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void transferCredits(Integer buyerId, Integer offerId) {

        Offer offer = offerRepository.findById(offerId).orElseThrow(() -> new RuntimeException("Offre non trouvée"));
        User buyer = userRepository.findById(buyerId).orElseThrow(() -> new  RuntimeException("Acheteur non trouvé"));
        User seller = offer.getCreator();


        //Mon filtre "Anti-Narcissique" impossible d'acheter ses propres cours
        if (buyer.getId().equals(seller.getId()))  {
            throw new RuntimeException("Impossible d'acheter ses propres offres !");
        }

        if (buyer.getBalance() < offer.getCreditCost()) {
            throw new RuntimeException("Impossible : crédits insuffisants !");
        }

        int price = offer.getCreditCost();
        //Mettre à jour le portefeuille de l'acheteur
        buyer.setBalance(buyer.getBalance() - price);

        //Mettre à jour le portefeuille du vendeur
        seller.setBalance(seller.getBalance() + price);

        //On sauvegarde
        userRepository.save(buyer);
        userRepository.save(seller);

    }

    }



