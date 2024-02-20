package nl.rrx.transactionsapi.dto.categoryfilter;

import nl.rrx.transactionsapi.dto.Mappable;
import nl.rrx.transactionsapi.dto.MappingException;
import nl.rrx.transactionsapi.entity.Category;
import nl.rrx.transactionsapi.entity.CategoryFilter;
import nl.rrx.transactionsapi.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryFilterMapper implements Mappable<CategoryFilter, CategoryFilterDTO, CategoryFilterDTO> {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryFilter mapRequest(CategoryFilterDTO request) throws MappingException {
        Category category = categoryRepo.findByValue(request.getCategory());
        if (category == null) {
            throw new MappingException("No category exists for: " + request.getCategory());
        }
        var categoryFilter = new CategoryFilter();
        categoryFilter.setCategory(category);
        categoryFilter.setFilter(request.getFilter());
        categoryFilter.setCreateDate(LocalDateTime.now());
        return categoryFilter;
    }

    @Override
    public CategoryFilterDTO mapResponse(CategoryFilter category) {
        var response = new CategoryFilterDTO();
        response.setFilter(category.getFilter());
        response.setCategory(category.getCategory().getValue());
        return response;
    }
}
