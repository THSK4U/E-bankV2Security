package com.srg.ebankspring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transferId;
    private Double amount;
    private String description;
    @Column(updatable = false)
    private LocalDateTime TransferTime;
    @PrePersist
    protected void onCreate() {

        TransferTime = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "sourceaccountId", nullable = false)
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "targetaccountId", nullable = false)
    private Account targetAccount;
}
