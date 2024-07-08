package com.srg.ebankspring.model.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TransactionDTO {
    private Long Transactionid;
    private Date date;
    private Double amount;
    private String description;
    private String type;

}
