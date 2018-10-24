package daredevil.landlordbankrest.services;

import daredevil.landlordbankrest.exceptions.CantCreateBankAccountException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Models.BankAccountModel;
import daredevil.landlordbankrest.repositories.base.BankAccountRepository;
import daredevil.landlordbankrest.services.base.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BankAccountServiceImpl implements BankAccountService {
    BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public BankAccount getById(int id) throws CantCreateBankAccountException {
        return bankAccountRepository.getById(id);
    }

    @Override
    public void addBankAccount(BankAccount bankAccount) {
        bankAccountRepository.addBankAccount(bankAccount);
    }

    @Override
    public void updateBankAccount(int id, BankAccount bankAccount) {
        bankAccountRepository.updateBankAccount(id, bankAccount);
    }

    @Override
    public void deleteBankAccount(int id) {
        bankAccountRepository.deleteBankAccount(id);
    }

    @Override
    public BankAccount getBankAccountByIban(String iban) {
        return bankAccountRepository.getBankAccountByIban(iban);
    }

    @Override
    public void addBankAccountFromBankAccountModel(BankAccountModel bankAccountModel) {
        BankAccount bankAccount=new BankAccount(bankAccountModel.getIban(), bankAccountModel.getBalance());
        bankAccountRepository.addBankAccount(bankAccount);
    }
}
