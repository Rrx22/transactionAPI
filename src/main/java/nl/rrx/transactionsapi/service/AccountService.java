package nl.rrx.transactionsapi.service;

import nl.rrx.transactionsapi.entity.Account;
import nl.rrx.transactionsapi.repository.AccountRepo;
import nl.rrx.transactionsapi.dto.account.AccountMapper;
import nl.rrx.transactionsapi.dto.account.AccountRequest;
import nl.rrx.transactionsapi.dto.account.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class AccountService {

    @Autowired
    private AccountRepo repo;
    @Autowired
    private AccountMapper mapper;

    public List<AccountResponse> getAll() {
        var accounts = repo.findAll();
        return accounts.stream().map(mapper::mapResponse).toList();
    }

    @Nullable
    public AccountResponse getById(int id) {
        Optional<Account> account = repo.findById(id);
        return account.map(mapper::mapResponse).orElse(null);
    }

    public AccountResponse create(AccountRequest request) {
        var newAccount = mapper.mapRequest(request);
        newAccount = repo.save(newAccount);
        return mapper.mapResponse(newAccount);
    }
}

