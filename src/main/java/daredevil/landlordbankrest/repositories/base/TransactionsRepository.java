package daredevil.landlordbankrest.repositories.base;

import daredevil.landlordbankrest.exceptions.CantMakeTransactionException;
import daredevil.landlordbankrest.models.BankAccount;

public interface TransactionsRepository {
    void makeTransaction(BankAccount sender, BankAccount recipient, float amount) throws CantMakeTransactionException;
}
