package nl.rrx.transactionsapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class CategoryFilter extends BaseEntity {
    @Column
    private String filter;
    @ManyToOne
    private Category category;
}
