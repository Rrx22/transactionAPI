package nl.rrx.transactionsapi.configuration;

import nl.rrx.transactionsapi.dto.transaction.TransactionMapper;
import nl.rrx.transactionsapi.service.TransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionService transactionBean() {
        return new TransactionService();
    }

    @Bean
    public TransactionMapper transactionMapper() {
        return new TransactionMapper();
    }

}
