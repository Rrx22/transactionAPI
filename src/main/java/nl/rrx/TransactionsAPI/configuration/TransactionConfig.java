package nl.rrx.TransactionsAPI.configuration;

import nl.rrx.TransactionsAPI.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfig {

    @Bean
    public TransactionService transactionBean() {
        return new TransactionService();
    }

    @Bean
    public ModelMapper modelMapperBean() {
        return new ModelMapper();
    }

}
