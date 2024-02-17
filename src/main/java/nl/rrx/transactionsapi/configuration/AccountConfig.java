package nl.rrx.transactionsapi.configuration;

import nl.rrx.transactionsapi.dto.account.AccountMapper;
import nl.rrx.transactionsapi.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    public AccountService accountBean() {
        return new AccountService();
    }

    @Bean
    public AccountMapper accountMapper() {
        return new AccountMapper();
    }

}
