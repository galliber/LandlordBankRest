package daredevil.landlordbankrest.services.base;

import daredevil.landlordbankrest.exceptions.CantMakeTransactionException;
import daredevil.landlordbankrest.models.BankAccount;

public interface TransactionService {
    void makeTransaction(BankAccount sender, BankAccount recipient, float amount) throws CantMakeTransactionException;
}
