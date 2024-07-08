package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.AccountDTO;
import com.srg.ebankspring.model.entity.Account;
import com.srg.ebankspring.model.mapper.AccountMapper;
import com.srg.ebankspring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements IAccountService {

    private List<AccountDTO> accounts = new ArrayList<>();

    @Autowired
    private AccountRepository  accountRepository;

    @Autowired
    private AccountMapper accountMapper;


    @Override
    public AccountDTO createAccount(AccountDTO account) {
        Account accounts = accountMapper.toEntity(account);
        System.out.println(account);
        return accountMapper.toDTO(accountRepository.save(accounts));
    }

    @Override
    public void deleteAccount(AccountDTO account) {
        accounts.remove(account);
    }

    @Override
    public List<AccountDTO> GetAllAccounts() {
        List<Account>  accounts = accountRepository.findAll();
        return accountMapper.toDTOList(accounts);
    }

}
