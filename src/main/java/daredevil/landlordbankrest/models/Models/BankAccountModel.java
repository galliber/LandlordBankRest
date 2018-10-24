package daredevil.landlordbankrest.models.Models;

import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.DTO.BankAccountDTO;

public class BankAccountModel {
    private String iban;
    private float balance;

    public BankAccountModel() {
    }

    public BankAccountModel(String iban, float balance) {
        this.iban = iban;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public static BankAccountDTO getFromBankAccount(BankAccount bankAccount){
        return new BankAccountDTO(bankAccount.getIban(), bankAccount.getBalance());
    }
}
