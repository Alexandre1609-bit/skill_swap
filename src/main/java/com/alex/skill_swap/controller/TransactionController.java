package com.alex.skill_swap.controller;
import com.alex.skill_swap.service.TransactionService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController (TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping
    public ResponseEntity<String> updateWallet(@RequestBody TransactionRequest request) {

        transactionService.transferCredits(request.buyerId, request.offerId);
        return ResponseEntity.ok("Transaction réussie !");
    }

}

class TransactionRequest {
    public Integer buyerId;
    public Integer offerId;
}