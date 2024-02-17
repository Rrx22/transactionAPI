package nl.rrx.transactionsapi.service;

import nl.rrx.transactionsapi.entity.Transaction;
import nl.rrx.transactionsapi.repository.TransactionRepo;
import nl.rrx.transactionsapi.dto.MappingException;
import nl.rrx.transactionsapi.dto.transaction.TransactionMapper;
import nl.rrx.transactionsapi.dto.transaction.TransactionRequest;
import nl.rrx.transactionsapi.dto.transaction.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class TransactionService {

    @Autowired
    private TransactionRepo repo;
    @Autowired
    private TransactionMapper mapper;

    public List<TransactionResponse> getAll() {
        var transactions = repo.findAll();
        return transactions.stream().map(mapper::mapResponse).toList();
    }

    @Nullable
    public TransactionResponse getById(int id) {
        Optional<Transaction> transaction = repo.findById(id);
        return transaction.map(mapper::mapResponse).orElse(null);
    }

    public TransactionResponse create(TransactionRequest request) throws MappingException {
        var newTransaction = mapper.mapRequest(request);
        newTransaction = repo.save(newTransaction);
        return mapper.mapResponse(newTransaction);
    }
}

