package nl.rrx.transactionsapi.controller;

import nl.rrx.transactionsapi.dto.category.CategoryDTO;
import nl.rrx.transactionsapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping()
    public ResponseEntity<List<CategoryDTO>> getAll() {
        var categories = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getDetails(@PathVariable("id") int id) {
        var category = service.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping()
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO categoryRequest) {
        var response = service.create(categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
