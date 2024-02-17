package nl.rrx.transactionsapi.repository;

import nl.rrx.transactionsapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

    @Query("SELECT c FROM Category c WHERE LOWER(c.value) = LOWER(:value)")
    Category findByValue(@Param("value") String value);
}
