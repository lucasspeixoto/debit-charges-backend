package com.lspeixotodev.debitcharges.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "debit_id")
    private UUID debitId;

    @Column(name = "name")
    private String name;
    @Column(name = "government_id")
    private Integer governmentId;

    @Column(name = "email")
    private String email;

    @Column(name = "debt_amount")
    private Long debtAmount;

    @Column(name = " debt_due_date")
    private Date debtDueDate;

    public Document() {
    }

    public Document(UUID debitId, String name, Integer governmentId, String email, Long debtAmount, Date debtDueDate) {
        this.debitId = debitId;
        this.name = name;
        this.governmentId = governmentId;
        this.email = email;
        this.debtAmount = debtAmount;
        this.debtDueDate = debtDueDate;
    }

    public UUID getDebitId() {
        return debitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGovernmentId() {
        return governmentId;
    }

    public void setGovernmentId(Integer governmentId) {
        this.governmentId = governmentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDebtAmount() {
        return debtAmount;
    }

    public void setDebtAmount(Long debtAmount) {
        this.debtAmount = debtAmount;
    }

    public Date getDebtDueDate() {
        return debtDueDate;
    }

    public void setDebtDueDate(Date debtDueDate) {
        this.debtDueDate = debtDueDate;
    }
}
