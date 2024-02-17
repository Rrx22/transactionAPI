package nl.rrx.transactionsapi.entity;

import jakarta.persistence.*;

@Entity
public class Category extends BaseEntity {
    @Column(nullable = false)
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
