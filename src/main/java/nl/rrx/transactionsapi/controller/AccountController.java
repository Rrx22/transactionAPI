package nl.rrx.transactionsapi.controller;

import nl.rrx.transactionsapi.dto.account.AccountRequest;
import nl.rrx.transactionsapi.dto.account.AccountResponse;
import nl.rrx.transactionsapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping()
    public ResponseEntity<List<AccountResponse>> getAll() {
        var accounts = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getDetails(@PathVariable("id") int id) {
        var account = service.getById(id);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @PostMapping()
    public ResponseEntity<AccountResponse> create(@RequestBody AccountRequest accountRequest) {
        var response = service.create(accountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
