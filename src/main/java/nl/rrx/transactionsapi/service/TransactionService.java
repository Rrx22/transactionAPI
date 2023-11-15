package nl.rrx.transactionsapi.service;

import nl.rrx.transactionsapi.entity.Transaction;
import nl.rrx.transactionsapi.repository.TransactionRepo;
import nl.rrx.transactionsapi.response.transaction.TransactionRequest;
import nl.rrx.transactionsapi.response.transaction.TransactionResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class TransactionService {

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private ModelMapper mapper;

    public List<TransactionResponse> getAll() {
        List<Transaction> transactions = transactionRepo.findAll();
        return mapper.map(transactions, List.class);
    }

    @Nullable
    public TransactionResponse getById(int id) {
        Optional<Transaction> transaction = transactionRepo.findById(id);
        if (transaction.isEmpty()) {
            return null;
        }
        return mapper.map(transaction, TransactionResponse.class);
    }

    public TransactionResponse create(TransactionRequest request) {
        var newTransaction = mapper.map(request, Transaction.class);
        newTransaction = transactionRepo.save(newTransaction);
        return mapper.map(newTransaction, TransactionResponse.class);
    }
}
