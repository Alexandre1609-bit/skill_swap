package com.alex.skill_swap.service;

import com.alex.skill_swap.model.Offer;
import com.alex.skill_swap.model.User;
import com.alex.skill_swap.repository.UserRepository;
import com.alex.skill_swap.repository.OfferRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionserviceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private OfferRepository offerRepository;

    @InjectMocks
    private TransactionService transactionService;


    @Test
    public void testOffer() {
        User acheteur = new User("Acheteur", "test", "test@test.test", 4, 100);
        User vendeur = new User("Vendeur", "vendeur", "vendeur@money.fr", 5, 50);
        Offer testOffer = new Offer();
        testOffer.setId(5);
        testOffer.setTitle("Volleyball");
        testOffer.setDescription("Cours de volley");
        testOffer.setCreditCost(20);

        testOffer.setCreator(vendeur);

        when(userRepository.findById(4)).thenReturn(Optional.of(acheteur));
        when(offerRepository.findById(5)).thenReturn(Optional.of(testOffer));


        transactionService.transferCredits(4, 5);

        assertEquals(80, acheteur.getBalance());
        assertEquals(70, vendeur.getBalance());
    }


    @Test
    public void testInsufficientBalance() {
        User poorUser = new User("Quentin", "pass123", "quentin@test.az", 6, 10);
        User vendeur = new User("Vendeur", "vendeur", "vendeur@money.fr", 7, 50);

        Offer offer = new Offer();
        offer.setId(6);
        offer.setTitle("Volleyball");
        offer.setDescription("Cours de volley");
        offer.setCreditCost(150);
        offer.setCreator(vendeur);

        when(userRepository.findById(6)).thenReturn(Optional.of(poorUser));
        when(offerRepository.findById(6)).thenReturn(Optional.of(offer));


        assertThrows(RuntimeException.class, () -> transactionService.transferCredits(6, 6));
    }
}