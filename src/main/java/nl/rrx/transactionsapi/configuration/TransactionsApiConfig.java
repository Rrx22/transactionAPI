package nl.rrx.transactionsapi.configuration;

import nl.rrx.transactionsapi.dto.account.AccountMapper;
import nl.rrx.transactionsapi.dto.category.CategoryMapper;
import nl.rrx.transactionsapi.dto.categoryfilter.CategoryFilterMapper;
import nl.rrx.transactionsapi.dto.transaction.TransactionMapper;
import nl.rrx.transactionsapi.service.AccountService;
import nl.rrx.transactionsapi.service.CategoryFilterService;
import nl.rrx.transactionsapi.service.CategoryService;
import nl.rrx.transactionsapi.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionsApiConfig {

//     Services
    @Bean
    public TransactionService transactionServiceBean() {
        return new TransactionService();
    }
    @Bean
    public AccountService accountServiceBean() {
        return new AccountService();
    }
    @Bean
    public CategoryService categoryServiceBean() {
        return new CategoryService();
    }
    @Bean
    public CategoryFilterService categoryFilterServiceBean() {
        return new CategoryFilterService();
    }

//     Mappers
    @Bean
    public TransactionMapper transactionMapperBean() {
        return new TransactionMapper();
    }
    @Bean
    public AccountMapper accountMapperBean() {
        return new AccountMapper();
    }
    @Bean
    public CategoryMapper categoryMapperBean() {
        return new CategoryMapper();
    }
    @Bean
    public CategoryFilterMapper categoryFilterMapperBean() {
        return new CategoryFilterMapper();
    }

}
