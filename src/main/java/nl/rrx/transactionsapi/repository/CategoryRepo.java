package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
