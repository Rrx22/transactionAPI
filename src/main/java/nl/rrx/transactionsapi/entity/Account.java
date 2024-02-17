package nl.rrx.transactionsapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Account extends BaseEntity {

    @Column
    private String name;
    @Column
    private String iban;
    @Column
    private BigDecimal balance;
    @Column
    private String bank;
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactionList;

}
