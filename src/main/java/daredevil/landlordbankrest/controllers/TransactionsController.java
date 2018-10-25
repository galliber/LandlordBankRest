package daredevil.landlordbankrest.controllers;

import daredevil.landlordbankrest.exceptions.CantMakeTransactionException;
import daredevil.landlordbankrest.models.BankAccount;
import daredevil.landlordbankrest.models.Models.TransactionsModel;
import daredevil.landlordbankrest.services.base.BankAccountService;
import daredevil.landlordbankrest.services.base.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {

    private TransactionService transactionService;
    private BankAccountService bankAccountService;

    @Autowired
    public TransactionsController(TransactionService transactionService, BankAccountService bankAccountService) {
        this.transactionService = transactionService;
        this.bankAccountService=bankAccountService;
    }

    @PostMapping("/makeTransaction")
    public String makeTransaction(@RequestBody TransactionsModel transactionsModel){
        String message="";
        try {
            BankAccount sender=bankAccountService.getBankAccountByIban(transactionsModel.getSender().getIban());
            BankAccount recipient=bankAccountService.getBankAccountByIban(transactionsModel.getRecipient().getIban());
            transactionService.makeTransaction(sender, recipient, transactionsModel.getTransferredAmount());
            message="Successful transaction.";
        }catch (CantMakeTransactionException e) {
            message = "Unsuccessful transaction! Insufficient amount!";
        }catch (Exception e){
            message=e.getMessage();
        }
        return message;
    }
}
