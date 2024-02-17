package nl.rrx.transactionsapi.configuration;

import nl.rrx.transactionsapi.dto.category.CategoryMapper;
import nl.rrx.transactionsapi.service.CategoryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryService categoryBean() {
        return new CategoryService();
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

}
