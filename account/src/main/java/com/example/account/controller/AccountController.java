package com.example.account.controller;

import com.example.account.model.AccountModel;
import com.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/account")
    private List<AccountModel>getAllAccountModel(){
        return accountRepository.findAll();
    }

    @GetMapping("/account/{accNumber}")
    private AccountModel getAccountModel(@PathVariable("accNumber") long accNumber) throws Exception {
        var result = accountRepository.findById(accNumber);
        if(result.isEmpty()){
            throw new Exception("not found");
        }
        return result.get();
    }
    @DeleteMapping("/account/{accNumber}")
    private void deleteAccount(@PathVariable("accNumber") long accNumber) throws Exception {
        var result = accountRepository.findById(accNumber);
        if (result.isEmpty()){
            throw new Exception("not found");
        }
        accountRepository.deleteById(accNumber);
    }
    @PostMapping("/account")
    private void saveAccount(@RequestBody AccountModel accountModel){
        accountRepository.save(accountModel);
    }

    @PutMapping("/account/{accNumber}")
    private AccountModel updateAccount(@PathVariable("accNumber") long accNumber, @RequestBody AccountModel accountModel) throws Exception {
        var result = accountRepository.findById(accNumber);
        if (result.isEmpty()){
            throw new Exception("not found");
        }
        var data = result.get();
        data.setAccountType(accountModel.getAccountType());
        data.setAccountName(accountModel.getAccountName());
        data.setBalance(accountModel.getBalance());
        data.setDate(accountModel.getDate());
        accountRepository.save(data);
        return data;
    }
}
