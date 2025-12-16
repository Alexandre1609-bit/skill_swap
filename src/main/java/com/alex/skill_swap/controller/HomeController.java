package com.alex.skill_swap.controller;

import com.alex.skill_swap.service.OfferService;
import com.alex.skill_swap.service.TransactionService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final OfferService offerService;
    private final TransactionService transactionService;

    public HomeController (OfferService offerService, TransactionService transactionService) {
        this.offerService = offerService;
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());

        return "home";
    }


    @PostMapping("/buy")
    public String buyOffer(@RequestParam Integer offerId, @RequestParam Integer buyerId){
        transactionService.transferCredits(buyerId, offerId);
        return "redirect:/";
    }

    

}
