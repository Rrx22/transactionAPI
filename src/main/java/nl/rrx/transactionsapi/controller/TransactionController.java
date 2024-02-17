package nl.rrx.transactionsapi.controller;

import nl.rrx.transactionsapi.dto.MappingException;
import nl.rrx.transactionsapi.dto.transaction.TransactionRequest;
import nl.rrx.transactionsapi.dto.transaction.TransactionResponse;
import nl.rrx.transactionsapi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    @Autowired
    private TransactionService service;

    @GetMapping()
    public ResponseEntity<List<TransactionResponse>> getAll() {
        var transactions = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(transactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getDetails(@PathVariable("id") int id) {
        var transaction = service.getById(id);
        if (transaction == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaction);
    }

    @PostMapping("")
    public ResponseEntity<TransactionResponse> create(@RequestBody TransactionRequest transaction) {
        try {
            var response = service.create(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (MappingException e) {
            // TODO find a nice way to put it in the return message??
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
