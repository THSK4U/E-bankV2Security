package com.srg.ebankspring.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    @JoinColumn(name = "sourceaccountId", nullable = false)
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "targetaccountId", nullable = false)
    private Account targetAccount;
}
