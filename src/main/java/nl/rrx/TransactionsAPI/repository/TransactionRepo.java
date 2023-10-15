package nl.rrx.TransactionsAPI.repository;

import nl.rrx.TransactionsAPI.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
}
