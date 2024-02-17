package nl.rrx.transactionsapi.dto.account;

import nl.rrx.transactionsapi.dto.Request;

import java.math.BigDecimal;

public class AccountRequest implements Request {
    private String name;
    private String iban;
    private BigDecimal balance;
    private String bank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
