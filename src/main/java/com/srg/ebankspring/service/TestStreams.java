package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.AccountDTO;
import com.srg.ebankspring.model.entity.Account;
import com.srg.ebankspring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TestStreams {


    @Autowired
    private AccountRepository accountRepository;

    public Double GetTotal() {
        List<Account> accounts = accountRepository.findAll();
        Double Total = accounts.stream()
                .collect(Collectors.summingDouble(Account::getBalance));
        return Total;
    }


}
