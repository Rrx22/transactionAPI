package nl.rrx.transactionsapi.dto.category;

import nl.rrx.transactionsapi.dto.Mappable;
import nl.rrx.transactionsapi.entity.Category;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryMapper implements Mappable<Category, CategoryDTO, CategoryDTO> {
    @Override
    public Category mapRequest(CategoryDTO request) {
        var category = new Category();
        category.setValue(request.getValue());
        category.setCreateDate(LocalDateTime.now());
        return category;
    }

    @Override
    public CategoryDTO mapResponse(Category category) {
        var response = new CategoryDTO();
        response.setValue(category.getValue());
        return response;
    }
}
