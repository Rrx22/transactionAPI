package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
