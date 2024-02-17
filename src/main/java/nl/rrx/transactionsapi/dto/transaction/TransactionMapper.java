package nl.rrx.transactionsapi.dto.transaction;

import nl.rrx.transactionsapi.dto.Mappable;
import nl.rrx.transactionsapi.entity.Transaction;
import nl.rrx.transactionsapi.repository.AccountRepo;
import nl.rrx.transactionsapi.repository.CategoryRepo;
import nl.rrx.transactionsapi.dto.MappingException;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class TransactionMapper implements Mappable<Transaction, TransactionRequest, TransactionResponse> {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Transaction mapRequest(TransactionRequest request) throws MappingException {
        var transaction = new Transaction();
        var account = accountRepo.findById(request.getAccountID());
        var category = categoryRepo.findByValue(request.getCategory());
        if (account.isEmpty()) {
            throw new MappingException("No account exists with ID: " + request.getAccountID());
        } else if (category == null) {
            throw new MappingException("No category exists for: " + request.getCategory());
        }

        transaction.setCategory(category);
        transaction.setAccount(account.get());
        transaction.setAmount(request.getAmount());
        transaction.setDate(request.getDate());
        transaction.setDescription(request.getDescription());
        transaction.setImportFile(request.getImportFile());
        transaction.setValidated(request.isValidated());
        transaction.setChangeDate(LocalDateTime.now());
        transaction.setCreateDate(LocalDateTime.now());
        return transaction;
    }

    @Override
    public TransactionResponse mapResponse(Transaction transaction) {
        var response = new TransactionResponse();
       response.setAccountName(transaction.getAccount().getName());
       response.setAmount(transaction.getAmount());
       response.setCategory(transaction.getCategory().getValue());
       response.setDate(transaction.getDate());
       response.setDescription(transaction.getDescription());
       response.setId(transaction.getId());
       response.setValidated(transaction.isValidated());
       response.setImportFile(transaction.getImportFile());
       response.setCreateDate(transaction.getCreateDate());
       response.setChangeDate(transaction.getChangeDate());
       return response;
    }
}
