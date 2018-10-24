package daredevil.landlordbankrest.services.base;

import daredevil.landlordbankrest.exceptions.CantCreateBankAccountException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Models.BankAccountModel;

public interface BankAccountService {
    BankAccount getById(int id) throws CantCreateBankAccountException;
    void addBankAccount(BankAccount bankAccount);
    void updateBankAccount(int id, BankAccount bankAccount);
    void deleteBankAccount(int id);
    BankAccount getBankAccountByIban(String iban);
    void addBankAccountFromBankAccountModel(BankAccountModel bankAccountModel);
}
