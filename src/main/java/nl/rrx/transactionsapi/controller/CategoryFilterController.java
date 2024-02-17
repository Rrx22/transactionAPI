package nl.rrx.transactionsapi.controller;

import nl.rrx.transactionsapi.dto.MappingException;
import nl.rrx.transactionsapi.dto.categoryfilter.CategoryFilterDTO;
import nl.rrx.transactionsapi.service.CategoryFilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/filters")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryFilterController {

    @Autowired
    private CategoryFilterService service;

    @GetMapping()
    public ResponseEntity<List<CategoryFilterDTO>> getAll() {
        var categories = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryFilterDTO> getDetails(@PathVariable("id") int id) {
        var category = service.getById(id);
        if (category == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody CategoryFilterDTO categoryRequest) {
        try {
            var response = service.create(categoryRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (MappingException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
