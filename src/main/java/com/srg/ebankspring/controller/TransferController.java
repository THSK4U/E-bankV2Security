package com.srg.ebankspring.controller;

import com.srg.ebankspring.model.dto.AccountDTO;
import com.srg.ebankspring.model.dto.TransferDTO;
import com.srg.ebankspring.repository.TransferRepository;
import com.srg.ebankspring.service.AccountService;
import com.srg.ebankspring.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Transfer")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @Autowired
    private TransferRepository transferRepository;

    @GetMapping
    public ResponseEntity<List<TransferDTO>> getAccount() {
        return ResponseEntity.ok(transferService.GetAllTransfer());
    }

    @PostMapping
    public TransferDTO createTransfer(@RequestBody TransferDTO transferDTO) {
            return transferService.createTransfer(transferDTO.getSourceAccount().getAccountId(),
                    transferDTO.getTargetAccount().getAccountId(),
                    transferDTO.getAmount(),
                    transferDTO.getDescription());
        }

    @DeleteMapping("/{transferId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long transferId) {
        transferService.deleteTransfer(transferId);
        return ResponseEntity.noContent().build();
    }
}
