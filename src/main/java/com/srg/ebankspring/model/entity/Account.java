package com.srg.ebankspring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountType;
    private Double balance;

    @Column(updatable = false)
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "sourceAccount")
    private List<Transfer> sourceTransfers;

    @OneToMany(mappedBy = "targetAccount")
    private List<Transfer> targetTransfers;

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDateTime.now();
    }
}
