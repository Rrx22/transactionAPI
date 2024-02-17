package nl.rrx.transactionsapi.service;

import nl.rrx.transactionsapi.dto.MappingException;
import nl.rrx.transactionsapi.dto.categoryfilter.CategoryFilterDTO;
import nl.rrx.transactionsapi.dto.categoryfilter.CategoryFilterMapper;
import nl.rrx.transactionsapi.entity.CategoryFilter;
import nl.rrx.transactionsapi.repository.CategoryFilterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Optional;

public class CategoryFilterService {

    @Autowired
    private CategoryFilterRepo repo;
    @Autowired
    private CategoryFilterMapper mapper;

    public List<CategoryFilterDTO> getAll() {
        var categoryFilters = repo.findAll();
        return categoryFilters.stream().map(mapper::mapResponse).toList();
    }

    @Nullable
    public CategoryFilterDTO getById(int id) {
        Optional<CategoryFilter> categoryFilter = repo.findById(id);
        return categoryFilter.map(mapper::mapResponse).orElse(null);
    }

    public CategoryFilterDTO create(CategoryFilterDTO request) throws MappingException {
        var newCategoryFilter = mapper.mapRequest(request);
        newCategoryFilter = repo.save(newCategoryFilter);
        return mapper.mapResponse(newCategoryFilter);
    }
}

