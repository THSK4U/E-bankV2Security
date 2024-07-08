package com.srg.ebankspring.service;

import com.srg.ebankspring.model.dto.AccountDTO;

import java.util.List;

public interface IAccountService {
    public AccountDTO createAccount(AccountDTO account);
    public void deleteAccount(AccountDTO account);
    public List<AccountDTO> GetAllAccounts();


}
