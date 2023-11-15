package nl.rrx.transactionsapi.controller;

import nl.rrx.transactionsapi.response.transaction.TransactionRequest;
import nl.rrx.transactionsapi.response.transaction.TransactionResponse;
import nl.rrx.transactionsapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    private ResponseEntity<List<TransactionResponse>> getAll() {
        var transactions = transactionService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }


    @GetMapping("/{id}")
    private ResponseEntity<TransactionResponse> getDetails(@PathVariable("id") int id) {
        var transaction = transactionService.getById(id);
        if (transaction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }

    @PostMapping("")
    private ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest transaction) {
        var response = transactionService.create(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
