package nl.rrx.transactionsapi.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transaction")
public class Transaction extends BaseEntity {

    @Column(nullable = false)
    private double amount;
    @Column(nullable = false)
    private LocalDate date;
    @Column
    private String description;
    @Column
    private String importFile;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Account account;
    @Column
    private boolean isValidated;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImportFile() {
        return importFile;
    }

    public void setImportFile(String importFile) {
        this.importFile = importFile;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isValidated() {
        return isValidated;
    }

    public void setValidated(boolean validated) {
        isValidated = validated;
    }
}
