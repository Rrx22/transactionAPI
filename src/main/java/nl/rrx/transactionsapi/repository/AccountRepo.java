package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Integer> {
}
