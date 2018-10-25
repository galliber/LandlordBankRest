package daredevil.landlordbankrest.services;

import daredevil.landlordbankrest.exceptions.CantMakeTransactionException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.repositories.base.TransactionsRepository;
import daredevil.landlordbankrest.services.base.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionServiceImpl(TransactionsRepository transactionsRepository) {
        this.transactionsRepository = transactionsRepository;
    }

    @Override
    public void makeTransaction(BankAccount sender, BankAccount recipient, float amount) throws CantMakeTransactionException {
        transactionsRepository.makeTransaction(sender, recipient, amount);
    }
}
