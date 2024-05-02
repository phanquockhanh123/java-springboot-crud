package com.example.crud.service.impl;

import com.example.crud.dto.AccountDto;
import com.example.crud.entity.Account;
import com.example.crud.mapper.AccountMapper;
import com.example.crud.repository.AccountRepository;
import com.example.crud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account saveAccount =accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() ->new RuntimeException("Account don't exists"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() ->new RuntimeException("Account don't exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account  saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() ->new RuntimeException("Account don't exists"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Not enough amount");
        }
        double total = account.getBalance() - amount;
        account.setBalance(total);

        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accountDtos = accountRepository.findAll();
        return  accountDtos.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() ->new RuntimeException("Account don't exists"));

        accountRepository.deleteById(id);

    }


}
