package com.srg.ebankspring.model.dto;

import com.srg.ebankspring.model.entity.Account;
import lombok.Data;

@Data
public class TransferDTO {

    private Long transferId;
    private Double amount;
    private String description;
    private AccountDTO sourceAccount;
    private AccountDTO targetAccount;
}
