package nl.rrx.transactionsapi.dto.account;

import nl.rrx.transactionsapi.dto.Mappable;
import nl.rrx.transactionsapi.entity.Account;
import nl.rrx.transactionsapi.repository.AccountRepo;
import nl.rrx.transactionsapi.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AccountMapper implements Mappable<Account, AccountRequest, AccountResponse> {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private TransactionRepo transactionRepo;

    public Account mapRequest(AccountRequest request) {
        var account = new Account();
        account.setBalance(request.getBalance());
        account.setBank(request.getBank());
        account.setIban(request.getIban());
        account.setName(request.getName());
        account.setChangeDate(LocalDateTime.now());
        account.setCreateDate(LocalDateTime.now());
        return account;
    }

    public AccountResponse mapResponse(Account account) {
        var transactions = transactionRepo.retrieveByAccountID(account.getId());
        var response = new AccountResponse();
        response.setBalance(account.getBalance().doubleValue());
        response.setBank(account.getBank());
        response.setIban(account.getIban());
        response.setName(account.getName());
        response.setTransactions(transactions.size());
        return response;
    }
}
