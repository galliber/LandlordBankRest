package daredevil.landlordbankrest.models.DTO;

import daredevil.landlordbankrest.models.BankAccount;

public class BankAccountDTO {
    private String iban;
    private float balance;

    public BankAccountDTO() {
    }

    public BankAccountDTO(String iban, float balance) {
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
