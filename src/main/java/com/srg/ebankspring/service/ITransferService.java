package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.TransferDTO;

import java.util.List;

public interface ITransferService {
    public TransferDTO createTransfer(Long sourceAccountId, Long targetAccountId, Double amount, String description);
    public void deleteTransfer(Long transferId);
    public List<TransferDTO> GetAllTransfer();
}
