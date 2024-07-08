package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.TransferDTO;
import com.srg.ebankspring.model.entity.Account;
import com.srg.ebankspring.model.entity.Transfer;
import com.srg.ebankspring.model.mapper.TransferMapper;
import com.srg.ebankspring.repository.AccountRepository;
import com.srg.ebankspring.repository.TransferRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransferService implements ITransferService {

    @Autowired
    private TransferMapper transferMapper;

    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    @Transactional
    public TransferDTO createTransfer(Long sourceAccountId, Long targetAccountId, Double amount, String description) {
        Account sourceAccount = accountRepository.findById(sourceAccountId).orElseThrow(() -> new EntityNotFoundException("Source account not found"));
        Account targetAccount = accountRepository.findById(targetAccountId).orElseThrow(() -> new EntityNotFoundException("Target account not found"));

        // Check
        if (sourceAccount.getBalance() < amount) {
            throw new RuntimeException("amount not not enough");
        }

        // Calcul
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);

        // Save
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // Create a transfer entity
        Transfer transfer = new Transfer();
        transfer.setSourceAccount(sourceAccount);
        transfer.setTargetAccount(targetAccount);
        transfer.setAmount(amount);
        transfer.setDescription(description);

        transfer = transferRepository.save(transfer);

        // Map transfer
        TransferDTO transferDTO = transferMapper.toDTO(transfer);
        return transferDTO;
    }


    @Override
    public void deleteTransfer(Long transferId) {
        transferRepository.delete(transferRepository.findById(transferId).get());
    }

    @Override
    public List<TransferDTO> GetAllTransfer() {
        List<Transfer> transfers = transferRepository.findAll();
        System.out.println("test" + transferMapper.toDTOList(transfers));
        return transferMapper.toDTOList(transfers);
    }
}
