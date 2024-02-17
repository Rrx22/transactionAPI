package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.account.id = :accountID")
    List<Transaction> retrieveByAccountID(@Param("accountID") Integer accountID);
}
