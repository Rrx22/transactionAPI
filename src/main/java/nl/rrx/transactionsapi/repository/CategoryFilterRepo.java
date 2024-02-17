package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.CategoryFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryFilterRepo extends JpaRepository<CategoryFilter, Integer> {
}
