package com.srg.ebankspring.controller;

import com.srg.ebankspring.model.dto.AccountDTO;
import com.srg.ebankspring.model.entity.Account;
import com.srg.ebankspring.service.AccountService;
import com.srg.ebankspring.service.TestStreams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TestStreams testStreams;
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccount() {
        return ResponseEntity.ok(accountService.GetAllAccounts());
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok(accountService.createAccount(accountDTO));
    }
    @GetMapping("/TotalBalance")
    public Double getTotal() {
        Double total = testStreams.GetTotal();
        return total;
    }

}
