package nl.rrx.TransactionsAPI.controller;

import nl.rrx.TransactionsAPI.response.transaction.TransactionRequest;
import nl.rrx.TransactionsAPI.response.transaction.TransactionResponse;
import nl.rrx.TransactionsAPI.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    private ResponseEntity<List<TransactionResponse>> getAll() {
        var transactions = transactionService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }


    @GetMapping("/transactions/{id}")
    private ResponseEntity<TransactionResponse> getDetails(@PathVariable("id") int id) {
        var transaction = transactionService.getById(id);
        if (transaction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }

    @PostMapping("/transactions")
    private ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest transaction) {
        var response = transactionService.create(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
