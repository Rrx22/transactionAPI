package nl.rrx.transactionsapi.service;

import nl.rrx.transactionsapi.dto.category.CategoryDTO;
import nl.rrx.transactionsapi.dto.category.CategoryMapper;
import nl.rrx.transactionsapi.entity.Category;
import nl.rrx.transactionsapi.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class CategoryService {

    @Autowired
    private CategoryRepo repo;
    @Autowired
    private CategoryMapper mapper;

    public List<CategoryDTO> getAll() {
        var categories = repo.findAll();
        return categories.stream().map(mapper::mapResponse).toList();
    }

    @Nullable
    public CategoryDTO getById(int id) {
        Optional<Category> category = repo.findById(id);
        return category.map(mapper::mapResponse).orElse(null);
    }

    public CategoryDTO create(CategoryDTO request) {
        var newCategory = mapper.mapRequest(request);
        newCategory = repo.save(newCategory);
        return mapper.mapResponse(newCategory);
    }
}

